package com.laba.controllers.controller;

import com.laba.enums.DaoType;
import com.laba.models.DecoratedPatient;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.services.MedicalRecordService;
import com.laba.view.DecoratedPatientView;
import java.util.List;

public class DecoratedPatientController extends
    EntityController<DecoratedPatient, DecoratedPatientView> {

    public DecoratedPatientController(DecoratedPatient model, DecoratedPatientView view) {
        super(model, view);
    }

    public static DecoratedPatient getDecoratedPatient(Patient patient) {
        DecoratedPatient dPatient = new DecoratedPatient(patient);
        dPatient.setMedicalRecords(getPatientMedicalRecords(patient));
        return dPatient;
    }

    private static List<MedicalRecord> getPatientMedicalRecords(Patient p) {
        MedicalRecordService medicalRecordService = new MedicalRecordService(DaoType.MYBATIS);
        return medicalRecordService.getMedicalRecordsForPatient(p);
    }

}
