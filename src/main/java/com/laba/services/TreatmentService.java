package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.ITreatmentDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisdaos.TreatmentDAO;
import com.laba.models.Treatment;
import java.util.List;

public class TreatmentService implements IEntityService<Treatment> {

    private static ITreatmentDAO dao;

    public TreatmentService(DaoType daoType) {
        String model = "treatment";
        switch (daoType) {
            case JDBC:
                dao = (com.laba.dal.jdbcdaos.TreatmentDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (TreatmentDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Treatment> getAll() {
        return dao.getAll();
    }

    @Override
    public Treatment getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Treatment entity) {
        dao.save(entity);
    }

    @Override
    public void update(Treatment entity) {
        dao.update(entity);
    }
}
