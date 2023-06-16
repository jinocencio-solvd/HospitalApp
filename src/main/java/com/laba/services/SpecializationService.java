package com.laba.services;

import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.SpecializationDAO;
import com.laba.models.Specialization;
import java.util.List;

public class SpecializationService implements IEntityService<Specialization> {

    private final SpecializationDAO specializationDAO = DAOFactory.getJDBCDAO("specialization");

    @Override
    public List<Specialization> getAll() {
        return specializationDAO.getAll();
    }

    @Override
    public Specialization getById(int id) {
        return specializationDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        specializationDAO.deleteById(id);
    }

    @Override
    public void save(Specialization entity) {
        specializationDAO.save(entity);
    }

    @Override
    public void update(Specialization entity) {
        specializationDAO.update(entity);
    }
}
