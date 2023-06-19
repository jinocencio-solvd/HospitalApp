package com.laba.utils.mybatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlFactory {

    private static SqlSession session;

    static {
        String configFile = "mybatis/mybatis-config.xml";
        String sqliteConfigFile = "mybatis/mybatis-config-sqlite.xml";
        try (InputStream stream = Resources.getResourceAsStream(sqliteConfigFile)) {
            session = new SqlSessionFactoryBuilder().build(stream).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return session;
    }
}

