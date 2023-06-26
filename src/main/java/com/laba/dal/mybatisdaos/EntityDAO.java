package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IEntityDAO;
import com.laba.utils.mybatis.MyBatisSqlFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public abstract class EntityDAO<T> implements IEntityDAO<T> {

    protected static final SqlSession session = MyBatisSqlFactory.getSession();

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
    public void save(Object entity) {
        session.insert(getNamespace() + ".save", entity);
        session.commit();
    }

    @Override
    public void update(Object entity) {
        session.update(getNamespace() + ".update", entity);
        session.commit();
    }

}
