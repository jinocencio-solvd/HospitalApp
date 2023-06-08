package com.laba.jdbc;

import com.laba.models.Department;

public class DepartmentDAO extends EntityDAO<Department> {

    @Override
    protected String getTableName() {
        return "departments";
    }

}
