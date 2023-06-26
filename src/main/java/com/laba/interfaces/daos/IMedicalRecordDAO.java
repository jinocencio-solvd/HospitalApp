package com.laba.interfaces.daos;

import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import java.util.List;

public interface IMedicalRecordDAO extends IEntityDAO<MedicalRecord> {

    List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId);

    List<MedicalRecord> getMedicalRecordsForPatient(Patient p);

}
