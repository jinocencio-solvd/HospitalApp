package com.laba.jdbc;

import com.laba.model.Department;
import java.util.LinkedHashMap;
import java.util.Map;

public class DepartmentDAO extends EntityDAO<Department> {

    @Override
    protected String getTableName() {
        return "departments";
    }

    @Override
    protected Department createModelFromMap(Map<String, String> columnMap) {
        int id = Integer.parseInt(columnMap.get("id"));
        String departmentName = columnMap.get("department_name");
        return new Department(id, departmentName);
    }
}
