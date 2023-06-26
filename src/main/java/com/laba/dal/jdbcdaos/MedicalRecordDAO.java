package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IMedicalRecordDAO;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import java.util.List;

public class MedicalRecordDAO extends EntityDAO<MedicalRecord> implements IMedicalRecordDAO {

    @Override
    protected String getTableName() {
        return "medical_records";
    }

    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        String query = "SELECT * FROM " + getTableName()
            + " JOIN appointments a on a.id = medical_records.appointment_id"
            + " JOIN patients p on p.id = a.patient_id"
            + " WHERE p.id = " + p.getId();
        return retrieveEntities(query);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId) {
        String query = "SELECT * FROM " + getTableName()
            + " JOIN appointments a on a.id = medical_records.appointment_id"
            + " WHERE a.id = " + appointmentId;
        return retrieveEntities(query);
    }

}
