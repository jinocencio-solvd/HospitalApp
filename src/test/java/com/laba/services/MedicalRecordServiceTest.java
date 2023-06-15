package com.laba.services;

import static org.testng.Assert.*;

import com.laba.models.Patient;
import com.laba.utils.SQLiteUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class MedicalRecordServiceTest {
    private static final MedicalRecordService medicalRecordService = new MedicalRecordService();

    @Test
    public void testGetMedicalRecordsForPatient() {
        Patient patient = new Patient(1,1);
        medicalRecordService.getMedicalRecordsForPatient(patient);
    }

    @AfterSuite
    public void cleanup(){
        SQLiteUtils.processSQLiteScript("create");
        SQLiteUtils.processSQLiteScript("insert");
    }
}