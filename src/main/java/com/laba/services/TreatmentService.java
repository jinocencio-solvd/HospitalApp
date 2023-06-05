package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.TreatmentDAO;
import com.laba.models.Treatment;
import java.util.List;

public class TreatmentService implements IEntityService<Treatment> {
    private final TreatmentDAO treatmentDAO = new TreatmentDAO();

    @Override
    public List<Treatment> getAll() {
        return treatmentDAO.getAll();
    }

    @Override
    public Treatment getById(int id) {
        return treatmentDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        treatmentDAO.deleteById(id);
    }

    @Override
    public void save(Treatment entity) {
        treatmentDAO.save(entity);
    }

    @Override
    public void update(Treatment entity) {
        treatmentDAO.update(entity);
    }
}
