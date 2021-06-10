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
    //TODO: Lav url til test_database
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

        //TODO: Udregne ved hjælp af calculator: Pris = 80*7,8*2. Dette skal ind i pris.
        //int amount, int matId, String description, double price, int length
        orderItems = new OrderItems(2, "Remme til sider,sadles ned i stolper", 1248, 780);
        orderItems.setOrdreId(4);
        order.setStatus("Processing");
        orderMapper.updateOrderStatus(order);
        orderItems1 = new OrderItems(15, 1, "Spær, monteres på rem", 630, 600);
        orderItems1.setOrdreId(4);
        orderItems2 = new OrderItems(4, 3, "Stolper nedgraves 90 cm. i jord", 600, 300);
        orderItems2.setOrdreId(4);

        //int amount, int matId, int ordreItemId, String description, double price, int length, int ordreId
        //orderItems = new OrderItems(4,2, 6, "Remme til sider,sadles ned i stolper", 50, 780, 10);
        //orderItems = new OrderItems(45, 1, 4, "Spær, monteres på rem", 50, 600, 10);
        //orderItems = new OrderItems(4,4, 3, "Stolper nedgraves 90 cm. i jord", 50, 300, 10);

        //order = new Order(4567,50,1,780,600,false,"Created", 1);
        //order = new Order(1, 2, 780, 195, false, 50, "Created");
        //TODO: Lav i alt 3 orderItems, spær rem og stolpe
        //TODO: lav en ordre, og lave de tilsvarende 3 orderItems nu med amount og ordreId
        //TODO: amount gange pris. Lav manuel prisside

        //TODO: Lav test til beregneren af orderItems, stolper, remme og spær

    }

    @Test
    void createOrderItem() throws UserException {
        //arrayliste?
        //orderItemsMapper.createOrderItem(orderItems);
        //orderItemsMapper.createOrderItem(orderItems1);
        //orderItemsMapper.createOrderItem(orderItems2);


        //int matId, String description, double price, int length
        //orderItemsMapper.createOrderItem(orderItems);
        //assertEquals(1, orderItems.getLength());
        int price = (order.getLength()/55*2*70);
        System.out.println(price);

    }
    @Test
    void testGetOrderItemsByOrderId() throws SQLException {
        List<OrderItems> orderItemsList = orderItemsMapper.getOrderItemsByOrderId(4);
        System.out.println(orderItemsList);
    }
}