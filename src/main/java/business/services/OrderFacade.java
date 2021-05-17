package business.services;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;
import business.persistence.UserMapper;

public class OrderFacade {
    OrderMapper orderMapper;
    double pris; //Ændres til udregning af prisen

    public OrderFacade(Database database, double pris)
    {
        orderMapper = new OrderMapper(database);
        this.pris = pris;
    }

    public Order createOrder() throws UserException
    {
        Order order = new Order(pris, kunde_kunde_Id, carport_carport_Id, "Active");
        orderMapper.createOrder(order);
        return order;
    }
}
