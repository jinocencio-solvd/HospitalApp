package com.laba.interfaces.daos;

import com.laba.models.Staff;
import java.util.List;

public interface IStaffDAO extends IEntityDAO<Staff> {

    List<Staff> getStaffByDepartmentId(int departmentId);

}
