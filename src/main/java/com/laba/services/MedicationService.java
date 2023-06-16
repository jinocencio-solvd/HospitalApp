package com.laba.services;

import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.MedicationDAO;
import com.laba.models.Medication;
import java.util.List;

public class MedicationService implements IEntityService<Medication> {

    private final MedicationDAO medicationDAO = DAOFactory.getJDBCDAO("medication");

    @Override
    public List<Medication> getAll() {
        return medicationDAO.getAll();
    }

    @Override
    public Medication getById(int id) {
        return medicationDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        medicationDAO.deleteById(id);
    }

    @Override
    public void save(Medication entity) {
        medicationDAO.save(entity);
    }

    @Override
    public void update(Medication entity) {
        medicationDAO.update(entity);
    }
}
