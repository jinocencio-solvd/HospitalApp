package com.laba.utils;

import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.services.MedicalRecordService;
import java.util.List;

public class HospitalUtils {

    public static void generateXmlPatientMedicalRecords(Patient p) {
        List<MedicalRecord> patientMedicalRecords = MedicalRecordService.getInstance()
            .getMedicalRecordsForPatient(p);

    }
}
