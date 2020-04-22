package com.anma.jdbc.jdbc;

import java.io.InputStream;
import java.util.Properties;

public class JdbcPropertiesConfig {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties = new Properties();

    public static String getProperty(String name) {
        if (properties.isEmpty()) {
            try (InputStream inputStream = JdbcPropertiesConfig.class.getClassLoader().getResourceAsStream("eleph-database.properties")) {
                properties.load(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(name);
    }

}
