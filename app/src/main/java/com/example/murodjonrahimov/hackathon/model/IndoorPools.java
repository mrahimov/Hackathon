package com.example.murodjonrahimov.hackathon.model;

import com.google.gson.annotations.SerializedName;

public class IndoorPools {

    @SerializedName("Name")
    private String name;

    @SerializedName("Location")
    private String location;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Pools_outdoor_Type")
    private String poolsOutdoorType;

    @SerializedName("Setting")
    private String setting;

    @SerializedName("Size")
    private String size;

    private int imageView;
    private String lat;
    private String lon;

    public IndoorPools() {
    }

    public IndoorPools(String name, String location, String phone, String poolsOutdoorType, String setting, String size, String lat, String lon, int imageView) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.poolsOutdoorType = poolsOutdoorType;
        this.setting = setting;
        this.size = size;
        this.lat = lat;
        this.lon = lon;
        this.imageView = imageView;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPoolsOutdoorType() {
        return poolsOutdoorType;
    }

    public void setPoolsOutdoorType(String poolsOutdoorType) {
        this.poolsOutdoorType = poolsOutdoorType;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
