package com.laba.dal.mybatisDAOs;

import com.laba.interfaces.daos.IEntityDAO;
import com.laba.utils.mybatis.MyBatisSqlFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public abstract class EntityMbDAO<T> implements IEntityDAO<T> {

    private static final SqlSession session = MyBatisSqlFactory.getSession();

    public String getNamespace() {
        return this.getClass().getInterfaces()[0].getName();
    }

    @Override
    public List<T> getAll() {
        return session.selectList(getNamespace() + ".getAll");
    }

    @Override
    public T getById(int id) {
        return session.selectOne(getNamespace() + ".getById", id);
    }

    @Override
    public void deleteById(int id) {
        session.delete(getNamespace() + ".deleteById", id);
        session.commit();
    }

    @Override
    public void save(T entity) {
        session.insert(getNamespace() + ".save", entity);
        session.commit();
    }

    @Override
    public void update(T entity) {
        session.update(getNamespace() + ".update", entity);
        session.commit();
    }
}
