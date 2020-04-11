package com.anma.jdbc.repositories;

import com.anma.jdbc.dao.City;

import java.sql.SQLException;
import java.util.List;

public interface Cityrepository {

    public List<City> getCities() throws SQLException;
}
