package com.infoshareacademy.model;

public class Location {
    //region Fields
    private double longitude;
    private double latitude;
    private String town;
    //endregion



    //region Constructor
    public Location(double longitude, double latitude, String town) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.town = town;
    }
    //endregion

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
}
