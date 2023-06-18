package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IPatientDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.PatientDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.mybatisDAOs.PatientMbDAO;
import com.laba.models.Patient;
import java.util.List;

public class PatientService implements IEntityService<Patient> {

    private static IPatientDAO dao;

    public PatientService(DaoType daoType) {
        String model = "patient";
        switch (daoType) {
            case JDBC:
                dao = (PatientDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (PatientMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Patient> getAll() {
        return dao.getAll();
    }

    @Override
    public Patient getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Patient entity) {
        dao.save(entity);
    }

    @Override
    public void update(Patient entity) {
        dao.update(entity);
    }
}
