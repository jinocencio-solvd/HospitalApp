package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IMedicalRecordDAO;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import java.util.List;

public class MedicalRecordDAO extends EntityDAO<MedicalRecord> implements IMedicalRecordDAO {

    @Override
    public List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId) {
        return session.selectList(getNamespace() + ".getMedicalRecordsByAppointmentId",
            appointmentId);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        // TODO
        return null;
    }

}
