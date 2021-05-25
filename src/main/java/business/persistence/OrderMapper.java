package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database)
    {
        this.database = database;
    }

    public void createOrder(Order order) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO ordre (prisTotal, Kunde_kunde_Id, length, width, shed, status) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setDouble(1, order.getPrisTotal());
                ps.setInt(2, order.getKunde_kunde_Id());
                ps.setInt(3, order.getLength());
                ps.setInt(4,order.getWidth());
                ps.setBoolean(5, order.isShed());
                ps.setString(6, order.getStatus());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                order.setOrdreId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Order> getOrderByCustomerId(int id) throws UserException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM ordre WHERE Kunde_kunde_Id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {

                ps.setInt(1, id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    int orderId = resultSet.getInt("ordre_Id");
                    double pris = resultSet.getDouble("prisTotal");
                    int length = resultSet.getInt("length");
                    int width = resultSet.getInt("width");
                    boolean shed = resultSet.getBoolean("shed");
                    String status = resultSet.getString("status");

                    Order order = new Order(orderId,id,length, width, shed, pris, status);
                    orders.add(order);

                }
                return orders;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }


    }

    public List<Order> getAllOrders() throws UserException {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM ordre";
            //TODO: Join med customertabel for at få navnet
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    int orderId = resultSet.getInt("ordre_Id");
                    int kundeId = resultSet.getInt("Kunde_kunde_Id");
                    double pris = resultSet.getDouble("prisTotal");
                    int length = resultSet.getInt("length");
                    int width = resultSet.getInt("width");
                    boolean shed = resultSet.getBoolean("shed");
                    String status = resultSet.getString("status");

                    Order order = new Order(orderId, kundeId,length, width, shed, pris, status);
                    orders.add(order);

                }
                return orders;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }

    }

    public Order getOrderByOrderId(int id) throws SQLException {
        String sql = "SELECT * FROM ordre WHERE ordre_Id = ?";
        Connection connection = database.connect();
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        int kundeId = resultSet.getInt("Kunde_kunde_Id");
        double pris = resultSet.getDouble("prisTotal");
        int length = resultSet.getInt("length");
        int width = resultSet.getInt("width");
        boolean shed = resultSet.getBoolean("shed");
        String status = resultSet.getString("status");

        Order order = new Order(id, kundeId, length, width, shed, pris, status);


        return order;
    }

    //getAllOrders



}
