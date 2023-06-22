package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IDiagnosisDAO;
import com.laba.models.Diagnosis;
import java.util.List;

public class DiagnosisDAO extends EntityDAO<Diagnosis> implements IDiagnosisDAO {

    @Override
    protected String getTableName() {
        return "diagnosis";
    }

    @Override
    public List<Diagnosis> getDiagnosisByDepartmentId(int departmentId) {
        String query = "SELECT *"
            + " FROM diagnosis"
            + " JOIN medical_records mr on diagnosis.id = mr.diagnosis_id"
            + " JOIN appointments a on a.id = mr.appointment_id"
            + " JOIN rooms r on r.id = a.room_id"
            + " JOIN departments d on d.id = r.department_id"
            + " WHERE d.id = " + departmentId;
        return retrieveEntities(query);
    }

}
