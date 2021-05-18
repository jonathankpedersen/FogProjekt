package business.persistence;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

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
            String sql = "INSERT INTO orders (prisTotal, Kunde_kunde_Id, Carport_carport_Id, status) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setDouble(1, order.getPrisTotal());
                ps.setInt(2, order.getKunde_kunde_Id());
                ps.setInt(3,order.getCarport_carport_Id());
                ps.setString(4, order.getStatus());
                ps.executeUpdate();
                /*ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                order.setOrdre_Id(id);*/
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


}
