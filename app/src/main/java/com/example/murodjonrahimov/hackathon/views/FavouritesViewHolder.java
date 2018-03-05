package com.example.murodjonrahimov.hackathon.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;


public class FavouritesViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView location;
    private ImageButton favourite;

    public FavouritesViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name_textView);
        location = itemView.findViewById(R.id.location_textView);
        favourite = itemView.findViewById(R.id.image_button);
    }

    public void onBind(MyFavourite myFavourite) {
        name.setText("Name: " + myFavourite.getName());
        location.setText("Location: " + myFavourite.getLocation());
        favourite.setImageResource(R.drawable.favourite);
    }

}
