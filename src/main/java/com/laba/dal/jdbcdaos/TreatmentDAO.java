package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.ITreatmentDAO;
import com.laba.models.Treatment;
import java.util.List;

public class TreatmentDAO extends EntityDAO<Treatment> implements ITreatmentDAO {

    @Override
    protected String getTableName() {
        return "treatments";
    }

    @Override
    public List<Treatment> getTreatmentsByPatientId(int patientId) {
        String query = "SELECT *\n"
            + "FROM treatments\n"
            + "JOIN medical_records mr on treatments.id = mr.treatment_id\n"
            + "JOIN appointments a on a.id = mr.appointment_id\n"
            + "JOIN patients p on p.id = a.patient_id\n"
            + "WHERE p.id = " + patientId;
        return retrieveEntities(query);
    }

}
