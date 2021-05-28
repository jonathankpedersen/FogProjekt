package web.commands;

import business.entities.Order;
import business.entities.OrderItems;
import business.entities.SimpleOrder;
import business.exceptions.UserException;
import business.services.MaterialFacade;
import business.services.OrderFacade;
import business.services.UserFacade;

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
    //Har materialeliste og ordre
//TODO: Materialfacade skal virke
    //Der skal komme ordreID ind et sted
    //TODO:OrderItems skal sendes med. Antal af materialer skal med andetsteds fra. Kan beregnes ud fra indsendte mål.
    //TODO:Lav en calculator i stedet for en facade der kan opnå dette
    //Forstå flow, begynd beregning af hvor mange materialer ud fra eksisterende ordrer
    //Materiale og

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> materialList = materialFacade.getAllMaterial();
        //TODO: Dynamisk beregning af spær
        //det skal kunne ses

        //SimpleOrder simpleOrder = new SimpleOrder(1,1,600, 780);
        //TODO: Hent ordreId fra requestobjektet
        //TODO: Det vil sige: google jsp retrieve value from radio button
        //TODO: Fremstil orderItems ved at kombinere materialer med de ønskede mål
        //TODO: Lav en beregner som beregner antallet af spær ud fra den ønskede længde
        try {

            Order order = orderFacade.listOrderByOrderId(1);

            List<OrderItems> orderedItems = new ArrayList<>();
            //materialliste skal lave en ny
            request.setAttribute("matList", materialList);
        } catch (SQLException | UserException e){
            e.getMessage();
        }

        return pageToShow;
    }
}
