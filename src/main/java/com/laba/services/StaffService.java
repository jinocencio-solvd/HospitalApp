package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IStaffDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisdaos.StaffDAO;
import com.laba.models.Staff;
import java.util.List;

public class StaffService implements IEntityService<Staff> {

    private static IStaffDAO dao;

    public StaffService(DaoType daoType) {
        String model = "staff";
        switch (daoType) {
            case JDBC:
                dao = (com.laba.dal.jdbcdaos.StaffDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (StaffDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Staff> getAll() {
        return dao.getAll();
    }

    @Override
    public Staff getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Staff entity) {
        dao.save(entity);
    }

    @Override
    public void update(Staff entity) {
        dao.update(entity);
    }
}
