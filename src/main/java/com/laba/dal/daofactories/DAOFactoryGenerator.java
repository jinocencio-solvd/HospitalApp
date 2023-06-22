package com.laba.dal.daofactories;

import com.laba.enums.DaoType;

public class DAOFactoryGenerator {

    public static AbstractDAOFactory getFactory(DaoType daoType) {
        switch (daoType) {
            case JDBC:
                return new JdbcDAOFactory();
            case MYBATIS:
                return new MyBatisDAOFactory();
            default:
                throw new IllegalArgumentException("Invalid daoType");
        }
    }

}
