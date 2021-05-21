package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListOrderCommand extends CommandProtectedPage {
    OrderFacade orderFacade;

    public ListOrderCommand(String listorderpage, String role) {
        super(listorderpage, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        //TODO: Find all orders by customerID and return
        //TODO: Find en entitet-Order, check
        //TODO: Find facaden til entiten - Lav metoden
        //int customerId = request.getParameter("kundeId");
        try {
            List<Order> orderList = orderFacade.listOrderByCustomerId(1);
            request.setAttribute("orderlist", orderList);
        } catch (UserException u){
            u.printStackTrace();
        }



        return super.execute(request, response);
    }

}
