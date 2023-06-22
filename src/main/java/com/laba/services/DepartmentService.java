package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IDepartmentDAO;
import com.laba.models.Department;
import java.util.List;

public class DepartmentService extends EntityService<Department, IDepartmentDAO> implements
    IDepartmentDAO {

    public DepartmentService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "department";
    }

    @Override
    public List<Department> getDepartmentsByClinicianId(int clinicianId) {
        return dao.getDepartmentsByClinicianId(clinicianId);
    }

}
