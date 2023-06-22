package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IMedicationDAO;
import com.laba.models.Medication;
import java.util.List;

public class MedicationDAO extends EntityDAO<Medication> implements IMedicationDAO {

    @Override
    protected String getTableName() {
        return "medications";
    }

    @Override
    public List<Medication> getMedicationsByPatientId(int patientId) {
        String query = "SELECT DISTINCT m.*\n"
            + "FROM medications m\n"
            + "         JOIN prescriptions p ON m.id = p.medication_id\n"
            + "         JOIN treatments t ON p.treatment_id = t.id\n"
            + "         JOIN medical_records mr ON t.id = mr.treatment_id\n"
            + "         JOIN appointments a ON mr.appointment_id = a.id\n"
            + "         JOIN patients pt ON a.patient_id = pt.id\n"
            + "WHERE pt.id = " + patientId;
        return retrieveEntities(query);
    }

}
