package com.example.murodjonrahimov.hackathon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.controller.CourtsAdapter;
import com.example.murodjonrahimov.hackathon.model.BasketBallCourt;
import com.example.murodjonrahimov.hackathon.model.HandBallCourt;
import com.example.murodjonrahimov.hackathon.model.TennisCourt;

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

    View rootview;
    RecyclerView courtRV;
    CourtsAdapter courtsAdapter;
    LinearLayoutManager linearLayoutManager;

    List<BasketBallCourt> basketBallCourts = new ArrayList<>();
    List<HandBallCourt> handBallCourts = new ArrayList<>();
    List<TennisCourt> tennisBallCourts;

    public CourtsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_courts, container, false);

        courtRV = rootview.findViewById(R.id.courts_rv);
        tennisBallCourts = new ArrayList<>();

        try {
//            getBasketBallJSON();
//            getHandBallJSON();
            getTennisCourtJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        courtsAdapter = new CourtsAdapter(tennisBallCourts);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        courtRV.setAdapter(courtsAdapter);
        courtRV.setLayoutManager(linearLayoutManager);

        return rootview;
    }

    public void getBasketBallJSON() throws IOException {
        InputStream inputStream = getContext().getAssets().open("basketball_courts.json");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int size;
        try {
            size = inputStream.read();
            while (size != -1) {
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

    public void getHandBallJSON() throws IOException {
        InputStream inputStream = getContext().getAssets().open("handball_courts.json");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int size;
        try {
            size = inputStream.read();
            while (size != -1) {
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

                HandBallCourt hc = new HandBallCourt();
                hc.setName(name);
                hc.setLocation(location);
                hc.setNum_of_Courts(numOfCourts);

                handBallCourts.add(hc);
                Log.d("handball name: ", hc.getName());
                Log.d("handball location: ", hc.getLocation());
                Log.d("handball courts: ", hc.getNum_of_Courts());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getTennisCourtJSON() throws IOException {
        InputStream inputStream = getContext().getAssets().open("tennis_courts.json");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int size;
        try {
            size = inputStream.read();
            while (size != -1) {
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
            String phone = "";
            String numOfCourts = "";
            String levelType = "";
            String type = "";

            for (int i = 0; i < keyArray.length(); i++) {
                name = keyArray.getJSONObject(i).getString("Name");
                location = keyArray.getJSONObject(i).getString("Location");
                numOfCourts = keyArray.getJSONObject(i).getString("Courts");
                type = keyArray.getJSONObject(i).getString("Indoor_Outdoor");

                TennisCourt tc = new TennisCourt();
                tc.setName(name);
                tc.setPhone(phone);
                tc.setLocation(location);
                tc.setCourts(numOfCourts);
                tc.setTennis_Type(levelType);
                tc.setIndoor_Outdoor(type);

                tennisBallCourts.add(tc);
                Log.d("tennis name: ", tc.getName());
                Log.d("tennis location: ", tc.getLocation());
                Log.d("tennis courts: ", tc.getCourts());
                Log.d("tennis", tc.getIndoor_Outdoor());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
