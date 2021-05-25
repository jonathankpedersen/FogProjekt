package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {
    OrderMapper orderMapper;
    Database database;
    private String USER = "dev";
    private String PASSWORD = "ax2";
    private String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";


    @Test
    void createOrder() throws UserException {
        Order order = new Order(2, 780, 600,false);
        orderMapper.createOrder(order);

        assertEquals(1, order.getLength());
    }

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD,URL);
        //TODO: Lav en testdatabase, skal køre beforeeach
        orderMapper = new OrderMapper(database);
    }

    @Test
    void testGetOrders() throws UserException {
        List<Order> orderList = orderMapper.getOrderByCustomerId(1);
        assertEquals(1, orderList.get(0).getLength());

    }
}