package com.example.murodjonrahimov.hackathon.controller;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;
import com.example.murodjonrahimov.hackathon.views.FavouritesViewHolder;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouritesViewHolder> {

    private List<MyFavourite> myFavourites;

    public FavouriteAdapter(List<MyFavourite> myFavourites) {
        this.myFavourites = myFavourites;
    }

    @Override
    public FavouritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_itemview, parent, false);
        return new FavouritesViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(FavouritesViewHolder holder, int position) {
        MyFavourite myFavourite = myFavourites.get(position);
        holder.onBind(myFavourite);
    }

    @Override
    public int getItemCount() {
        return myFavourites.size();
    }
}
