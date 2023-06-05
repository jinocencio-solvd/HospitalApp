package com.laba.jdbc;

import com.laba.model.Specialization;

public class SpecializationDAO extends EntityDAO<Specialization>{

    @Override
    protected String getTableName() {
        return "specialization";
    }
}
