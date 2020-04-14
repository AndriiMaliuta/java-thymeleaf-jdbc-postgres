package com.anma.jdbc.repositories;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.dao.DBConnector;

import java.sql.SQLException;
import java.util.List;

public class CityrepositoryImpl implements Cityrepository {

    public List<City> getCities() throws SQLException, ClassNotFoundException {

        return new DBConnector().getAllCities();
    }

    public City createCity(City city) throws SQLException, ClassNotFoundException {
         new DBConnector().createCity(city);
         return city;
    }

    @Override
    public City updateCityByID(City city, String id) throws SecurityException, SQLException, ClassNotFoundException {
        return new DBConnector().updateCity(city, id);
    }

    public List<City> getCitiesByName(String name) throws SQLException, ClassNotFoundException {
        return new DBConnector().getCitiesByName(name);
    }

    @Override
    public void deleteCityByID(String id) {
        new DBConnector().deleteCityByID(id);
    }
}
