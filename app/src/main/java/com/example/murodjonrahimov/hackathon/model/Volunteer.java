package com.example.murodjonrahimov.hackathon.model;


public class Volunteer {

    private String org_title;
    private String title;
    private String vol_requests;
    private String postalcode;
    private boolean isFavorite;

    public Volunteer(String org_title, String title, String vol_requests, boolean isFavorite, String postalcode) {
        this.org_title = org_title;
        this.title = title;
        this.vol_requests = vol_requests;
        this.isFavorite = isFavorite;
        this.postalcode = postalcode;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getOrg_title() {
        return org_title;
    }

    public void setOrg_title(String org_title) {
        this.org_title = org_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVol_requests() {
        return vol_requests;
    }

    public void setVol_requests(String vol_requests) {
        this.vol_requests = vol_requests;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }


}
