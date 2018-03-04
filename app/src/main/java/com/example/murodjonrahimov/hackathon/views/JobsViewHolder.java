package com.example.murodjonrahimov.hackathon.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Jobs;


public class JobsViewHolder extends RecyclerView.ViewHolder {


    private TextView name;
    private TextView location;
    private TextView borough;
    private TextView program;
    private TextView phone;
    private TextView zipcode;
    private ImageButton imageButton;
    private int imageB;

    public JobsViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.agency_textView);
        location = itemView.findViewById(R.id.location_textView);
        borough = itemView.findViewById(R.id.borough_textView);
        program = itemView.findViewById(R.id.name_textView);
        phone = itemView.findViewById(R.id.phone_textView);
        zipcode = itemView.findViewById(R.id.zipcode_textView);
        imageButton = itemView.findViewById(R.id.image_button);

    }

    public void onBind(final Jobs jobs) {

        name.setText("Agency: " + jobs.getAgency());
        location.setText("Location: " + jobs.getAddress());
        program.setText("Program: " + jobs.getProgram());
        phone.setText("Contact Number: " + jobs.getContact_number());
        borough.setText("Borough: " + jobs.getBorough_community());
        zipcode.setText("Zipcode: " + jobs.getLocation_1_zip());

        setImage(jobs.isFavorite());

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean newStatus;

                if (jobs.isFavorite()) {
                    newStatus = false;
                } else {
                    newStatus = true;
                }

                jobs.setFavorite(newStatus);
                setImage(newStatus);
            }
        });
    }

    public void setImage(boolean isFavorite) {

        if (isFavorite) {
            imageB = R.drawable.favourite;
        } else {
            imageB = R.drawable.unfavourite;
        }
        imageButton.setImageResource(imageB);

    }

}

