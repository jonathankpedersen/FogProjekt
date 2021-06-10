package web.commands;

import business.Util.Conf;
import business.entities.Material;
import business.entities.Order;
import business.entities.OrderItems;
import business.exceptions.UserException;
import business.persistence.OrderItemsMapper;
import business.persistence.OrderMapper;
import business.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMaterialList extends CommandProtectedPage {
    MaterialFacade materialFacade;
    OrderFacade orderFacade;

    public CustomerMaterialList(String customermateriallist, String role) {
        super(customermateriallist, role);
        materialFacade = new MaterialFacade(database);
    }

    //TODO:OrderItems skal sendes med. Antal af materialer skal med andetsteds fra. Kan beregnes ud fra indsendte mål.
    //TODO:Lav en calculator i stedet for en facade der kan opnå dette
    //begynd beregning af hvor mange materialer ud fra eksisterende ordrer

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> materialList = materialFacade.getAllMaterial();
        OrderItemsFacade orderItemsFacade = new OrderItemsFacade(database);
        OrderMapper orderMapper = new OrderMapper(database);
        OrderItemsMapper orderItemsMapper = new OrderItemsMapper(database);
        //TODO: OrderItemsmapper og facade skal passe sammen
        Calculator calculator = new Calculator();
        int ordreId = Integer.parseInt(request.getParameter("orderid"));

        List<OrderItems> orderItemsList = new ArrayList<>();
        try {
            orderItemsList = orderItemsFacade.listOrderItemsByOrderId(ordreId);
            request.setAttribute("orderItems", orderItemsList);
            request.setAttribute("order", orderMapper.getOrderByOrderId(ordreId));
            System.out.println(orderItemsList);
        } catch (SQLException e) {
            //computing number of beams, poles and rafter

            try {
                Order order = orderMapper.getOrderByOrderId(ordreId);
                int numberOfBeams = calculator.getBeams(order.getLength());
                int numberOfPoles = calculator.getPoles(order.getLength());
                int numberOfRafters = calculator.getRafter(order.getLength());

                //orderItems1 = new OrderItems(15, 1, "Spær, monteres på rem", 630, 600);
                //(description, price, length, amount, Materialer_materiale_Id, ordre_Id)
                Material myRafter = materialFacade.getMaterialByName("spær_");
                Material myPole = materialFacade.getMaterialByName("stolpe_");
                Material myBeam = materialFacade.getMaterialByName("rem_");

                //int numOfMaterials, int materialeId, String description, int length, int ordreId, double price

                double calcPriceRafter = calculator.getMaterialPrice(myRafter.getPris_pr_enhed(), order.getWidth(), numberOfRafters);
                double calcPricePole = calculator.getMaterialPrice(myPole.getPris_pr_enhed(), order.getWidth(), numberOfPoles);
                double calcPriceBeam = calculator.getMaterialPrice(myBeam.getPris_pr_enhed(), order.getWidth(), numberOfBeams);

                OrderItems orderItemsRafter = orderItemsMapper.createOrderItem(numberOfRafters, myRafter.getMateriale_Id(), myRafter.getDescription(), order.getWidth(), order.getOrdreId(), calcPriceRafter);
                OrderItems orderItemsPole = orderItemsMapper.createOrderItem(numberOfPoles, myPole.getMateriale_Id(), myPole.getDescription(), order.getWidth(), order.getOrdreId(), calcPricePole);
                OrderItems orderItemsBeam = orderItemsMapper.createOrderItem(numberOfBeams, myBeam.getMateriale_Id(), myBeam.getDescription(), order.getWidth(), order.getOrdreId(), calcPriceBeam);

                orderItemsList.add(orderItemsRafter);
                orderItemsList.add(orderItemsPole);
                orderItemsList.add(orderItemsBeam);

                request.setAttribute("orderItemsList", orderItemsList);
                request.setAttribute("order", orderMapper.getOrderByOrderId(ordreId));

                //TODO: Find materialet via service

            } catch (SQLException | UserException s) {
                s.printStackTrace();
            }
        }

        //Det der kommer fra jsp er key-value
        //name = key, value = returværdien

        //TODO: Dynamisk beregning af spær
        //det skal kunne ses
        //TODO: Fremstil orderItems ved at kombinere materialer med de ønskede mål

        return pageToShow;
    }
}
