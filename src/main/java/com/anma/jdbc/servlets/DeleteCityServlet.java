package com.anma.jdbc.servlets;

import com.anma.jdbc.repositories.CityRepository;
import com.anma.jdbc.repositories.JdbcCityRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cities/delete-city")
public class DeleteCityServlet extends HttpServlet {

    private final CityRepository CityRepository = new JdbcCityRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CityRepository.deleteCityByID(req.getParameter("id"));

        resp.setStatus(204);
        resp.sendRedirect(req.getContextPath() + "/cities");
    }
}
