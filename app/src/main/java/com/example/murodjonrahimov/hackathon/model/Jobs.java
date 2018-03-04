package com.example.murodjonrahimov.hackathon.model;

public class Jobs {

    private String borough_community;
    private String contact_number;
    private String address;
    private String agency;
    private String program;
    private String location_1_zip;
    private boolean isFavorite;

    public Jobs(String location_1_zip, String borough_community, String contact_number, String address, String agency, String program, boolean isFavorite) {
        this.borough_community = borough_community;
        this.contact_number = contact_number;
        this.address = address;
        this.agency = agency;
        this.program = program;
        this.isFavorite = isFavorite;
        this.location_1_zip = location_1_zip;
    }

    public String getLocation_1_zip() {
        return location_1_zip;
    }

    public void setLocation_1_zip(String location_1_zip) {
        this.location_1_zip = location_1_zip;
    }

    public String getBorough_community() {
        return borough_community;
    }

    public void setBorough_community(String borough_community) {
        this.borough_community = borough_community;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
