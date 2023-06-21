package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IDepartmentDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisdaos.DepartmentDAO;
import com.laba.models.Department;
import java.util.List;

public class DepartmentService implements IEntityService<Department> {

    private static IDepartmentDAO dao;

    public DepartmentService(DaoType daoType) {
        String model = "department";
        switch (daoType) {
            case JDBC:
                dao = (com.laba.dal.jdbcdaos.DepartmentDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (DepartmentDAO) DAOFactory.getMyBatisDAO(model);
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
