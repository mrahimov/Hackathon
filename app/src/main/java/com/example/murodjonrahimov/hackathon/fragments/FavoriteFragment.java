package com.example.murodjonrahimov.hackathon.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.backend.AppDatabase;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;

import java.util.List;

public class FavoriteFragment extends Fragment {

    public FavoriteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getFavorite();
    }

    public void getFavorite() {
        new AsyncTask<Void, Void, List<MyFavourite>>() {

            @Override
            protected List<MyFavourite> doInBackground(Void... voids) {
                AppDatabase db = AppDatabase.getAppDatabase(getActivity());
                List<MyFavourite> favoriteFellows = db.myFavDao().getFavorite();
                return favoriteFellows;
            }

            @Override
            protected void onPostExecute(List<MyFavourite> favoriteFellows) {
                super.onPostExecute(favoriteFellows);

//                FellowsAdapter fa = new FellowsAdapter(favoriteFellows);
//
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                rv.setAdapter(fa);
//                rv.setLayoutManager(linearLayoutManager);


            }
        }.execute();
    }
}
