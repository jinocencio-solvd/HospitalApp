package com.laba.interfaces.services;

import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import java.util.List;

public interface IMedicalRecordService extends IEntityService<MedicalRecord> {

    List<MedicalRecord> getMedicalRecordsForPatient(Patient p);
}
