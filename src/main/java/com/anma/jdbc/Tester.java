package com.anma.jdbc;

import com.anma.jdbc.dao.DBConnector;
import com.anma.jdbc.repositories.CityrepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/cities";
        String user = "java";
        String password = "porkie-java";

        try {
            System.out.println("Connecting to DB");
            new DBConnector().getConnection();
            System.out.println("Connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(DBConnector.createCity(5,"Osaka", 567645645));
        try {
            new CityrepositoryImpl().getCities().forEach(c -> System.out.println(c.getName() + " ||" + c.getId()));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
