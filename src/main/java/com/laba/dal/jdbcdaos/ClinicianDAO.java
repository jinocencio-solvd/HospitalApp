package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IClinicianDAO;
import com.laba.models.Clinician;
import java.util.List;

public class ClinicianDAO extends EntityDAO<Clinician> implements IClinicianDAO {

    @Override
    protected String getTableName() {
        return "clinicians";
    }

    @Override
    public List<Clinician> getCliniciansByDepartmentId(int departmentId) {
        String query = "SELECT * FROM clinicians"
            + " JOIN appointments a on clinicians.id = a.clinician_id"
            + " JOIN rooms r on r.id = a.room_id"
            + " JOIN departments d on d.id = r.department_id"
            + " WHERE d.id = " + departmentId;
        return retrieveEntities(query);
    }

}
