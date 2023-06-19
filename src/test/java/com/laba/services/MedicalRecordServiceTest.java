package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.utils.AppConfig;
import com.laba.utils.SQLScriptExecutor;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class MedicalRecordServiceTest {

    private static final MedicalRecordService medicalRecordService = new MedicalRecordService(
        DaoType.JDBC);

    @BeforeClass
    public void setup() {
        if (AppConfig.ENVIRONMENT.equals("GH_WORKFLOW")) {
            SQLScriptExecutor.processSQLiteScript("create");
            SQLScriptExecutor.processSQLiteScript("insert");
        }
    }

    @Test
    public void testGetMedicalRecordsForPatient() {
        Patient patient = new Patient(1, 1);
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsForPatient(
            patient);
        assertEquals(medicalRecords.size(), 7);
    }
}