package business.persistence;

import business.entities.Material;

import java.sql.*;

public class MaterialMapper {
    Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public Material getMaterialByName(String name) {
        Material material = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM materialer WHERE navn LIKE ?";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name + "%");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int materialeId = resultSet.getInt("materiale_Id");
                String enhed = resultSet.getString("enhed");
                double pris_pr_enhed = resultSet.getDouble("pris_pr_enhed");
                String description = resultSet.getString("description");

                material = new Material(materialeId, name, enhed, pris_pr_enhed, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return material;
    }
}
