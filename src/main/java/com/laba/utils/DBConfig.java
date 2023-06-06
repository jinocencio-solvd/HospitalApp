package com.laba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConfig {

    private static final Properties properties;
    private static final Logger LOG = LogManager.getLogger(ConnectionPool.class);

    static {
        properties = new Properties();

        String propertiesFile = AppConfig.ENVIRONMENT;
        LOG.info("Environment: " + AppConfig.ENVIRONMENT);
        switch (propertiesFile) {
            case "GH_WORKFLOW":
                propertiesFile = AppConfig.configFileSqlite;
                LOG.info("Database: SQLITE");
                break;
            case "DEVELOPMENT":
                propertiesFile = AppConfig.configFileMysql;
                LOG.info("Database: MYSQL");
                break;
            default:
                propertiesFile = AppConfig.configFileMysql;
                LOG.info("Default Database: MYSQL");
        }

        try (InputStream inputStream = DBConfig.class.getResourceAsStream(propertiesFile)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String protocol = properties.getProperty("PROTOCOL");
    public static String driver = properties.getProperty("DRIVER");
    public static String hostname = properties.getProperty("HOSTNAME");
    public static String port = properties.getProperty("PORT");
    public static String databaseName = properties.getProperty("DBNAME");
    public static final String URL = properties.getProperty("URL").equals("") ?
        protocol + ":" + driver + "://" + hostname + ":" + port + "/" + databaseName :
        properties.getProperty("URL");
    public static final String USER = properties.getProperty("USER");
    public static final String PASSWORD = properties.getProperty("PASSWORD");
}
