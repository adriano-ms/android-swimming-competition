package com.edu.fateczl.swimmingcompetition.model;

import java.time.Instant;

/**
 * @author Adriano M Sanchez
 */
public abstract class Athlete {

    private String name;
    private Instant birthdate;
    private String neighborhood;

    public Athlete(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
