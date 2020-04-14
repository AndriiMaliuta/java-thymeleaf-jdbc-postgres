package com.anma.jdbc.servlets;

import com.anma.jdbc.repositories.Cityrepository;
import com.anma.jdbc.repositories.CityrepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cities/delete-city")
public class DeleteCityServlet extends HttpServlet {

    private final Cityrepository cityrepository = new CityrepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        cityrepository.deleteCityByID(req.getParameter("id"));

        resp.setStatus(204);
        resp.sendRedirect(req.getContextPath() + "/cities");
    }
}
