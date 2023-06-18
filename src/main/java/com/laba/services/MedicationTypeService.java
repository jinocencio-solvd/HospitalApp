package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IMedicationTypeDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.MedicationTypeDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.mybatisDAOs.MedicationTypeMbDAO;
import com.laba.models.MedicationType;
import java.util.List;

public class MedicationTypeService implements IEntityService<MedicationType> {

    private static IMedicationTypeDAO dao;

    public MedicationTypeService(DaoType daoType) {
        String model = "medication type";
        switch (daoType) {
            case JDBC:
                dao = (MedicationTypeDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (MedicationTypeMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<MedicationType> getAll() {
        return dao.getAll();
    }

    @Override
    public MedicationType getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(MedicationType entity) {
        dao.save(entity);
    }

    @Override
    public void update(MedicationType entity) {
        dao.update(entity);
    }
}
