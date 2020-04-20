package com.anma.jdbc.dao;

import com.anma.jdbc.repositories.Cityrepository;
import com.anma.jdbc.repositories.CityrepositoryImpl;
import com.anma.jdbc.rest.CityResource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectorTest {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Cityrepository cityrepository = new CityrepositoryImpl();

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(PropertiesConfig.getProperty(PropertiesConfig.DB_URL),
                PropertiesConfig.getProperty(PropertiesConfig.DB_LOGIN),
                PropertiesConfig.getProperty(PropertiesConfig.DB_PASSWORD));
        preparedStatement = connection.prepareStatement("SELECT * FROM public.cities");
        resultSet = preparedStatement.executeQuery();

    }

    @Test
    void getConnection() throws SQLException {
        assertFalse(connection.isClosed());
    }

    @Test
    void createCity() throws SQLException, ClassNotFoundException {
        City city = new City("Test", 1234);
        assertEquals(city, cityrepository.createCity(city));
    }

    @Test
    void getAllCities() throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = connection.prepareStatement("SELECT * FROM public.cities").executeQuery();
//        assertTrue(resultSet.next());
        assertFalse(cityrepository.getCities().isEmpty());
    }

    @Test
    void getCitiesByName() throws SQLException, ClassNotFoundException {
        assertEquals(cityrepository.getCitiesByName("Sumy").get(0).getName(), "Sumy");
    }

    @Test
    void updateCity() {
    }

    @Test
    void deleteCityByID() {
    }
}