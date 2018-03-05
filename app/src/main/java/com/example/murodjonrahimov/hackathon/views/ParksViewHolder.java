package com.example.murodjonrahimov.hackathon.views;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.backend.MyIntentService;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;
import com.example.murodjonrahimov.hackathon.model.Park;

public class ParksViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView location;
    private TextView zipcode;
    private ImageButton imageButton;
    private ImageView imageView;
    private int imageB;
    public static final String SAVED_MY_FAVOURITE = "myFavourite";


    public ParksViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.park_name);
        location = itemView.findViewById(R.id.park_location);
        zipcode = itemView.findViewById(R.id.park_zipcode);
        imageButton = itemView.findViewById(R.id.image_button);
        imageView = itemView.findViewById(R.id.imageview_park);

    }

    public void onBind(final Park park) {
        name.setText("Name: " + park.getName());
        location.setText("Location: " + park.getLocation());
        zipcode.setText("Zipcode: " + park.getZip());
        imageView.setImageResource(R.drawable.park);

        setImage(park.isFavorite());

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean newStatus;

                String parkName = park.getName().toString();
                String parkLocation = park.getLocation().toString();
                boolean isFavourite = park.isFavorite();

                if(park.isFavorite()) {
                    newStatus = false;
                } else{
                    newStatus = true;
                }

                park.setFavorite(newStatus);
                setImage(newStatus);

                MyFavourite myFavourite = new MyFavourite(parkName, parkLocation, isFavourite);

                Intent intent = new Intent(name.getContext(), MyIntentService.class);
                intent.putExtra(SAVED_MY_FAVOURITE, myFavourite);
                name.getContext().startService(intent);
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

