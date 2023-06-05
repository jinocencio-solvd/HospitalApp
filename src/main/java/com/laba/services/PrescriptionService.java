package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.PrescriptionDAO;
import com.laba.models.Prescription;
import java.util.List;

public class PrescriptionService implements IEntityService<Prescription> {
    private final PrescriptionDAO prescriptionDAO = DAOFactory.getJDBCDAO("prescription");

    @Override
    public List<Prescription> getAll() {
        return prescriptionDAO.getAll();
    }

    @Override
    public Prescription getById(int id) {
        return prescriptionDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        prescriptionDAO.deleteById(id);
    }

    @Override
    public void save(Prescription entity) {
        prescriptionDAO.save(entity);
    }

    @Override
    public void update(Prescription entity) {
        prescriptionDAO.update(entity);
    }
}
