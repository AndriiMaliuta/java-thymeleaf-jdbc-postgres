package com.anma.jdbc;

import com.anma.jdbc.dao.DBConnector;
import com.anma.jdbc.repositories.CityrepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Tester {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/cities";
        String user = "java";
        String password = "porkie-java";

        try {
            System.out.println("Connecting to DB");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(DBConnector.createCity("Minsk", 245645645));
//        System.out.println(new CityrepositoryImpl().getCities());
    }
}
