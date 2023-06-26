package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IStaffDAO;
import com.laba.models.Staff;
import java.util.List;

public class StaffDAO extends EntityDAO<Staff> implements IStaffDAO {

    @Override
    public Staff getStaffByPersonId(int personId) {
        return session.getMapper(IStaffDAO.class).getStaffByPersonId(personId);
    }

    @Override
    public List<Staff> getStaffByDepartmentId(int departmentId) {
        return session.getMapper(IStaffDAO.class).getStaffByDepartmentId(departmentId);
    }

}
