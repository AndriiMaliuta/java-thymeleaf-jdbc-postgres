package com.anma.jdbc.hibernate;

import com.anma.jdbc.dao.HiberCity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDBConnector {

    Metadata metadata;

    public SessionFactory getSessionFactory() {

        try {

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            metadata = new MetadataSources(registry).getMetadataBuilder().build();

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return metadata.getSessionFactoryBuilder().build();
    }

    public HiberCity getCityById(Long id) {

        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        HiberCity foundCity = session.get(HiberCity.class, id);

        session.close();

        return foundCity;
    }

    public List<HiberCity> getAllCities() {

        Session session = getSessionFactory().openSession();

        List<HiberCity> cities = session.createQuery("FROM HiberCity", HiberCity.class).list();

        session.close();

        return cities;
    }

//    public HiberCity getCityByName(String name) {
//
//        Session session = getSessionFactory().openSession();
//
//        session.getTransaction().begin();
//
//        Query query = session.createQuery("FROM hiber_cities WHERE name", HiberCity.class).uniqueResult();
//
//        HiberCity foundCity = session.(HiberCity.class, name);
//
//        session.close();
//
//        return foundCity;
//    }

    public boolean createCity(HiberCity hiberCity) {

        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        session.save(hiberCity);

        session.getTransaction().commit();

        session.close();

        return true;
    }

//    public HiberCity updateCity(HiberCity hiberCity) {
//
//
//    }
}
