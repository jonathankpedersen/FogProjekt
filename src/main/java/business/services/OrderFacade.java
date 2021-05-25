package business.services;

import business.entities.Carport;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;
import business.persistence.UserMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderFacade {
    OrderMapper orderMapper;
    //double pris; //Ændres til udregning af prisen

    public OrderFacade(Database database /*double pris*/)
    {
        orderMapper = new OrderMapper(database);
        //this.pris = pris;
    }

    public Order createOrder(int kundeId, int length, int width, boolean shed) {

        //Order order = new Order(pris, kunde_kunde_Id, carport_carport_Id, "Active");
        //orderMapper.createOrder(order);
        Order order = new Order(kundeId, length, width, shed);
        try {
            orderMapper.createOrder(order);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> listOrderByCustomerId(int id) throws UserException {
        List<Order> orderList = new ArrayList<>();
        orderList = orderMapper.getOrderByCustomerId(id);

        return orderList;
    }

    public List<Order> listAllOrders() throws UserException {
        List<Order> orderList = new ArrayList<>();
        orderList = orderMapper.getAllOrders();

        return orderList;
    }

    public Order listOrderByOrderId(int id) throws UserException, SQLException {
        Order order = orderMapper.getOrderByOrderId(id);

        return order;
    }
}
