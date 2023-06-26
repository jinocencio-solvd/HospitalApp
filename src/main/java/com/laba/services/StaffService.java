package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IStaffDAO;
import com.laba.models.Staff;
import java.util.List;

public class StaffService extends EntityService<Staff, IStaffDAO> implements IStaffDAO {

    public StaffService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "staff";
    }

    @Override
    public Staff getStaffByPersonId(int personId) {
        return dao.getStaffByPersonId(personId);
    }

    @Override
    public List<Staff> getStaffByDepartmentId(int departmentId) {
        return dao.getStaffByDepartmentId(departmentId);
    }

}
