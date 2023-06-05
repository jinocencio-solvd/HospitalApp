package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.DiagnosisDAO;
import com.laba.models.Diagnosis;
import java.util.List;

public class DiagnosisService implements IEntityService<Diagnosis> {
    private final DiagnosisDAO diagnosisDAO = DAOFactory.getDAO("diagnosis");

    @Override
    public List<Diagnosis> getAll() {
        return diagnosisDAO.getAll();
    }

    @Override
    public Diagnosis getById(int id) {
        return diagnosisDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        diagnosisDAO.deleteById(id);
    }

    @Override
    public void save(Diagnosis entity) {
        diagnosisDAO.save(entity);
    }

    @Override
    public void update(Diagnosis entity) {
        diagnosisDAO.update(entity);
    }
}
