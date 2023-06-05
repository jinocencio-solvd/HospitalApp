package com.laba.jdbc;

import com.laba.model.Patient;

public class PatientDAO extends EntityDAO<Patient>{

    @Override
    protected String getTableName() {
        return "patients";
    }
}
