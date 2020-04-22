package com.anma.jdbc.servlets;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.repositories.CityRepository;
import com.anma.jdbc.repositories.JdbcCityRepositoryImpl;
import com.anma.jdbc.thyme.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/cities/create-city")
public class CreateCityServlet extends HttpServlet {

    private final CityRepository CityRepository = new JdbcCityRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> variables = new HashMap<>();

        variables.put("contextPath", req.getContextPath());

        Application.process(req.getServletContext(), req, resp,"create-city", variables);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> variables = new HashMap<>();

        try {
            CityRepository.createCity(
                    new City(
                            req.getParameter("name"),
                            Long.parseLong(req.getParameter("population"))));

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
//        Application.process(req.getServletContext(), req, resp,"cities", variables);
        resp.sendRedirect(req.getContextPath() + "/cities");
    }
}
