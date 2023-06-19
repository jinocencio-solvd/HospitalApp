package com.laba.dal.jdbc;

import com.laba.interfaces.daos.IStaffDAO;
import com.laba.models.Staff;

public class StaffDAO extends EntityDAO<Staff> implements IStaffDAO {

    @Override
    protected String getTableName() {
        return "staff";
    }
}
