package business.persistence;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CarportMapper {
    private Database database;

    public CarportMapper(Database database)
    {
        this.database = database;
    }

    public void createCarport(Carport carport) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders (length, width, shed) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, carport.getLength());
                ps.setString(2, carport.getWidth());
                ps.setString(3,carport.getShed());
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
