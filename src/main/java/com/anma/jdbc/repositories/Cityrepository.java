package com.anma.jdbc.repositories;

import com.anma.jdbc.dao.City;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface Cityrepository {

    public List<City> getCities() throws SQLException, ClassNotFoundException;

    public List<City> getCitiesByName(String name) throws SQLException, ClassNotFoundException;

    public City createCity(City city) throws SQLException, ClassNotFoundException;

    City updateCityByID(City city, String name) throws SecurityException, SQLException, ClassNotFoundException;

    public void deleteCityByID(String id);
}
