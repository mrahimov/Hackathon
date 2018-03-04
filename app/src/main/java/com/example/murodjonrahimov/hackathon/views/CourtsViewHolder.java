package com.example.murodjonrahimov.hackathon.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.TennisCourt;

/**
 * Created by c4q on 3/3/18.
 */

public class CourtsViewHolder extends RecyclerView.ViewHolder {
    TextView agencyView, locationView, courtsView;

    public CourtsViewHolder(View itemView) {
        super(itemView);
        agencyView = itemView.findViewById(R.id.agency_textView);
        locationView = itemView.findViewById(R.id.location_textView);
        courtsView = itemView.findViewById(R.id.courts_textView);
    }

    public void onBind(TennisCourt courts) {
        agencyView.setText(courts.getName());
        locationView.setText(courts.getLocation());
        courtsView.setText(courts.getCourts());

    }

}
