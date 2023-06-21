package com.laba.services.mybatis;

import static org.testng.AssertJUnit.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.MedicalRecord;
import com.laba.services.MedicalRecordService;
import com.laba.utils.AppUtils;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MedicalRecordMyBatisTest {

    private static MedicalRecordService medicalRecordService;

    @BeforeClass
    public void before() {
        AppUtils.populateDb();
    }

    @BeforeMethod
    public void setUp() {
        medicalRecordService = new MedicalRecordService(DaoType.MYBATIS);
    }

    @Test
    public void testGetMedicalRecordsByAppointmentId() {
        List<MedicalRecord> medRecs = medicalRecordService.getMedicalRecordsByAppointmentId(1);
        List<MedicalRecord> medRecApptId8 = medicalRecordService.getMedicalRecordsByAppointmentId(8);
        assertEquals(medRecApptId8.get(0).getTreatmentId(), 3);
        assertEquals(medRecs.size(), 4);

    }
}
