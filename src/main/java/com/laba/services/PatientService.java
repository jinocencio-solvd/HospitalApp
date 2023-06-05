package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.PatientDAO;
import com.laba.models.Patient;
import java.util.List;

public class PatientService implements IEntityService<Patient> {
    private final PatientDAO patientDAO = new PatientDAO();

    @Override
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    @Override
    public Patient getById(int id) {
        return patientDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        patientDAO.deleteById(id);
    }

    @Override
    public void save(Patient entity) {
        patientDAO.save(entity);
    }

    @Override
    public void update(Patient entity) {
        patientDAO.update(entity);
    }
}
