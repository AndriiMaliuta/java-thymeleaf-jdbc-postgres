package com.anma.jdbc.repositories;


import com.anma.jdbc.dao.City;

import java.sql.SQLException;
import java.util.List;

public class HibernateCityRepositoryImpl implements CityRepository {

    @Override
    public List<City> getCities() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<City> getCitiesByName(String name) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public City createCity(City city) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public City updateCityByID(City city, String name) throws SecurityException, SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void deleteCityByID(String id) {

    }
}
