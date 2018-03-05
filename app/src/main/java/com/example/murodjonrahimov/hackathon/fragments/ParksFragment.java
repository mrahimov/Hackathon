package com.example.murodjonrahimov.hackathon.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.backend.AppDatabase;
import com.example.murodjonrahimov.hackathon.controller.ParksAdapter;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;
import com.example.murodjonrahimov.hackathon.model.Park;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParksFragment extends Fragment {

    private RecyclerView recyclerView;

    public ParksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_parks, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner();
        asyncTaskRunner.execute();

        recyclerView = getActivity().findViewById(R.id.parks_recyclerview);
    }

    public String loadJSONFromAsset() {
        String json;

        try {
            InputStream is = getContext().getAssets().open("parks.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, ArrayList<Park>> {

        @Override
        protected ArrayList<Park> doInBackground(String... params) {

            String json = loadJSONFromAsset();
            Gson gson = new Gson();
            ArrayList<Park> listOfParks = gson.fromJson(json, new TypeToken<ArrayList<Park>>() {
            }.getType());

            AppDatabase db = AppDatabase.getAppDatabase(getActivity());
            List<MyFavourite> favoriteFellows = db.myFavDao().getFavorite();

            for(int i = 0; i < favoriteFellows.size();i++) {
                for(int k = 0; k < listOfParks.size(); k++) {

                    String myFavouriteName = favoriteFellows.get(i).getName();
                    String parkName = listOfParks.get(k).getName();
                    if(myFavouriteName.equals(parkName)) {
                        listOfParks.get(k).setFavorite(true);
                    }
                }
            }

            return listOfParks;
        }

        @Override
        protected void onPostExecute(ArrayList<Park> listOfParks) {

            ParksAdapter parksAdapter = new ParksAdapter(listOfParks);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setAdapter(parksAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
