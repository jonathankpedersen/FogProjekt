package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderCommand extends CommandProtectedPage {
    private OrderFacade orderFacade;

    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int kundeId;
        HttpSession session = request.getSession();
        int length;
        int width;
        boolean shed;
        Order order;

        try {
            kundeId = ((int) session.getAttribute("kundeId"));

            length = Integer.parseInt(request.getParameter("length"));
            width = Integer.parseInt(request.getParameter("width"));
            shed = Boolean.parseBoolean(request.getParameter("shed"));
            order = orderFacade.createOrder(kundeId, length, width, shed);

        } catch (NumberFormatException e) {
            kundeId = 1;
            length = 0;
            width = 0;
            shed = false;
            order = null;


            try {
                List<Order> orderList = orderFacade.listOrderByCustomerId(kundeId);
                request.setAttribute("orderlist", orderList);
            } catch (UserException u) {
                u.printStackTrace();
            }


        }
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("shed", shed);

        //TODO:Add error message for general issues e.g. "Something went wrong"
        //TODO:Add error message for invalid chararacters such as letter instead of numbers e.g. "Please enter numbers"
        //TODO:Add clarification for unit to be used for the customers measurements
        return pageToShow;
    }
}

