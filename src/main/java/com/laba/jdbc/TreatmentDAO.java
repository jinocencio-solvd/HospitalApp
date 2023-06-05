package com.laba.jdbc;

import com.laba.models.Treatment;

public class TreatmentDAO extends EntityDAO<Treatment> {

    @Override
    protected String getTableName() {
        return "treatments";
    }
}
