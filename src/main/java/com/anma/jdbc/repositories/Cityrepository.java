package com.anma.jdbc.repositories;

import com.anma.jdbc.dao.City;

import java.sql.SQLException;
import java.util.List;

public interface Cityrepository {

    public List<City> getCities() throws SQLException, ClassNotFoundException;

    public List<City> getCitiesByName(String name) throws SQLException, ClassNotFoundException;

    public City createCity(City city) throws SQLException, ClassNotFoundException;

    City updateCity(City city) throws SecurityException;
}
