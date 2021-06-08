package business.persistence;

import business.entities.Material;

public class MaterialMapper {
    Database database;

    public MaterialMapper(Database database) {
        this.database = database;
    }

    public Material getMaterialByName(String name) {
        //copypaste sql
        //select * from material where name like "spær_%"
        //Tilføj kolonne type?
        Material material = null;

        return material;
    }
}
