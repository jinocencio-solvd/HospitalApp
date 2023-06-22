package com.laba.interfaces.daos;

import com.laba.models.Diagnosis;
import java.util.List;

public interface IDiagnosisDAO extends IEntityDAO<Diagnosis> {

    List<Diagnosis> getDiagnosisByDepartmentId(int departmentId);

}
