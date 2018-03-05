package com.example.murodjonrahimov.hackathon.backend;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.murodjonrahimov.hackathon.model.MyFavourite;

import java.util.List;


@Dao
public interface MyFavDao {

    @Query("SELECT * FROM MyFavourite")
    List<MyFavourite> getFavorite();

    @Insert
    void addFavourite(MyFavourite myFavourite);

    @Delete
    int deleteFellow(MyFavourite myFavourite);
}
