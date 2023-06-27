package com.laba.controllers;

import com.laba.models.DecoratedPatient;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.services.MedicalRecordService;
import com.laba.utils.AppConfig;
import com.laba.view.DecoratedPatientView;
import java.util.List;
import java.util.stream.Collectors;

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
        MedicalRecordService medicalRecordService = new MedicalRecordService(AppConfig.appDaoType);
        return medicalRecordService.getMedicalRecordsForPatient(p);
    }

    private String generateSimplePatientMedicalRecordsString() {
        StringBuilder sb = new StringBuilder();
        String patientName =
            model.getPatient().getPerson().getFirstName() + " "
                + model.getPatient().getPerson().getLastName();
        String body = model.getPatientMedicalRecords().stream()
            .map((mr) -> "Date - " + mr.getAppointment().getAppointmentDate()
                + System.lineSeparator()
                + " - Diagnosis - " + mr.getDiagnosis().getDescription() + System.lineSeparator()
                + " - Treatment - " + mr.getTreatment().getTreatmentName() + System.lineSeparator()
            ).collect(Collectors.joining());
        sb.append(patientName).append(System.lineSeparator()).append(body);
        return sb.toString();
    }

    public void generateSimplePatientMedicalRecordsSysOutView() {
        String data = generateSimplePatientMedicalRecordsString();
        view.simplePatientMedicalRecordsSysOutView(data);
    }

}
