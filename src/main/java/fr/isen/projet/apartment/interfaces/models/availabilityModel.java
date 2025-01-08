package fr.isen.projet.apartment.interfaces.models;

import fr.isen.projet.apartment.interfaces.models.enums.availabilities;

//begin of modifiable zone(Javadoc).......C/949f8576-78e9-424d-8254-1a9ec3d660b0

//end of modifiable zone(Javadoc).........E/949f8576-78e9-424d-8254-1a9ec3d660b0
public class availabilityModel {
    //begin of modifiable zone(Javadoc).......C/e07b4698-c0e3-4e5d-9d38-daec972d8c25

    //end of modifiable zone(Javadoc).........E/e07b4698-c0e3-4e5d-9d38-daec972d8c25
    private int id;

    //begin of modifiable zone(Javadoc).......C/1f396be6-b38c-4832-9d1c-1f042b374be5

    //end of modifiable zone(Javadoc).........E/1f396be6-b38c-4832-9d1c-1f042b374be5
    private String availability;

    //begin of modifiable zone(Javadoc).......C/ad85be01-1cfe-475a-8ed1-973015941860

    //end of modifiable zone(Javadoc).........E/ad85be01-1cfe-475a-8ed1-973015941860
    private int year;

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
