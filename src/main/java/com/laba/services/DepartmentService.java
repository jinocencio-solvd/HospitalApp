package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IDepartmentDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.DepartmentDAO;
import com.laba.jdbc.mybatisDAOs.DepartmentMbDAO;
import com.laba.models.Department;
import java.util.List;

public class DepartmentService implements IEntityService<Department> {

    private static IDepartmentDAO dao;

    public DepartmentService(DaoType daoType) {
        String model = "department";
        switch (daoType) {
            case JDBC:
                dao = (DepartmentDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (DepartmentMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public Department getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Department entity) {
        dao.save(entity);
    }

    @Override
    public void update(Department entity) {
        dao.update(entity);
    }
}
