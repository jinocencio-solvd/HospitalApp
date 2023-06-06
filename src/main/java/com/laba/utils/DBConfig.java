package com.laba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = DBConfig.class.getResourceAsStream(
            "/dbconfig.properties")) {
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
