package com.laba.interfaces.daos;

import com.laba.models.Clinician;
import java.util.List;

public interface IClinicianDAO extends IEntityDAO<Clinician> {

    List<Clinician> getCliniciansByDepartmentId(int departmentId);

}
