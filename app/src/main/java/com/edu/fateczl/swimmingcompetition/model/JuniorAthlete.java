package com.edu.fateczl.swimmingcompetition.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Adriano M Sanchez
 */
public class JuniorAthlete extends Athlete {

    private Integer yearsPracticing;

    public JuniorAthlete(){
        super();
    }

    public Integer getYearsPracticing() {
        return yearsPracticing;
    }

    public void setYearsPracticing(Integer yearsPracticing) {
        this.yearsPracticing = yearsPracticing;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Junior Athlete").append(" | ");
        sb.append("Name: ").append(getName()).append(" | ");
        sb.append("Birthdate: ").append(new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br")).format(Date.from(getBirthdate()))).append(" | ");
        sb.append("Neighborhood: ").append(getNeighborhood()).append(" | ");
        sb.append("Years practicing: ").append(yearsPracticing);
        return sb.toString();
    }
}
