package com.anma.jdbc.servlets;

import com.anma.jdbc.repositories.CityrepositoryImpl;
import com.anma.jdbc.thyme.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/cities")
public class CitiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> variables = new HashMap<>();

        try {

            variables.put("cities", new CityrepositoryImpl().getCities());
            variables.put("contextPath", req.getContextPath());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("*********** Inside cities servlet");
        System.out.println(variables.get("cities"));
        Application.process(req.getServletContext(), req, resp,"cities", variables);

    }


}
