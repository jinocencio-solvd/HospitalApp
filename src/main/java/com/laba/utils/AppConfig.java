package com.laba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final Properties properties;

    static {
        properties = new Properties();
        String configFileApp = "/appconfig.properties";
        try (InputStream inputStream = DBConfig.class.getResourceAsStream(configFileApp)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String ENVIRONMENT = properties.getProperty("ENVIRONMENT");
    public static final String configFileSqlite = properties.getProperty("CONFIG_FILE_SQLITE");
    public static final String configFileMysql = properties.getProperty("CONFIG_FILE_MYSQL");
    public static final String xmlOutputDir = properties.getProperty("XML_OUTPUT_DIR");

}
