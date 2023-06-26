package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IPrescriptionDAO;
import com.laba.models.Prescription;
import java.util.List;

public class PrescriptionDAO extends EntityDAO<Prescription> implements IPrescriptionDAO {

    @Override
    protected String getTableName() {
        return "prescriptions";
    }

    @Override
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        String query = "SELECT *\n"
            + "FROM prescriptions\n"
            + "JOIN medical_records mr on prescriptions.treatment_id = mr.treatment_id\n"
            + "JOIN appointments a on a.id = mr.appointment_id\n"
            + "JOIN patients p on p.id = a.patient_id\n"
            + "WHERE p.id = " + patientId;
        return retrieveEntities(query);
    }

}
