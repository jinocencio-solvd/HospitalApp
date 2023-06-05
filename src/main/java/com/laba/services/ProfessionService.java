package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.ProfessionDAO;
import com.laba.models.Profession;
import java.util.List;

public class ProfessionService implements IEntityService<Profession> {
    private final ProfessionDAO professionDAO = DAOFactory.getDAO("profession");

    @Override
    public List<Profession> getAll() {
        return professionDAO.getAll();
    }

    @Override
    public Profession getById(int id) {
        return professionDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        professionDAO.deleteById(id);
    }

    @Override
    public void save(Profession entity) {
        professionDAO.save(entity);
    }

    @Override
    public void update(Profession entity) {
        professionDAO.update(entity);
    }
}
