package com.example.murodjonrahimov.hackathon.views;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Park;

public class ParksViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView location;
    private TextView zipcode;
    private ImageButton imageButton;
    private int imageB;


    public ParksViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.park_name);
        location = itemView.findViewById(R.id.park_location);
        zipcode = itemView.findViewById(R.id.park_zipcode);
        imageButton = itemView.findViewById(R.id.image_button);

    }

    public void onBind(final Park park) {
        name.setText("Name: " + park.getName());
        location.setText("Location: " + park.getLocation());
        zipcode.setText("Zipcode: " + park.getZip());

        setImage(park.isFavorite());

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean newStatus;

                if(park.isFavorite()) {
                    newStatus = false;
                } else{
                    newStatus = true;
                }

                park.setFavorite(newStatus);
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

