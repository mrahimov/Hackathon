package com.example.murodjonrahimov.hackathon.network;

import com.example.murodjonrahimov.hackathon.model.Jobs;

import com.example.murodjonrahimov.hackathon.model.Volunteer;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 3/3/18.
 */

public interface Service {

    @GET("/resource/6fic-ympf.json")
    Call<List<Jobs>> getJobs();


    @GET("/resource/n4ac-3636.json")
    Call<List<Volunteer>> getVolunteerJobs();

}

