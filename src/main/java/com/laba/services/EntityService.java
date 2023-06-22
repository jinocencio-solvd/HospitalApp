package com.laba.services;

import static com.laba.enums.DaoType.JDBC;
import static com.laba.enums.DaoType.MYBATIS;

import com.laba.dal.daofactories.DAOFactoryGenerator;
import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IEntityDAO;
import com.laba.interfaces.services.IEntityService;
import java.util.List;

public abstract class EntityService<T, D extends IEntityDAO<T>> implements IEntityService<T> {

    protected abstract String getModelName();

    protected D dao;

    public EntityService(DaoType daoType) {
        String model = getModelName();
        switch (daoType) {
            case JDBC:
                dao = (D) DAOFactoryGenerator.getFactory(JDBC).getDAO(model);
                break;
            case MYBATIS:
                dao = (D) DAOFactoryGenerator.getFactory(MYBATIS).getDAO(model);
                break;
        }
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

}
