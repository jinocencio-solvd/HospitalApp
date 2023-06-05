package com.laba.jdbc;

import com.laba.models.Staff;

public class StaffDAO extends EntityDAO<Staff>{

    @Override
    protected String getTableName() {
        return "staff";
    }
}
