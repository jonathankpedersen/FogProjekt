package business.services;

import business.entities.Material;
import business.persistence.Database;
import business.persistence.MaterialMapper;

import java.util.ArrayList;
import java.util.List;

public class MaterialFacade {
    Database database;
    MaterialMapper materialMapper;

    public MaterialFacade(Database database) {
        this.database = database;
        this.materialMapper = new MaterialMapper(database);

    }

    public List getAllMaterial() {
        List<String> materialList = new ArrayList<>();
        //List<Material> materialList = new ArrayList<>();

        String pole = "97x97-trykimp_Stolpe-300-Stolper-nedgraves_90_cm_i_jord";
        String beam = "45x19-spærtræ_ubh-600-Rem-Remme_i_sider_sadles_ned_i_stolper";
        String rafters = "45x195-spærtræ_ubh-600-Spær-Monteres_på_rem";

        materialList.add(pole);
        materialList.add(beam);
        materialList.add(rafters);

        return materialList;
    }

    public Material getMaterialByName(String name) {
        Material material = materialMapper.getMaterialByName(name);

        return material;
    }

}
