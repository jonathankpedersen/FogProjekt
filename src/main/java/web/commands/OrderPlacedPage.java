package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPlacedPage extends CommandProtectedPage {
    public OrderPlacedPage(String orderplaced, String customer) {
        super(orderplaced, customer);
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return pageToShow;
    }
}
