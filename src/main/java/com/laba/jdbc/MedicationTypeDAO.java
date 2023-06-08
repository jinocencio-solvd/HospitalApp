package com.laba.jdbc;

import com.laba.models.MedicationType;

public class MedicationTypeDAO extends EntityDAO<MedicationType> {

    @Override
    protected String getTableName() {
        return "medication_types";
    }

}
