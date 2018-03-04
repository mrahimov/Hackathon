package com.example.murodjonrahimov.hackathon.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Parks;

public class ParksViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView location;
    private TextView zipcode;

    public ParksViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.park_name);
        location = itemView.findViewById(R.id.park_location);
        zipcode = itemView.findViewById(R.id.park_zipcode);
    }

    public void onBind(Parks parks) {
        name.setText("Name: " + parks.getName());
        location.setText("Location: " + parks.getLocation());
        zipcode.setText("Zipcode: " + parks.getZip());
    }
}
