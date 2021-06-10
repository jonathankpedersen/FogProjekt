package business.persistence;

import business.entities.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialMapperTest {
    MaterialMapper materialMapper;
    Database database;
    private String USER = "dev";
    private String PASSWORD = "ax2";
    private String URL = "jdbc:mysql://localhost:3306/fog?serverTimezone=CET";

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        materialMapper = new MaterialMapper(database);

    }

    @Test
    void getMaterialByName() {
        Material material = materialMapper.getMaterialByName("spær_");

        int expected = 1;
        int actual = material.getMateriale_Id();

        assertEquals(expected, actual);
    }
}