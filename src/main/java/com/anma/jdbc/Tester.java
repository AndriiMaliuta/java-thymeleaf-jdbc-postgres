package com.anma.jdbc;

import com.anma.jdbc.dao.DBConnector;
import com.anma.jdbc.repositories.CityrepositoryImpl;

import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try {
            System.out.println("Connecting to DB");
//            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            new DBConnector().getConnection();
            System.out.println("Connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(new DBConnector().createCity(1,"Osaka", 567645645));

        new CityrepositoryImpl().getCities().forEach(c -> System.out.println(c.getName() + " ||" + c.getId()));

    }

}
