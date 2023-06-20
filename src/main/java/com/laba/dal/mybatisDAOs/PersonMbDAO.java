package com.laba.dal.mybatisDAOs;

import com.laba.interfaces.daos.IPersonDAO;
import com.laba.models.Person;
import com.laba.utils.mybatis.MyBatisSqlFactory;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

public class PersonMbDAO extends EntityMbDAO<Person> implements IPersonDAO {

    private static final SqlSession session = MyBatisSqlFactory.getSession();

    @Override
    public Person getByFirstLastNameAndDob(String firstName, String lastName, Date dob) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstName", firstName);
        parameters.put("lastName", lastName);
        parameters.put("dob", dob);
        return session.selectOne(getNamespace() + ".getByFirstLastNameAndDob", parameters);
    }
}
