package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.ClinicianDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.models.Clinician;
import java.util.List;

public class ClinicianService implements IEntityService<Clinician> {
    private final ClinicianDAO clinicianDAO = DAOFactory.getJDBCDAO("clinician");

    @Override
    public List<Clinician> getAll() {
        return clinicianDAO.getAll();
    }

    @Override
    public Clinician getById(int id) {
        return clinicianDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        clinicianDAO.deleteById(id);
    }

    @Override
    public void save(Clinician entity) {
        clinicianDAO.save(entity);
    }

    @Override
    public void update(Clinician entity) {
        clinicianDAO.update(entity);
    }
}
