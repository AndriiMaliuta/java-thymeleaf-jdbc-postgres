package com.anma.jdbc.servlets;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.repositories.Cityrepository;
import com.anma.jdbc.repositories.CityrepositoryImpl;
import com.anma.jdbc.rest.CityResource;
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
import java.util.UUID;

@WebServlet(urlPatterns = "/create-city")
public class CreateCityServlet extends HttpServlet {

    private final Cityrepository cityrepository = new CityrepositoryImpl();

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
            cityrepository.createCity(
                    new City(
                            req.getParameter("name"),
                            Long.parseLong(req.getParameter("population"))));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Application.process(req.getServletContext(), req, resp,"cities", variables);
        resp.sendRedirect(req.getContextPath() + "/cities");
    }
}
