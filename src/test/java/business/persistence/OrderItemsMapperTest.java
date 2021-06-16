package business.persistence;

import business.entities.Order;
import business.entities.OrderItems;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsMapperTest {
    OrderItemsMapper orderItemsMapper;
    Database database;
    OrderItems orderItems, orderItems1, orderItems2;
    Order order;
    OrderMapper orderMapper;
    private String USER = "dev";
    private String PASSWORD = "ax2";
    private String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        orderItemsMapper = new OrderItemsMapper(database);
        orderMapper = new OrderMapper(database);
        //int kunde_Id,int length, int width, boolean shed
        order = new Order(1, 600, 780, false);
        order.setOrdreId(4);

        //int amount, int matId, String description, double price, int length
        orderItems = new OrderItems(2, "Remme til sider,sadles ned i stolper", 1248, 780);
        orderItems.setOrdreId(4);
        order.setStatus("Processing");
        orderMapper.updateOrderStatus(order);
        orderItems1 = new OrderItems(15, 1, "Spær, monteres på rem", 630, 600);
        orderItems1.setOrdreId(4);
        orderItems2 = new OrderItems(4, 3, "Stolper nedgraves 90 cm. i jord", 600, 300);
        orderItems2.setOrdreId(4);

    }

    @Test
    void createOrderItem() throws UserException {
        int price = (order.getLength()/55*2*70);
        System.out.println(price);

    }
    @Test
    void testGetOrderItemsByOrderId() throws SQLException {
        List<OrderItems> orderItemsList = orderItemsMapper.getOrderItemsByOrderId(4);
        System.out.println(orderItemsList);
    }
}