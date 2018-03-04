package com.example.murodjonrahimov.hackathon.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Volunteer;


public class VolunteerViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageButton imageButton;
    private int imageB;

    public VolunteerViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.agency_textView);
        imageButton = itemView.findViewById(R.id.image_button);

    }

    public void onBind(final Volunteer volunteer) {

        textView.setText(volunteer.getTitle());

        setImage(volunteer.isFavorite());

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean newStatus;

                if (volunteer.isFavorite()) {
                    newStatus = false;
                } else {
                    newStatus = true;
                }

                volunteer.setFavorite(newStatus);
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

