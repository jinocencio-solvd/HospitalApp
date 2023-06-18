package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IStaffDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.StaffDAO;
import com.laba.jdbc.mybatisDAOs.StaffMbDAO;
import com.laba.models.Staff;
import java.util.List;

public class StaffService implements IEntityService<Staff> {

    private static IStaffDAO dao;

    public StaffService(DaoType daoType) {
        String model = "staff";
        switch (daoType) {
            case JDBC:
                dao = (StaffDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (StaffMbDAO) DAOFactory.getMyBatisDAO(model);
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
