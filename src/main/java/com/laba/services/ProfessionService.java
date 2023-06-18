package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IProfessionDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.ProfessionDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.mybatisDAOs.ProfessionMbDAO;
import com.laba.models.Profession;
import java.util.List;

public class ProfessionService implements IEntityService<Profession> {

    private static IProfessionDAO dao;

    public ProfessionService(DaoType daoType) {
        String model = "profession";
        switch (daoType) {
            case JDBC:
                dao = (ProfessionDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (ProfessionMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Profession> getAll() {
        return dao.getAll();
    }

    @Override
    public Profession getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Profession entity) {
        dao.save(entity);
    }

    @Override
    public void update(Profession entity) {
        dao.update(entity);
    }
}
