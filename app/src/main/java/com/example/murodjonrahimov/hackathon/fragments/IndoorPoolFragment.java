package com.example.murodjonrahimov.hackathon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.controller.IndoorPoolsAdapter;
import com.example.murodjonrahimov.hackathon.model.ModelIndoorPools;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class IndoorPoolFragment extends Fragment {

  View rootView;
  private List<ModelIndoorPools> indoorPoolsList;
  //private Button indoorButoon;

  public IndoorPoolFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_indoor_pool, container, false);

    RecyclerView poolsRecyclerView = rootView.findViewById(R.id.recyclerview_pool_indor);
    indoorPoolsList = new ArrayList<>();

    //indoorButoon = rootView.findViewById(R.id.button_outdoor);
    //indoorButoon.setOnClickListener(new View.OnClickListener() {
    //  @Override
    //  public void onClick(View v) {
    //    try {
    //      getIndoorPoolsJSON();
    //    } catch (IOException e) {
    //      e.printStackTrace();
    //    }



    //  }
    //});
    try {
      getPoolsJSON();
    } catch (IOException e) {
      e.printStackTrace();
    }

    IndoorPoolsAdapter adapter = new IndoorPoolsAdapter(indoorPoolsList);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    poolsRecyclerView.setAdapter(adapter);
    poolsRecyclerView.setLayoutManager(linearLayoutManager);

    return rootView;
  }

  public void getPoolsJSON() throws IOException {
    InputStream inputStream = getContext().getAssets()
      .open("indoor_pools.json");
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
      JSONArray jsonArray = new JSONArray(byteArrayOutputStream.toString());
      String name;
      String location;
      String lat;
      String lon;
      String phone;

      for (int i = 0; i < jsonArray.length(); i++) {
        name = jsonArray.getJSONObject(i)
          .getString("Name");
        location = jsonArray.getJSONObject(i)
          .getString("Location");
        lat = jsonArray.getJSONObject(i)
          .getString("lat");
        lon = jsonArray.getJSONObject(i)
          .getString("lon");
        phone = jsonArray.getJSONObject(i)
          .getString("Phone");

        ModelIndoorPools modelIndoorPools = new ModelIndoorPools();
        modelIndoorPools.setName(name);
        modelIndoorPools.setLocation(location);
        modelIndoorPools.setLat(lat);
        modelIndoorPools.setLon(lon);
        modelIndoorPools.setImage(R.drawable.pool);
        modelIndoorPools.setPhone(phone);

        indoorPoolsList.add(modelIndoorPools);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  public void getIndoorPoolsJSON() throws IOException {
    InputStream inputStream = getContext().getAssets()
      .open("indoor_pools.json");
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
      JSONArray jsonArray = new JSONArray(byteArrayOutputStream.toString());
      String name;
      String location;
      String lat;
      String lon;
      String phone;

      for (int i = 0; i < jsonArray.length(); i++) {
        name = jsonArray.getJSONObject(i)
          .getString("Name");
        location = jsonArray.getJSONObject(i)
          .getString("Location");
        lat = jsonArray.getJSONObject(i)
          .getString("lat");
        lon = jsonArray.getJSONObject(i)
          .getString("lon");
        phone = jsonArray.getJSONObject(i)
          .getString("Phone");

        ModelIndoorPools modelIndoorPools = new ModelIndoorPools();
        modelIndoorPools.setName(name);
        modelIndoorPools.setLocation(location);
        modelIndoorPools.setLat(lat);
        modelIndoorPools.setLon(lon);
        modelIndoorPools.setImage(R.drawable.pool);
        modelIndoorPools.setPhone(phone);

        indoorPoolsList.add(modelIndoorPools);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}

