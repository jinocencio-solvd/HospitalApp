package com.laba.view;


import static org.testng.Assert.assertEquals;

import com.laba.controllers.DecoratedPatientController;
import com.laba.enums.DaoType;
import com.laba.models.DecoratedPatient;
import com.laba.models.Patient;
import com.laba.services.PatientService;
import com.laba.utils.json.JacksonUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DecoratedPatientViewTest {

    private DecoratedPatient dPatient;
    private DecoratedPatientView dPatientView;

    @BeforeMethod
    public void setUp() {
        Patient patient = new PatientService(DaoType.MYBATIS).getById(1);
        dPatient = DecoratedPatientController.getDecoratedPatient(patient);
        dPatientView = new DecoratedPatientView();
    }

    @Test
    public void testSystemOutView() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dPatientView.logOutView(dPatient.toString());
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, dPatient.toString());
    }

    @Test
    public void testJsonApiView() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dPatientView.jsonApiView(JacksonUtil.toJsonString(dPatient));
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, JacksonUtil.toJsonString(dPatient));
    }

}