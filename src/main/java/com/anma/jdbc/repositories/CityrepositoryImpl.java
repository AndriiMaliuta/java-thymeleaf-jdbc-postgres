package com.anma.jdbc.repositories;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.dao.DBConnector;

import java.util.List;

public class CityrepositoryImpl implements Cityrepository {

    public List<City> getCities() {

        return DBConnector.getAllCities();
    }
}
