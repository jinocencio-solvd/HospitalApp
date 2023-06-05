package com.laba.jdbc;

import com.laba.model.Prescription;

public class PrescriptionDAO extends EntityDAO<Prescription>{


    @Override
    protected String getTableName() {
        return "prescription";
    }
}
