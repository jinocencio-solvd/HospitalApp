package com.laba.jdbc;

import com.laba.model.Medication;

public class MedicationDAO extends EntityDAO<Medication> {

    @Override
    protected String getTableName() {
        return "medication";
    }

}
