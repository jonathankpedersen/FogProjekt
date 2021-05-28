package business.services;

import business.entities.Order;
import business.entities.OrderItems;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderItemsMapper;
import business.persistence.OrderMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsFacade {
    OrderItemsMapper orderItemsMapper;
    OrderItems orderItems;
    //double pris; //Ændres til udregning af prisen

    public OrderItemsFacade(Database database /*double pris*/)
    {
        orderItemsMapper = new OrderItemsMapper(database);
        //this.pris = pris;
    }

    public OrderItems createOrderItems(int kundeId, int length, int width, boolean shed) {

        //Order order = new Order(pris, kunde_kunde_Id, carport_carport_Id, "Active");
        //orderMapper.createOrder(order);
        //OrderItems order = new OrderItems(kundeId, length, width, shed);
        OrderItems orderItems = null;
        try {
            orderItemsMapper.createOrderItem(orderItems);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    public List<OrderItems> listOrderItemsByCustomerId(int id) throws UserException {
        List<OrderItems> orderItemsList = new ArrayList<>();
        try {


            orderItemsList = orderItemsMapper.getOrderItemsByOrderId(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orderItemsList;
    }

    public List<Order> listAllOrderItems() throws UserException {
        List<Order> orderList = new ArrayList<>();
        orderList = orderItemsMapper.getAllOrderItems();

        return orderList;
    }

    public Order listOrderItemsByOrderId(int id) throws UserException, SQLException {
        //Order order = orderItemsMapper.getOrderItemsByOrderId(id);
Order order = null;
        return order;
    }
}
