package com.anma.jdbc.rest;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.repositories.CityRepository;
import com.anma.jdbc.repositories.JdbcCityRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/api/cities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    private final CityRepository CityRepository = new JdbcCityRepositoryImpl();

    @GET
    public List<City> getCities() throws ClassNotFoundException {

        try {
            return CityRepository.getCities();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }

    @GET
    @Path("/{cityName}")
    public List<City> getCitiesByName(@PathParam("cityName") String cityName) throws SQLException, ClassNotFoundException {
        return new JdbcCityRepositoryImpl().getCitiesByName(cityName);
    }
}
