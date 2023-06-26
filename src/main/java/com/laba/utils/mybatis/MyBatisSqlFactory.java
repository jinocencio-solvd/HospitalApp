package com.laba.utils.mybatis;

import com.laba.utils.AppConfig;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlFactory {

    private static SqlSession session;

    static {
        String configFile = "";
        String mysqlConfigFile = "mybatis/mybatis-config.xml";
        String sqliteConfigFile = "mybatis/mybatis-config-sqlite.xml";
        if (AppConfig.ENVIRONMENT.equals("GH_WORKFLOW")) {
            configFile = sqliteConfigFile;
        } else if (AppConfig.ENVIRONMENT.equals("DEVELOPMENT")) {
            configFile = mysqlConfigFile;
        }

        try (InputStream stream = Resources.getResourceAsStream(configFile)) {
            session = new SqlSessionFactoryBuilder().build(stream).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return session;
    }
}

