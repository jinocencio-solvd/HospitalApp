package com.laba.services;

import com.laba.interfaces.IEntityService;
import com.laba.jdbc.PersonDAO;
import com.laba.models.Person;
import java.util.List;

public class PersonService implements IEntityService<Person> {
    private final PersonDAO personDAO = new PersonDAO();

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @Override
    public Person getById(int id) {
        return personDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        personDAO.deleteById(id);
    }

    @Override
    public void save(Person entity) {
        personDAO.save(entity);
    }

    @Override
    public void update(Person entity) {
        personDAO.update(entity);
    }
}
