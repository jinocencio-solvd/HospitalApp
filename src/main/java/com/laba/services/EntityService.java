package com.laba.services;

import com.laba.dal.DAOFactory;
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
                dao = (D) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (D) DAOFactory.getMyBatisDAO(model);
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
