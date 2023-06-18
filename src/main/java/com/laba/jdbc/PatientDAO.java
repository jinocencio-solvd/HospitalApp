package com.laba.jdbc;

import com.laba.interfaces.daos.IPatientDAO;
import com.laba.models.Patient;

public class PatientDAO extends EntityDAO<Patient> implements IPatientDAO {

    @Override
    protected String getTableName() {
        return "patients";
    }
}
