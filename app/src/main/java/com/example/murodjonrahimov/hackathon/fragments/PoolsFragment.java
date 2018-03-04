package com.example.murodjonrahimov.hackathon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.container.PoolsAdapter;
import com.example.murodjonrahimov.hackathon.model.ModelPools;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * A simple {@link Fragment} subclass.
 */
public class PoolsFragment extends Fragment {

  View rootView;
  List<ModelPools> poolsList;

  public PoolsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_pools, container, false);

    RecyclerView poolsRecyclerView = rootView.findViewById(R.id.recyclerview_pool);
    poolsList = new ArrayList<>();

    try {
      getPoolsJSON();
    } catch (IOException e) {
      e.printStackTrace();
    }

    PoolsAdapter adapter = new PoolsAdapter(poolsList);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    poolsRecyclerView.setAdapter(adapter);
    poolsRecyclerView.setLayoutManager(linearLayoutManager);

    return rootView;
  }

  public void getPoolsJSON() throws IOException {
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

      for (int i = 0; i < jsonArray.length(); i++) {
        name = jsonArray.getJSONObject(i)
          .getString("Name");
        location = jsonArray.getJSONObject(i)
          .getString("Location");
        lat = jsonArray.getJSONObject(i)
          .getString("lat");
        lon = jsonArray.getJSONObject(i)
          .getString("lon");

        ModelPools modelPools = new ModelPools();
        modelPools.setName(name);
        modelPools.setLocation(location);
        modelPools.setLat(lat);
        modelPools.setLon(lon);
        modelPools.setImage(R.drawable.pool);

        poolsList.add(modelPools);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
