package com.laba.controllers;

import static org.testng.AssertJUnit.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.DecoratedPatient;
import com.laba.models.Patient;
import com.laba.services.PatientService;
import com.laba.utils.json.JacksonUtil;
import com.laba.view.DecoratedPatientView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DecoratedPatientControllerTest {

    private DecoratedPatientController decoratedPatientController;
    private DecoratedPatient dPatient;

    @BeforeMethod
    public void setUp() {
        Patient patient = new PatientService(DaoType.MYBATIS).getById(1);
        dPatient = DecoratedPatientController.getDecoratedPatient(patient);
        DecoratedPatientView patientView = new DecoratedPatientView();

        decoratedPatientController = new DecoratedPatientController(dPatient, patientView);
    }

    @Test
    public void testGetDecoratedPatient() {
        assertEquals(dPatient.getPatientMedicalRecords().size(), 4);
    }

    @Test
    public void testGenerateSystemOutView() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        decoratedPatientController.generateSystemOutView();
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, dPatient.toString());
    }

    @Test
    public void testGenerateJsonApiView() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        decoratedPatientController.generateJsonApiView();
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, JacksonUtil.toJsonString(dPatient));
    }

}