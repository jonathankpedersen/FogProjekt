package web.commands;

import business.Util.Conf;
import business.entities.Material;
import business.entities.Order;
import business.entities.OrderItems;
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
        Calculator calculator = new Calculator();
        int ordreId = Integer.parseInt(request.getParameter("orderid"));

        List<OrderItems> orderItemsList = new ArrayList<>();
        try {
            orderItemsList = orderItemsFacade.listOrderItemsByOrderId(ordreId);
            request.setAttribute("orderItems", orderItemsList);
            System.out.println(orderItemsList);
        } catch (SQLException e) {
            //computing number of beams, poles and rafter

            try {
                Order order = orderMapper.getOrderByOrderId(ordreId);
                int numberOfBeams = calculator.getBeams(order.getLength());
                int numberOfPoles = calculator.getPoles(order.getLength());
                int numberOfRafters = calculator.getRafter(order.getLength());

                //orderItems1 = new OrderItems(15, 1, "Spær, monteres på rem", 630, 600);
                Material myRafter = materialFacade.getMaterialByName("spær_");
                //spørg Thorbjørn
                OrderItems orderItems = orderItemsFacade.createOrderItems(numberOfBeams, order.getKunde_Id(), myRafter.getDescription(), Conf.DEFAULTRAFTERLENGTH);

                //TODO:Tilføj description i materiale, og i database
                //TODO: Find materialet via service

            } catch (SQLException s) {
                s.printStackTrace();
            }
        }


        //TODO: Hvis itemList ikke findes, kan orderItems laves i try-catchen
        //TODO: Hvis den ikke har en liste, så skal vi have en calculateOrderItems.

        //TODO: Beregn antal og prisen på det antal enheder der laves.
        //TODO: Lav en calculator som kan returnere dette

        //Det der kommer fra jsp er key-value
        //name = key, value = returværdien

        //TODO: Dynamisk beregning af spær
        //det skal kunne ses
        //TODO: Fremstil orderItems ved at kombinere materialer med de ønskede mål


        return pageToShow;
    }
}
