package business.persistence;

import business.entities.Order;
import business.entities.OrderItems;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsMapper {
    private Database database;

    public OrderItemsMapper(Database database) {
        this.database = database;
    }

    public void createOrderItem(OrderItems orderItems) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orderItem" +
                    " (description, price, length, amount, Materialer_materiale_Id, ordre_Id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, orderItems.getDescription());
                ps.setDouble(2, orderItems.getPrice());
                ps.setInt(3, orderItems.getLength());
                ps.setInt(4, orderItems.getAmount());
                ps.setInt(5, orderItems.getMatId());
                ps.setInt(6, orderItems.getOrdreId());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                orderItems.setOrdreItemId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Order> getOrderItemsByCustomerId(int id) throws UserException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM ordre WHERE Kunde_kunde_Id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int orderId = resultSet.getInt("ordre_Id");
                    double pris = resultSet.getDouble("prisTotal");
                    int length = resultSet.getInt("length");
                    int width = resultSet.getInt("width");
                    boolean shed = resultSet.getBoolean("shed");
                    String status = resultSet.getString("status");

                    Order order = new Order(orderId, id, length, width, shed, pris, status);
                    orders.add(order);

                }
                return orders;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Order> getAllOrderItems() throws UserException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM ordre";
            //TODO: Join med customertabel for at få navnet
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int orderId = resultSet.getInt("ordre_Id");
                    int kundeId = resultSet.getInt("Kunde_kunde_Id");
                    double pris = resultSet.getDouble("prisTotal");
                    int length = resultSet.getInt("length");
                    int width = resultSet.getInt("width");
                    boolean shed = resultSet.getBoolean("shed");
                    String status = resultSet.getString("status");

                    Order order = new Order(orderId, kundeId, length, width, shed, pris, status);
                    orders.add(order);

                }
                return orders;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }

    }

    public List<OrderItems> getOrderItemsByOrderId(int id) throws SQLException {
        List<OrderItems> orderItemsList = new ArrayList<>();
        //TODO: Join orderItem med kunde via ordre
        //lav query der joiner
        String sql = "SELECT * FROM orderItem WHERE ordre_Id = ?";
        Connection connection = database.connect();
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            String description = resultSet.getString("description");
            double price = resultSet.getDouble("price");
            int length = resultSet.getInt("length");
            int amount = resultSet.getInt("amount");
            int materials = resultSet.getInt("Materialer_materiale_Id");
            int ordre_Id = resultSet.getInt("ordre_Id");
            int orderItemId = resultSet.getInt("orderItem_Id");
            //int amount, int matId, String description, double price, int length
            OrderItems orderItems = new OrderItems(amount, materials, description, price, length);
            orderItems.setOrdreItemId(orderItemId);
            orderItemsList.add(orderItems);
        }

        return orderItemsList;
    }
}

