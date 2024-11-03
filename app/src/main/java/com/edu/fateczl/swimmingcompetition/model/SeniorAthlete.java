package com.edu.fateczl.swimmingcompetition.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Adriano M Sanchez
 */
public class SeniorAthlete extends Athlete {

    private Boolean heartDisease;

    public SeniorAthlete(){
        super();
    }

    public Boolean getHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(Boolean heartDisease) {
        this.heartDisease = heartDisease;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Junior Athlete").append(" | ");
        sb.append("Name: ").append(getName()).append(" | ");
        sb.append("Birthdate: ").append(new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br")).format(Date.from(getBirthdate()))).append(" | ");
        sb.append("Neighborhood: ").append(getNeighborhood()).append(" | ");
        sb.append("Hear Diseases: ").append(heartDisease ? "Yes" : "No");
        return sb.toString();
    }
}
