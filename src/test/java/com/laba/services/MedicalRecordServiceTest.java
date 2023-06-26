package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class MedicalRecordServiceTest {

    private static MedicalRecordService medicalRecordService;

    @Factory(dataProvider = "dataProvider")
    public MedicalRecordServiceTest(DaoType daoType) {
        medicalRecordService = new MedicalRecordService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testGetMedicalRecordsForPatient(DaoType daoType) {
        Patient patient = new PatientService(daoType).getPatientByPersonId(1);
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsForPatient(
            patient);
        assertEquals(medicalRecords.size(), 7);
    }

}