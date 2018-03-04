package com.example.murodjonrahimov.hackathon.model;

import com.google.gson.annotations.SerializedName;

public class Parks {

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Zip")
    private String zip;

    public Parks(String name, String location, String zip) {
        this.name = name;
        this.location = location;
        this.zip = zip;
    }

    public String getName() {
        return name;
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
