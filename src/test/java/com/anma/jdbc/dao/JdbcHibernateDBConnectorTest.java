package com.anma.jdbc.dao;

import com.anma.jdbc.jdbc.JdbcPropertiesConfig;
import com.anma.jdbc.repositories.CityRepository;
import com.anma.jdbc.repositories.JdbcCityRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class JdbcHibernateDBConnectorTest {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    CityRepository CityRepository = new JdbcCityRepositoryImpl();

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(JdbcPropertiesConfig.getProperty(JdbcPropertiesConfig.DB_URL),
                JdbcPropertiesConfig.getProperty(JdbcPropertiesConfig.DB_LOGIN),
                JdbcPropertiesConfig.getProperty(JdbcPropertiesConfig.DB_PASSWORD));
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
        assertEquals(city, CityRepository.createCity(city));
    }

    @Test
    void getAllCities() throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = connection.prepareStatement("SELECT * FROM public.cities").executeQuery();
//        assertTrue(resultSet.next());
        assertFalse(CityRepository.getCities().isEmpty());
    }

    @Test
    void getCitiesByName() throws SQLException, ClassNotFoundException {
        assertEquals(CityRepository.getCitiesByName("Sumy").get(0).getName(), "Sumy");
    }

    @Test
    void updateCity() {
    }

    @Test
    void deleteCityByID() {
    }
}