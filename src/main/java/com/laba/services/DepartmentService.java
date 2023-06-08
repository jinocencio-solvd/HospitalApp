package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.DepartmentDAO;
import com.laba.models.Department;
import java.util.List;

public class DepartmentService implements IEntityService<Department> {

    private final DepartmentDAO departmentDAO = DAOFactory.getJDBCDAO("department");

    @Override
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }

    @Override
    public Department getById(int id) {
        return departmentDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        departmentDAO.deleteById(id);
    }

    @Override
    public void save(Department entity) {
        departmentDAO.save(entity);
    }

    @Override
    public void update(Department entity) {
        departmentDAO.update(entity);
    }
}
