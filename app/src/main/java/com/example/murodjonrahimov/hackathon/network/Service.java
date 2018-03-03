package com.example.murodjonrahimov.hackathon.network;

import com.example.murodjonrahimov.hackathon.model.Job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 3/3/18.
 */

public interface Service{



//Service call for Job JSON
@GET("/resource/6fic-ympf.json")

Call<List<Job>> getJobs();


}
