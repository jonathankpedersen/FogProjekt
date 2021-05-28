package business.persistence;

import business.entities.Order;
import business.entities.OrderItems;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsMapperTest {
    OrderItemsMapper orderItemsMapper;
    //TODO: Lav url til test_database
    Database database;
    OrderItems orderItems;
    Order order;
    private String USER = "dev";
    private String PASSWORD = "ax2";
    private String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";

    @BeforeEach
    void setUp() {
        orderItemsMapper = new OrderItemsMapper(database);
        orderItems = new OrderItems(2, "Remme til sider,sadles ned i stolper", 50, 780);
        orderItems = new OrderItems(1, "Spær, monteres på rem", 50, 600);
        orderItems = new OrderItems(4, "Stolper nedgraves 90 cm. i jord", 50, 300);

        //int amount, int matId, int ordreItemId, String description, double price, int length, int ordreId
        orderItems = new OrderItems(4,2, 6, "Remme til sider,sadles ned i stolper", 50, 780, 10);
        orderItems = new OrderItems(45, 1, 4, "Spær, monteres på rem", 50, 600, 10);
        orderItems = new OrderItems(4,4, 3, "Stolper nedgraves 90 cm. i jord", 50, 300, 10);
        //order = new Order(4567,50,1,780,600,false,"Created", 1);
        //order = new Order(1, 2, 780, 195, false, 50, "Created");
        //TODO: Lav i alt 3 orderItems, spær rem og stolpe
        //TODO: lav en ordre, og lave de tilsvarende 3 orderItems nu med amount og ordreId
        //TODO: amount gange pris. Lav manuel prisside

    }

    @Test
    void createOrderItem() throws UserException {

        //int matId, String description, double price, int length
        orderItemsMapper.createOrderItem(orderItems);
        assertEquals(1, orderItems.getLength());
    }
}