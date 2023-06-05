package com.laba.services;

import com.laba.interfaces.IEntityService;
import java.util.List;

public class EntityService<T> implements IEntityService<T> {

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }
}
