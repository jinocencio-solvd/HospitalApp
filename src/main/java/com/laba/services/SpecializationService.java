package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.ISpecializationDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisdaos.SpecializationDAO;
import com.laba.models.Specialization;
import java.util.List;

public class SpecializationService implements IEntityService<Specialization> {

    private static ISpecializationDAO dao;

    public SpecializationService(DaoType daoType) {
        String model = "specialization";
        switch (daoType) {
            case JDBC:
                dao = (com.laba.dal.jdbcdaos.SpecializationDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (SpecializationDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Specialization> getAll() {
        return dao.getAll();
    }

    @Override
    public Specialization getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Specialization entity) {
        dao.save(entity);
    }

    @Override
    public void update(Specialization entity) {
        dao.update(entity);
    }
}
