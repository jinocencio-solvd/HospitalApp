package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IPersonDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.jdbc.PersonDAO;
import com.laba.dal.mybatisDAOs.PersonMbDAO;
import com.laba.models.Person;
import java.sql.Date;
import java.util.List;

public class PersonService implements IEntityService<Person> {

    private static IPersonDAO dao;

    public PersonService(DaoType daoType) {
        String model = "person";
        switch (daoType) {
            case JDBC:
                dao = (PersonDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (PersonMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    public Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob) {
        return dao.getByFirstLastNameAndDob(firstName, lastName, dob);
    }

    @Override
    public List<Person> getAll() {
        return dao.getAll();
    }

    @Override
    public Person getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Person entity) {
        dao.save(entity);
    }

    @Override
    public void update(Person entity) {
        dao.update(entity);
    }

}
