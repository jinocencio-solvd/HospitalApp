package com.laba.jdbc;

import com.laba.models.Prescription;

public class PrescriptionDAO extends EntityDAO<Prescription>{


    @Override
    protected String getTableName() {
        return "prescriptions";
    }
}
