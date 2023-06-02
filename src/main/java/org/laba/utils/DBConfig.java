package org.laba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = DBConfig.class.getResourceAsStream(
            "/DBConfig.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String URL = properties.getProperty("URL");
    public static final String USER = properties.getProperty("USER");
    public static final String PASSWORD = properties.getProperty("PASSWORD");
}
