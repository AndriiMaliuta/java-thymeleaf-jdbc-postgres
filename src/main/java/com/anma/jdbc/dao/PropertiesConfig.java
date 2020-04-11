package com.anma.jdbc.dao;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties;

    public static String getProperty(String name) {
        if (properties == null) {

            try (InputStream inputStream = PropertiesConfig.class.getResourceAsStream("database.properties")) {
                properties.load(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(name);
    }

}
