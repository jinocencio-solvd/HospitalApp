package com.laba.interfaces.daos;

import com.laba.models.Department;
import java.util.List;

public interface IDepartmentDAO extends IEntityDAO<Department> {

    List<Department> getDepartmentsByClinicianId(int clinicianId);

}
