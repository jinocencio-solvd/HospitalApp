package com.laba.interfaces;

import java.util.List;

public interface IEntityService<T> {

    List<T> getAll();

    T getById(int id);

    void deleteById(int id);

    void save(T entity);

    void update(T entity);

}
