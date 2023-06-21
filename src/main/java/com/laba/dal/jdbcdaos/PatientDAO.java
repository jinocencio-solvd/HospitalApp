package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IPatientDAO;
import com.laba.models.Patient;

public class PatientDAO extends EntityDAO<Patient> implements IPatientDAO {

    @Override
    protected String getTableName() {
        return "patients";
    }

    @Override
    public Patient getPatientByPersonId(int personId) {
        // TODO: impl JDBC method
        return null;
    }
}
