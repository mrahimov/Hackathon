package com.example.murodjonrahimov.hackathon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.controller.JobsAdapter;
import com.example.murodjonrahimov.hackathon.model.Jobs;
import com.example.murodjonrahimov.hackathon.network.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobsAndInternshipFragment extends Fragment {

    View rootView;
    RecyclerView recyclerView;
    List<Jobs> getJobsList;


    public JobsAndInternshipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_jobs_and_internship, container, false);

        recyclerView = rootView.findViewById(R.id.jobs_rv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Service service = retrofit.create(Service.class);

        Call<List<Jobs>> call = service.getJobs();

        call.enqueue(new Callback<List<Jobs>>() {
            @Override
            public void onResponse(Call<List<Jobs>> call, Response<List<Jobs>> response) {
                Log.d("SUCESSSSSSSSSSS", response.body().get(0).toString());
                getJobsList = response.body();

                JobsAdapter jobsAdapter =  new JobsAdapter(getJobsList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

                recyclerView.setAdapter(jobsAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);


            }

            @Override
            public void onFailure(Call<List<Jobs>> call, Throwable t) {
                t.printStackTrace();

            }
        });


        return rootView;
    }

}
