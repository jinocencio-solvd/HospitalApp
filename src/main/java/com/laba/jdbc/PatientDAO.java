package com.laba.jdbc;

import com.laba.models.Patient;

public class PatientDAO extends EntityDAO<Patient>{

    @Override
    protected String getTableName() {
        return "patients";
    }
}
