package com.anma.jdbc.jpa;

import com.anma.jdbc.dao.HiberCity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaDBConnector {

    public EntityManager getEntityManager() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("persistence-unit");

        return managerFactory.createEntityManager();
    }

    public boolean createHiberCity(HiberCity city) {

        getEntityManager().getTransaction().begin();

        getEntityManager().persist(city);

        getEntityManager().getTransaction().commit();

        getEntityManager().close();

        return true;

    }

    public List<HiberCity> getAllCities() {

        getEntityManager().getTransaction().begin();

        List cities = getEntityManager().createQuery("FROM HiberCity").getResultList();

        getEntityManager().close();

        return cities;

    }
}
