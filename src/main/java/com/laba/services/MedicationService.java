package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IMedicationDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.jdbc.MedicationDAO;
import com.laba.dal.mybatisDAOs.MedicationMbDAO;
import com.laba.models.Medication;
import java.util.List;

public class MedicationService implements IEntityService<Medication> {

    private static IMedicationDAO dao;

    public MedicationService(DaoType daoType) {
        String model = "medication";
        switch (daoType) {
            case JDBC:
                dao = (MedicationDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (MedicationMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Medication> getAll() {
        return dao.getAll();
    }

    @Override
    public Medication getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Medication entity) {
        dao.save(entity);
    }

    @Override
    public void update(Medication entity) {
        dao.update(entity);
    }
}
