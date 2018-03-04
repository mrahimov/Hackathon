package com.example.murodjonrahimov.hackathon.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.controller.ParksAdapter;
import com.example.murodjonrahimov.hackathon.model.Parks;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParksFragment extends Fragment {

    private static final String PARK_RESPONSE = "response";
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

    private class AsyncTaskRunner extends AsyncTask<String, String, ArrayList<Parks>> {

        @Override
        protected ArrayList<Parks> doInBackground(String... params) {

            String json = loadJSONFromAsset();
            Gson gson = new Gson();
            ArrayList<Parks> listOfParks = gson.fromJson(json, new TypeToken<ArrayList<Parks>>() {
            }.getType());
            return listOfParks;
        }

        @Override
        protected void onPostExecute(ArrayList<Parks> listOfParks) {

//            Parks park = listOfParks.get(2);
//            Log.d(PARK_RESPONSE, park.getName());

            ParksAdapter parksAdapter = new ParksAdapter(listOfParks);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setAdapter(parksAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
