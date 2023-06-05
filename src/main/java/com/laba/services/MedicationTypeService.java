package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.MedicationTypeDAO;
import com.laba.models.MedicationType;
import java.util.List;

public class MedicationTypeService implements IEntityService<MedicationType> {
    private final MedicationTypeDAO medicationTypeDAO = DAOFactory.getJDBCDAO("medication type");

    @Override
    public List<MedicationType> getAll() {
        return medicationTypeDAO.getAll();
    }

    @Override
    public MedicationType getById(int id) {
        return medicationTypeDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        medicationTypeDAO.deleteById(id);
    }

    @Override
    public void save(MedicationType entity) {
        medicationTypeDAO.save(entity);
    }

    @Override
    public void update(MedicationType entity) {
        medicationTypeDAO.update(entity);
    }
}
