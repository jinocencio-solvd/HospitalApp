package com.laba.utils.mybatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlFactory {

    private static SqlSession session;

    static {
        try (InputStream stream = Resources.getResourceAsStream("mybatis/mybatis-config.xml")) {
            session = new SqlSessionFactoryBuilder().build(stream).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return session;
    }
}

