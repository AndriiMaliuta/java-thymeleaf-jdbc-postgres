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

    public boolean createCity(City city) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cities VALUES(?,?,?)");
            statement.setString(1, city.getId().toString());
            statement.setString(2, city.getName().toString());
            statement.setLong(3, city.getPopulation());
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
                City city = new City(resultSet.getString("name"), resultSet.getLong("population"));
                city.setId(UUID.fromString(resultSet.getString("city_id")));
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
                City city = new City(resultSet.getString("name"), resultSet.getLong("population"));
                city.setId(UUID.fromString(resultSet.getString("city_id")));
                cities.add(city);
            }

        } finally {
            getConnection().close();
        }

        return cities;
    }

    public City updateCity(City city, String id) throws SQLException, ClassNotFoundException {

        try (Connection connection = getConnection()) {

            if (city.getName() != null && city.getPopulation() > 0) {

                PreparedStatement statement1 = connection.prepareStatement("UPDATE cities SET name = ?, population = ? WHERE city_id = ?");
                System.out.println(statement1.toString());
                statement1.setString(1, city.getName());
                statement1.setLong(2, city.getPopulation());
                statement1.setString(3, id);
                ResultSet resultSet = statement1.executeQuery();
                City updatedCity = new City(resultSet.getString("name"), resultSet.getLong("population"));
                System.out.println("********** Updated city is === " + updatedCity.toString());
                return updatedCity;
            }
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cities WHERE city_id = ?");
//            statement.setString(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            City foundCity = new City(resultSet.getString("name"), resultSet.getLong("population"));
//            foundCity.setName(city.getName());
//            foundCity.setPopulation(city.getPopulation());
        }

        return new City("error", 0);
    }
}












