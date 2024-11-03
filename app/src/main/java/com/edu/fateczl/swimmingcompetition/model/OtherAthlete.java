package com.edu.fateczl.swimmingcompetition.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Adriano M Sanchez
 */
public class OtherAthlete extends Athlete {

    private String gym;
    private Integer recordInSeconds;

    public OtherAthlete(){
        super();
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public Integer getRecordInSeconds() {
        return recordInSeconds;
    }

    public void setRecordInSeconds(Integer recordInSeconds) {
        this.recordInSeconds = recordInSeconds;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Junior Athlete").append(" | ");
        sb.append("Name: ").append(getName()).append(" | ");
        sb.append("Birthdate: ").append(new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br")).format(Date.from(getBirthdate()))).append(" | ");
        sb.append("Neighborhood: ").append(getNeighborhood()).append(" | ");
        sb.append("Gym: ").append(gym).append(" | ");
        sb.append("Record in seconds: ").append(recordInSeconds);
        return sb.toString();
    }
}
