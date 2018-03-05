package com.example.murodjonrahimov.hackathon.model;

public class BasketBallCourt {
    private String Prop_ID;
    private String Name;
    private String Location;
    private String Num_of_Courts;
    private String Accessible;
    private String lat;
    private String lon;
    private boolean isFavorite;

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getProp_ID() {
        return Prop_ID;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getNum_of_Courts() {
        return Num_of_Courts;
    }

    public String getAccessible() {
        return Accessible;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public void setProp_ID(String prop_ID) {
        Prop_ID = prop_ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setNum_of_Courts(String num_of_Courts) {
        Num_of_Courts = num_of_Courts;
    }

    public void setAccessible(String accessible) {
        Accessible = accessible;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
