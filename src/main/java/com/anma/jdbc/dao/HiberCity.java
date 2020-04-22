package com.anma.jdbc.dao;

import javax.persistence.*;

@Entity
@Table(name = "hiber_cities")
public class HiberCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long population;

    public HiberCity() {
    }

    public HiberCity(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
