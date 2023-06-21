package com.laba.services.mybatis;

import static org.testng.AssertJUnit.assertEquals;

import com.laba.enums.DaoType;
import com.laba.models.Patient;
import com.laba.models.Person;
import com.laba.services.PatientService;
import com.laba.services.PersonService;
import com.laba.utils.AppUtils;
import java.sql.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PatientServiceMyBatisTest {

    private static PatientService patientService;
    private static PersonService personService;

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
        patientService = new PatientService(DaoType.MYBATIS);
        personService = new PersonService(DaoType.MYBATIS);
    }

    @AfterMethod
    public void tearDown() {
        personService.getAll().forEach((p) -> personService.deleteById(p.getId()));
        patientService.getAll().forEach((p) -> patientService.deleteById(p.getId()));
    }

    @Test
    public void testGetPatientByPersonId() {
        Person futurePatient = new Person("p1Patient", "p1Last", Date.valueOf("2000-01-01"));
        personService.save(futurePatient);

        Person retPerson = personService.getByFirstLastNameAndDob(futurePatient.getFirstName(),
            futurePatient.getLastName(), futurePatient.getDob());
        assertEquals(futurePatient, retPerson);

        Patient patientToSave = new Patient(null, retPerson.getId());
        patientService.save(patientToSave);

        Patient retPatient = patientService.getPatientByPersonId(retPerson.getId());
        assertEquals(retPatient.getPerson(), retPerson);
    }
}
