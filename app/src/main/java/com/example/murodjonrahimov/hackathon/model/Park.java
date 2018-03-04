package com.example.murodjonrahimov.hackathon.model;

import com.google.gson.annotations.SerializedName;

public class Park {

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Zip")
    private String zip;

    private boolean isFavorite;

    public Park(String name, String location, String zip, boolean isFavorite) {
        this.name = name;
        this.location = location;
        this.zip = zip;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
