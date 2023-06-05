package com.laba.jdbc;

import com.laba.models.Medication;

public class MedicationDAO extends EntityDAO<Medication> {

    @Override
    protected String getTableName() {
        return "medications";
    }

}
