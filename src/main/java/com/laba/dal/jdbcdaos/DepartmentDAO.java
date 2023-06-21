package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IDepartmentDAO;
import com.laba.models.Department;

public class DepartmentDAO extends EntityDAO<Department> implements IDepartmentDAO {

    @Override
    protected String getTableName() {
        return "departments";
    }

}
