package com.laba.jdbc;

import com.laba.models.Specialization;

public class SpecializationDAO extends EntityDAO<Specialization> {

    @Override
    protected String getTableName() {
        return "specializations";
    }
}
