package com.anma.jdbc.servlets;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.repositories.Cityrepository;
import com.anma.jdbc.repositories.CityrepositoryImpl;
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

@WebServlet(urlPatterns = "/cities/update-city")
public class UpdateCityServlet extends HttpServlet {

    private final Cityrepository cityrepository = new CityrepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> variables = new HashMap<>();

        variables.put("contextPath", req.getContextPath());
        variables.put("id", req.getParameter("id"));

        System.out.println("******* Getting Update page fir city with id == ");

        Application.process(req.getServletContext(), req, resp,"update-city", variables);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//        Map<String, Object> variables = new HashMap<>();

        try {
            cityrepository.updateCityByID(
                    new City(
                            req.getParameter("name"),
                            Long.parseLong(req.getParameter("population"))),
                    req.getParameter("id"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        //        Application.process(req.getServletContext(), req, resp,"cities", variables);
        resp.sendRedirect(req.getContextPath() + "/cities");
    }
}
