package com.anma.jdbc.servlets;

import com.anma.jdbc.repositories.CityRepository;
import com.anma.jdbc.repositories.JdbcCityRepositoryImpl;
import com.anma.jdbc.thyme.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/cities")
public class CitiesServlet extends HttpServlet {

    private final CityRepository CityRepository = new JdbcCityRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> variables = new HashMap<>();

        try {

            variables.put("cities", CityRepository.getCities());
            variables.put("contextPath", req.getContextPath());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("*********** Inside cities servlet");
        System.out.println(variables.get("cities"));

        Application.process(req.getServletContext(), req, resp,"cities", variables);

    }


}
