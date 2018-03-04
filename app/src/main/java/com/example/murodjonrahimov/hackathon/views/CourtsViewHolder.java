package com.example.murodjonrahimov.hackathon.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.TennisCourt;

/**
 * Created by c4q on 3/3/18.
 */

public class CourtsViewHolder extends RecyclerView.ViewHolder {
    private TextView agencyView, locationView, courtsView;
    private ImageButton imageButton;
    private int imageB;

    public CourtsViewHolder(View itemView) {
        super(itemView);
        agencyView = itemView.findViewById(R.id.agency_textView);
        locationView = itemView.findViewById(R.id.location_textView);
        courtsView = itemView.findViewById(R.id.courts_textView);
        imageButton = itemView.findViewById(R.id.image_button);

    }

    public void onBind(final TennisCourt courts) {
        agencyView.setText(courts.getName());
        locationView.setText(courts.getLocation());
        courtsView.setText(courts.getCourts());

        setImage(courts.isFavorite());

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean newStatus;

                if(courts.isFavorite()) {
                    newStatus = false;
                } else{
                    newStatus = true;
                }

                courts.setFavorite(newStatus);
                setImage(newStatus);
            }
        });
    }

    public void setImage(boolean isFavorite){

        if(isFavorite) {
            imageB = R.drawable.favourite;
        } else{
            imageB = R.drawable.unfavourite;
        }
        imageButton.setImageResource(imageB);

    }

    }
