package com.example.murodjonrahimov.hackathon.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Jobs;
import com.example.murodjonrahimov.hackathon.views.JobsViewHolder;

import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class JobsAdapter extends RecyclerView.Adapter<JobsViewHolder> {

    List<Jobs> jobsList;

    public JobsAdapter(List<Jobs> jobsList) {
        this.jobsList = jobsList;
    }

    @Override
    public JobsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobs_item_view, parent, false);

        return new JobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JobsViewHolder holder, int position) {

        Jobs jobs =jobsList.get(position);
        holder.onBind(jobs);

    }

    @Override
    public int getItemCount() {
        return jobsList.size();
    }
}
