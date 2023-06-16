package com.laba.services;

import static org.testng.Assert.*;

import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.utils.AppConfig;
import com.laba.utils.SQLiteUtils;
import java.util.List;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MedicalRecordServiceTest {
    private static final MedicalRecordService medicalRecordService = new MedicalRecordService();

    @BeforeClass
    public void setup(){
        if(AppConfig.ENVIRONMENT.equals("GH_WORKFLOW")){
            SQLiteUtils.processSQLiteScript("create");
            SQLiteUtils.processSQLiteScript("insert");
        }
    }

    @Test
    public void testGetMedicalRecordsForPatient() {
        Patient patient = new Patient(1,1);
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsForPatient(patient);
        assertEquals(medicalRecords.size(), 7);
    }
}