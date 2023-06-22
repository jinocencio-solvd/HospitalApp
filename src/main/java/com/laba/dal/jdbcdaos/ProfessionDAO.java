package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IProfessionDAO;
import com.laba.models.Profession;
import java.util.List;

public class ProfessionDAO extends EntityDAO<Profession> implements IProfessionDAO {

    @Override
    protected String getTableName() {
        return "professions";
    }

    @Override
    public List<Profession> getProfessionByDepartmentId(int departmentId) {
        String query = "SELECT *\n"
            + "FROM professions\n"
            + "JOIN clinicians c on professions.id = c.profession_id\n"
            + "JOIN appointments a on c.id = a.clinician_id\n"
            + "JOIN rooms r on r.id = a.room_id\n"
            + "JOIN departments d on d.id = r.department_id\n"
            + "WHERE d.id = " + departmentId;
        return retrieveEntities(query);
    }

}
