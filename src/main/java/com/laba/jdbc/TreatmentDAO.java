package com.laba.jdbc;

import com.laba.model.Treatment;

public class TreatmentDAO extends EntityDAO<Treatment> {

    @Override
    protected String getTableName() {
        return "treatments";
    }
}
