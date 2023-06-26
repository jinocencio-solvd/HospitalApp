package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IDepartmentDAO;
import com.laba.models.Department;
import java.util.List;

public class DepartmentDAO extends EntityDAO<Department> implements IDepartmentDAO {

    @Override
    public List<Department> getDepartmentsByClinicianId(int clinicianId) {
        return session.getMapper(IDepartmentDAO.class).getDepartmentsByClinicianId(clinicianId);
    }

}
