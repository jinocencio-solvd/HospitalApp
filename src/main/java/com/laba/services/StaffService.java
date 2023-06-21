package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IStaffDAO;
import com.laba.models.Staff;

public class StaffService extends EntityService<Staff, IStaffDAO> implements
    IStaffDAO {

    public StaffService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "staff";
    }

}
