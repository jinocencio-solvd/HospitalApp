package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IClinicianDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.jdbc.ClinicianDAO;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisDAOs.ClinicianMbDAO;
import com.laba.models.Clinician;
import java.util.List;

public class ClinicianService implements IEntityService<Clinician> {

    private static IClinicianDAO dao;

    public ClinicianService(DaoType daoType) {
        String model = "clinician";
        switch (daoType) {
            case JDBC:
                dao = (ClinicianDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (ClinicianMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Clinician> getAll() {
        return dao.getAll();
    }

    @Override
    public Clinician getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Clinician entity) {
        dao.save(entity);
    }

    @Override
    public void update(Clinician entity) {
        dao.update(entity);
    }
}
