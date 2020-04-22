package com.anma.jdbc.repositories;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.jdbc.JdbcDBConnector;

import java.sql.SQLException;
import java.util.List;

public class JdbcCityRepositoryImpl implements CityRepository {

    public List<City> getCities() throws SQLException, ClassNotFoundException {

        return new JdbcDBConnector().getAllCities();
    }

    public City createCity(City city) throws SQLException, ClassNotFoundException {
         new JdbcDBConnector().createCity(city);
         return city;
    }

    @Override
    public City updateCityByID(City city, String id) throws SecurityException, SQLException, ClassNotFoundException {
        return new JdbcDBConnector().updateCity(city, id);
    }

    public List<City> getCitiesByName(String name) throws SQLException, ClassNotFoundException {
        return new JdbcDBConnector().getCitiesByName(name);
    }

    @Override
    public void deleteCityByID(String id) {
        new JdbcDBConnector().deleteCityByID(id);
    }
}
