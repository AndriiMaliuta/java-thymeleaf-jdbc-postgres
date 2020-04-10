package com.anma.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Tester {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/cities";
        String user = "java";
        String passwod = "porkie-java";

        try {
            System.out.println("Connecting to DB");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, passwod);
            System.out.println("Connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
