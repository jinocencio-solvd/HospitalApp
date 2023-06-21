package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.models.Patient;
import com.laba.utils.AppUtils;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class PatientServiceTest {

    private static PatientService patientService;

    @BeforeClass
    public void before() {
        AppUtils.initializeDB();
    }

    @AfterClass
    public void after() {
        AppUtils.populateDB();
    }

    @BeforeMethod
    public void setUp() {
        patientService = new PatientService(DaoType.JDBC);
    }

    @AfterMethod
    public void tearDown() {
        List<Patient> getAllPatient = patientService.getAll();
        getAllPatient.forEach((p) -> patientService.deleteById(p.getId()));
    }
}