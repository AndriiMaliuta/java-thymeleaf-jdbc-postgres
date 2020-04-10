package com.anma.jdbc.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBConnector {

    private static final String GET_CITIES = "SELECT * FROM cities";

    private static Connection connection;

    static {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/cities";
        String user = "java";
        String passwod = "porkie-java";

        try {
            System.out.println("Connecting to DB");
            connection = DriverManager.getConnection(jdbcUrl, user, passwod);
            System.out.println("Connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<City> getAllCities() {

        List<City> cities = new LinkedList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(GET_CITIES);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City(resultSet.getString("name"), resultSet.getLong("population"));
                cities.add(city);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cities;
    }
}
