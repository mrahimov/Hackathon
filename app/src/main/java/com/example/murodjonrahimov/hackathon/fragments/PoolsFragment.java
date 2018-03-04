package com.example.murodjonrahimov.hackathon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.murodjonrahimov.hackathon.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.example.murodjonrahimov.hackathon.controller.PoolsAdapter;
import com.example.murodjonrahimov.hackathon.model.ModelPools;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class PoolsFragment extends Fragment {

  View rootView;
  private List<ModelPools> poolsList;
  private Button indoorButoon;
  private Button outdoorButton;
  private PoolsAdapter adapter;
  private LinearLayoutManager linearLayoutManager;

  public PoolsFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_pools, container, false);

    final RecyclerView poolsRecyclerView = rootView.findViewById(R.id.recyclerview_pool);
    poolsList = new ArrayList<>();

    outdoorButton = rootView.findViewById(R.id.button_outdoor);
    indoorButoon = rootView.findViewById(R.id.button_indoor);

    indoorButoon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          getIndoorPoolsJSON();
        } catch (IOException e) {
          e.printStackTrace();
        }

        adapter = new PoolsAdapter(poolsList);

        poolsRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
      }
    });
    outdoorButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          try {
            getPoolsJSON();
          } catch (IOException e) {
            e.printStackTrace();
          }

          adapter = new PoolsAdapter(poolsList);

          poolsRecyclerView.setAdapter(adapter);
          adapter.notifyDataSetChanged();
        }
      });
    try {
      getPoolsJSON();
    } catch (IOException e) {
      e.printStackTrace();
    }

    adapter = new PoolsAdapter(poolsList);

    linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    poolsRecyclerView.setAdapter(adapter);
    poolsRecyclerView.setLayoutManager(linearLayoutManager);

    return rootView;
  }

  public void getPoolsJSON() throws IOException {
    poolsList.clear();
    InputStream inputStream = getContext().getAssets()
      .open("pools_courts.json");
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

        ModelPools modelPools = new ModelPools();
        modelPools.setName(name);
        modelPools.setLocation(location);
        modelPools.setLat(lat);
        modelPools.setLon(lon);
        modelPools.setImage(R.drawable.pool);
        modelPools.setPhone(phone);

        poolsList.add(modelPools);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public void getIndoorPoolsJSON() throws IOException {
    poolsList.clear();

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

        ModelPools modelPools = new ModelPools();
        modelPools.setName(name);
        modelPools.setLocation(location);
        modelPools.setLat(lat);
        modelPools.setLon(lon);
        modelPools.setImage(R.drawable.swimming_pool);
        modelPools.setPhone(phone);

        poolsList.add(modelPools);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}



