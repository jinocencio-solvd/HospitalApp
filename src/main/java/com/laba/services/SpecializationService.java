package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.ISpecializationDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.SpecializationDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.mybatisDAOs.SpecializationMbDAO;
import com.laba.models.Specialization;
import java.util.List;

public class SpecializationService implements IEntityService<Specialization> {

    private static ISpecializationDAO dao;

    public SpecializationService(DaoType daoType) {
        String model = "specialization";
        switch (daoType) {
            case JDBC:
                dao = (SpecializationDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (SpecializationMbDAO) DAOFactory.getMyBatisDAO(model);
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
