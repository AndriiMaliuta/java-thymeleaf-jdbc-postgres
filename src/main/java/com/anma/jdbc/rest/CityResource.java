package com.anma.jdbc.rest;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.repositories.Cityrepository;
import com.anma.jdbc.repositories.CityrepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/api/cities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    private final Cityrepository cityrepository = new CityrepositoryImpl();

    @GET
    public List<City> getCities() {

        try {
            return cityrepository.getCities();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }

    @GET
    @Path("/{cityId}")
    public City getCIty(@PathParam("cityId") long cityId) {
        return new City("Zagreb", 1234567);
    }
}
