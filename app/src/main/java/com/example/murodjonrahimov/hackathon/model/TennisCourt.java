package com.example.murodjonrahimov.hackathon.model;

/**
 * Created by c4q on 3/3/18.
 */

public class TennisCourt {
    private String Name;
    private String Location;
    private String Phone;
    private String Courts;
    private String Indoor_Outdoor;
    private String Tennis_Type;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCourts() {
        return Courts;
    }

    public void setCourts(String courts) {
        Courts = courts;
    }

    public String getIndoor_Outdoor() {
        return Indoor_Outdoor;
    }

    public void setIndoor_Outdoor(String indoor_Outdoor) {
        Indoor_Outdoor = indoor_Outdoor;
    }

    public String getTennis_Type() {
        return Tennis_Type;
    }

    public void setTennis_Type(String tennis_Type) {
        Tennis_Type = tennis_Type;
    }
}
