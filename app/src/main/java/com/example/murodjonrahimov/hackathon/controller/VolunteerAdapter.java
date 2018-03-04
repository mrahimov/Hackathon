package com.example.murodjonrahimov.hackathon.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Volunteer;
import com.example.murodjonrahimov.hackathon.views.VolunteerViewHolder;

import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerViewHolder>{


    List<Volunteer> volunteerList;


    public VolunteerAdapter(List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }

    @Override
    public VolunteerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.volunteer_item_view, parent, false);

        return new VolunteerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VolunteerViewHolder holder, int position) {

        Volunteer volunteer = volunteerList.get(position);
        holder.onBind(volunteer);

    }

    @Override
    public int getItemCount() {
        return volunteerList.size();
    }
}
