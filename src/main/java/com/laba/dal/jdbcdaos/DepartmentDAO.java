package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IDepartmentDAO;
import com.laba.models.Department;
import java.util.List;

public class DepartmentDAO extends EntityDAO<Department> implements IDepartmentDAO {

    @Override
    protected String getTableName() {
        return "departments";
    }

    @Override
    public List<Department> getDepartmentsByClinicianId(int clinicianId) {
        String query = "SELECT * FROM departments"
            + " JOIN rooms r on departments.id = r.department_id"
            + " JOIN appointments a on r.id = a.room_id"
            + " JOIN clinicians c on c.id = a.clinician_id"
            + " WHERE c.id = " + clinicianId;
        return retrieveEntities(query);
    }

}
