package com.example.murodjonrahimov.hackathon.model;

/**
 * Created by murodjon.rahimov on 3/4/18.
 */

public class ModelIndoorPools {
  private String Name;
  private String Location;
  private String Phone;
  private String Pools_outdoor_Type;
  private String Setting;
  private String lat;
  private String lon;
  private int image;

  public ModelIndoorPools() {
  }

  public ModelIndoorPools(String name, String location, String phone, String pools_outdoor_Type, String setting, String lat,
                    String lon, int image) {
    this.Name = name;
    this.Location = location;
    this.Phone = phone;
    this.Pools_outdoor_Type = pools_outdoor_Type;
    this.Setting = setting;
    this.lat = lat;
    this.lon = lon;
    this.image = image;
  }

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

  public String getPools_outdoor_Type() {
    return Pools_outdoor_Type;
  }

  public void setPools_outdoor_Type(String pools_outdoor_Type) {
    Pools_outdoor_Type = pools_outdoor_Type;
  }

  public String getSetting() {
    return Setting;
  }

  public void setSetting(String setting) {
    Setting = setting;
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

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
}
