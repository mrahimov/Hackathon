package com.example.murodjonrahimov.hackathon.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.BasketBallCourt;
import com.example.murodjonrahimov.hackathon.model.TennisCourt;
import com.example.murodjonrahimov.hackathon.views.CourtsViewHolder;

import java.util.List;

/**
 * Created by c4q on 3/3/18.
 */

public class CourtsAdapter extends RecyclerView.Adapter<CourtsViewHolder> {

    List<TennisCourt> tennisCourts;

    public CourtsAdapter(List<TennisCourt> tennisCourts) {
        this.tennisCourts = tennisCourts;
    }

    @Override
    public CourtsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv = LayoutInflater.from(parent.getContext()).inflate(R.layout.courts_item_view, parent, false);
        return new CourtsViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CourtsViewHolder holder, int position) {
        TennisCourt courts = tennisCourts.get(position);
        holder.onBind(courts);

    }

    @Override
    public int getItemCount() {
        return tennisCourts.size();
    }
}
