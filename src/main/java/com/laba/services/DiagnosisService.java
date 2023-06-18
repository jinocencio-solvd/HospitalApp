package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IDiagnosisDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.DiagnosisDAO;
import com.laba.jdbc.mybatisDAOs.DiagnosisMbDAO;
import com.laba.models.Diagnosis;
import java.util.List;

public class DiagnosisService implements IEntityService<Diagnosis> {

    private static IDiagnosisDAO dao;

    public DiagnosisService(DaoType daoType) {
        String model = "diagnosis";
        switch (daoType) {
            case JDBC:
                dao = (DiagnosisDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (DiagnosisMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Diagnosis> getAll() {
        return dao.getAll();
    }

    @Override
    public Diagnosis getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Diagnosis entity) {
        dao.save(entity);
    }

    @Override
    public void update(Diagnosis entity) {
        dao.update(entity);
    }
}
