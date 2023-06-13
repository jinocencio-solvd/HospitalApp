package com.laba.services;

import static org.testng.Assert.*;

import com.laba.models.Patient;
import org.testng.annotations.Test;

public class MedicalRecordServiceTest {
    private static final MedicalRecordService medicalRecordService = MedicalRecordService.getInstance();

    @Test
    public void testGetMedicalRecordsForPatient() {
        Patient patient = new Patient(1,1);
        medicalRecordService.getMedicalRecordsForPatient(patient);
    }
}