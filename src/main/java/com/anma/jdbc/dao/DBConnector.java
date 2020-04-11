package com.anma.jdbc.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBConnector {

    private static final String GET_CITIES = "SELECT * FROM public.cities";
//    private static final String CREATE_CITY = "INSERT INTO cities VALUES(" +  + ")";

    public Connection getConnection() throws SQLException {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cities", "java", "porkie-java");
    };

//    static {
//
//        String jdbcUrl = ";
//        String user = "java";
//        String passwod = "porkie-java";
//
//        try {
//            System.out.println("Connecting to DB");
//            connection = DriverManager.getConnection(jdbcUrl, user, passwod);
//            System.out.println("Connection successful");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public boolean createCity(long id, String name, long population) throws SQLException {

        try(Connection connection = getConnection()) {
            PreparedStatement statement =
                   connection.prepareStatement("INSERT INTO cities VALUES(" + id + ",'" + name + "'," + population + ")");
            return statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }
        return false;
    }

    public List<City> getAllCities() throws SQLException {

        List<City> cities = new LinkedList<>();

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_CITIES);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City(resultSet.getString("name"), resultSet.getLong("population"));
                cities.add(city);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }
        return cities;
    }
}
