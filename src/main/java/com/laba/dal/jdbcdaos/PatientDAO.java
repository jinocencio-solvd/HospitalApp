package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IPatientDAO;
import com.laba.models.Patient;
import com.laba.models.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO extends EntityDAO<Patient> implements IPatientDAO {

    @Override
    protected String getTableName() {
        return "patients";
    }

    @Override
    public Patient getPatientByPersonId(int personId) {
        Patient patient = new Patient();
        String query = "SELECT * FROM " + getTableName() + " WHERE person_id = " + personId;
        return retrieveEntity(query, patient);
    }

}
