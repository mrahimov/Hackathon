package com.example.murodjonrahimov.hackathon.views;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.murodjonrahimov.hackathon.R;


import com.example.murodjonrahimov.hackathon.backend.MyIntentService;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;
import com.example.murodjonrahimov.hackathon.model.TennisCourt;


public class CourtsViewHolder extends RecyclerView.ViewHolder {

    private TextView agencyView, locationView, courtsView;
    private ImageButton imageButton;
    private int imageB;
    public static final String SAVED_MY_FAVOURITE = "myFavourite";
    private ImageView imageViewtennis;

    public CourtsViewHolder(View itemView) {
        super(itemView);
        agencyView = itemView.findViewById(R.id.agency_textView);
        locationView = itemView.findViewById(R.id.location_textView);
        courtsView = itemView.findViewById(R.id.courts_textView);
        imageButton = itemView.findViewById(R.id.image_button);
        imageViewtennis = itemView.findViewById(R.id.imageview_tennis);


    }

    public void onBind(final TennisCourt courts) {
        agencyView.setText("Name: " + courts.getName());
        locationView.setText("Location: " + courts.getLocation());
        courtsView.setText(courts.getCourts());
        imageViewtennis.setImageResource(courts.getImage());

        setImage(courts.isFavorite());

        imageButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                boolean newStatus;
                String courtName = courts.getName().toString();
                String courtLocation = courts.getLocation().toString();
                boolean isFavourite = courts.isFavorite();
                String zipcode = "10019";

                if(courts.isFavorite()) {
                    newStatus = false;
                } else{
                    newStatus = true;
                }
                courts.setFavorite(newStatus);
                setImage(newStatus);

                MyFavourite myFavourite = new MyFavourite(courtName, courtLocation, isFavourite, zipcode);

                Intent intent = new Intent(agencyView.getContext(), MyIntentService.class);
                intent.putExtra(SAVED_MY_FAVOURITE, myFavourite);
                agencyView.getContext().startService(intent);
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
