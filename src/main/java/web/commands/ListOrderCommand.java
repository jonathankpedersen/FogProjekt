package web.commands;

import business.services.CalculateOrderItems;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ListOrderCommand extends CommandProtectedPage {
    OrderFacade orderFacade;

    public ListOrderCommand(String listorderpage, String role) {
        super(listorderpage, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        //TODO: Find all orders by customerID and return
        //TODO: Find en entitet-Order, check
        //TODO: Find facaden til entiten - Lav metoden
        //int customerId = request.getParameter("kundeId");

        try {
            List<Order> orderList = orderFacade.listOrderByCustomerId(1);
            request.setAttribute("orderlist", orderList);
            /*List<Integer> priceList = new ArrayList<>();
            for (int i = 0; i < orderList.size(); i++){
                CalculateOrderItems calc = new CalculateOrderItems(orderList.get(i).getLength(), 50);
                int price = calc.calculatePrice();
                priceList.add(price);
            }
            request.setAttribute("priceList", priceList);*/

        } catch (UserException u){
            u.printStackTrace();
        }
        try {


            int orderId = Integer.parseInt(request.getParameter("orderId"));
            Order order = orderFacade.listOrderByOrderId(orderId);
            CalculateOrderItems calc = new CalculateOrderItems(order.getLength(), 50);
            int price = calc.calculatePrice();
            request.setAttribute("price", price);

        }catch (SQLException | UserException e){
            e.printStackTrace();
        }

        return super.execute(request, response);
    }

}
