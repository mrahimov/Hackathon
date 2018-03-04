package com.example.murodjonrahimov.hackathon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.BasketBallCourt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourtsFragment extends Fragment {

<<<<<<< HEAD
    View rootView;

=======
    List<BasketBallCourt> basketBallCourts = new ArrayList<>();
>>>>>>> master

    public CourtsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        rootView = inflater.inflate(R.layout.fragment_courts, container, false);


        return rootView;
=======
        // Inflate the layout for this fragment
        try {
            getBasketBallJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.fragment_courts, container, false);
>>>>>>> master
    }

    public void getBasketBallJSON() throws IOException {
        InputStream inputStream = getContext().getAssets().open("basketball_courts.json");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int size;
        try{
            size = inputStream.read();
            while(size != -1) {
                byteArrayOutputStream.write(size);
                size = inputStream.read();
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONArray keyArray = new JSONArray(byteArrayOutputStream.toString());
            Log.d("key array", keyArray.toString());
            String name = "";
            String location = "";
            String numOfCourts = "";

            for (int i = 0; i < keyArray.length(); i++) {
                name = keyArray.getJSONObject(i).getString("Name");
                location = keyArray.getJSONObject(i).getString("Location");
                numOfCourts = keyArray.getJSONObject(i).getString("Num_of_Courts");

                BasketBallCourt bc = new BasketBallCourt();
                bc.setName(name);
                bc.setLocation(location);
                bc.setNum_of_Courts(numOfCourts);

                basketBallCourts.add(bc);
                Log.d("basketball name: ", bc.getName());
                Log.d("basketball location: ", bc.getLocation());
                Log.d("basketball courts: ", bc.getNum_of_Courts());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
