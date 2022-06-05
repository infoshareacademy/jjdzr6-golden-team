package com.infoshareacademy.model;

import com.google.gson.GsonBuilder;

public class Location {
    // Fields
    private double longitude;
    private double latitude;
    private String town;


    // Constructor
    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.town = town;
    }

    //region Getters&Setters
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    //endregion

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
