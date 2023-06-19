package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IPrescriptionDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.jdbc.PrescriptionDAO;
import com.laba.dal.mybatisDAOs.PrescriptionMbDAO;
import com.laba.models.Prescription;
import java.util.List;

public class PrescriptionService implements IEntityService<Prescription> {

    private static IPrescriptionDAO dao;

    public PrescriptionService(DaoType daoType) {
        String model = "prescription";
        switch (daoType) {
            case JDBC:
                dao = (PrescriptionDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (PrescriptionMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Prescription> getAll() {
        return dao.getAll();
    }

    @Override
    public Prescription getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Prescription entity) {
        dao.save(entity);
    }

    @Override
    public void update(Prescription entity) {
        dao.update(entity);
    }
}
