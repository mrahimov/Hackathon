package com.example.murodjonrahimov.hackathon.network;

import com.example.murodjonrahimov.hackathon.model.Jobs;

import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by c4q on 3/3/18.
 */

public interface Service{



//Service call for Jobs JSON
@GET("/resource/6fic-ympf.json")
    Class<Jobs> getJobs();



}
