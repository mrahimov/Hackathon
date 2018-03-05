package com.example.murodjonrahimov.hackathon.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class MyFavourite implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "isFavorite")
    private boolean isFavorite;

    @ColumnInfo(name = "zipcode")
    private String zipcode;

    public MyFavourite(String name, String location, boolean isFavorite, String zipcode) {
        this.name = name;
        this.location = location;
        this.isFavorite = isFavorite;
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeByte(this.isFavorite ? (byte) 1 : (byte) 0);
    }

    protected MyFavourite(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.location = in.readString();
        this.isFavorite = in.readByte() != 0;
    }

    public static final Creator<MyFavourite> CREATOR = new Creator<MyFavourite>() {
        @Override
        public MyFavourite createFromParcel(Parcel source) {
            return new MyFavourite(source);
        }

        @Override
        public MyFavourite[] newArray(int size) {
            return new MyFavourite[size];
        }
    };
}
