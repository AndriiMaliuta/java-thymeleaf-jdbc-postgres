package com.anma.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class DBConnector {

    private static final String GET_CITIES = "SELECT * FROM public.cities";
//    private static final String CREATE_CITY = "INSERT INTO cities VALUES(" +  + ")";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");                                                             //TODO for working in servlets
        return DriverManager.getConnection(PropertiesConfig.getProperty(PropertiesConfig.DB_URL),
                PropertiesConfig.getProperty(PropertiesConfig.DB_LOGIN),
                PropertiesConfig.getProperty(PropertiesConfig.DB_PASSWORD));
    };

    public boolean createCity(City cIty) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cities VALUES(?,?,?)");
            statement.setString(1, cIty.getId().toString());
            statement.setString(2, cIty.getName().toString());
            statement.setLong(3, cIty.getPopulation());
            return statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }
        return false;
    }

    public List<City> getAllCities() throws SQLException, ClassNotFoundException {

        List<City> cities = new LinkedList<>();

        try(Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement(GET_CITIES);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City(
                        UUID.fromString(resultSet.getString("city_id")),
                        resultSet.getString("name"),
                        resultSet.getLong("population"));
                cities.add(city);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }
        return cities;
    }

    public List<City> getCitiesByName(String name) throws SQLException, ClassNotFoundException {

        List<City> cities = new ArrayList<>();

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cities WHERE name LIKE ?");
            System.out.println(statement);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cities.add(new City(
                        UUID.fromString(resultSet.getString("city_id")),
                        resultSet.getString("name"),
                        resultSet.getLong("population")
                ));
            }

        } finally {
            getConnection().close();
        }

        return cities;
    }

    public City updateCity(City city) {
        return null;
    }
}












