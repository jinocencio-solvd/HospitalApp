package com.laba.interfaces.daos;

import com.laba.models.Patient;
import com.laba.models.Staff;
import java.util.List;

public interface IStaffDAO extends IEntityDAO<Staff> {

    Staff getStaffByPersonId(int personId);

    List<Staff> getStaffByDepartmentId(int departmentId);

}
