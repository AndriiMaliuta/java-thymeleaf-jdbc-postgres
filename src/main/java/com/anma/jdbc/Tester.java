package com.anma.jdbc;

import com.anma.jdbc.dao.City;
import com.anma.jdbc.dao.HiberCity;
import com.anma.jdbc.hibernate.HibernateDBConnector;
import com.anma.jdbc.jdbc.JdbcDBConnector;
import com.anma.jdbc.jpa.JpaDBConnector;
import com.anma.jdbc.repositories.JdbcCityRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // ============= JPA ============

        System.out.println(new JpaDBConnector().createHiberCity(new HiberCity("Jpa city 1", 234567)));

//        new JpaDBConnector().hetAllCities().forEach(city -> System.out.println(city.getName()));

        // ========== Hibernate =========
// CREATE       System.out.println(new HibernateDBConnector().createCity(new HiberCity("Hiber 2", 456789)));
//  GET
//        System.out.println(new HibernateDBConnector().getCityByName("Hiber 2").getName());;

//        new HibernateDBConnector().getAllCities().forEach(city -> System.out.println(city.getName()));




        // ============= JDBC ============

//        try {
//            System.out.println("Connecting to DB");
////            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
//            new JdbcDBConnector().getConnection();
//            System.out.println("Connection successful");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println(new DBConnector().createCity(1,"Osaka", 567645645));

//        new JdbcCityRepositoryImpl().getCities().forEach(c -> System.out.println(c.getName() + " ||" + c.getId()));

    }

}
