package com.laba.services;

import static org.testng.Assert.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.Patient;
import com.laba.models.Person;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class PatientServiceTest {

    private static PatientService patientService;
    private static PersonService personService;

    @Factory(dataProvider = "dataProvider")
    public PatientServiceTest(DaoType daoType) {
        patientService = new PatientService(daoType);
        personService = new PersonService(daoType);
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] testData() {
        return new Object[][]{
            {DaoType.JDBC},
            {DaoType.MYBATIS}
        };
    }

    @Test
    public void testGetPatientByPersonId() {
        Person person = personService.getById(1);
        Patient patient = patientService.getPatientByPersonId(person.getId());
        assertEquals(patient.getPersonId(), person.getId());
    }

}