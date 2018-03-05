package com.example.murodjonrahimov.hackathon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.backend.AppDatabase;
import com.example.murodjonrahimov.hackathon.controller.CourtsAdapter;
import com.example.murodjonrahimov.hackathon.model.TennisCourt;
import org.json.JSONArray;
import org.json.JSONException;
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
  List<TennisCourt> tennisBallCourts;
  Button buttonTennis;
  Button buttonBasketBall;
  Button buttonHandBall;

  public CourtsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootview = inflater.inflate(R.layout.fragment_courts, container, false);
    courtRV = rootview.findViewById(R.id.courts_rv);
    tennisBallCourts = new ArrayList<>();

    buttonBasketBall = rootview.findViewById(R.id.button_basketball);
    buttonTennis = rootview.findViewById(R.id.button_tennis);
    buttonHandBall = rootview.findViewById(R.id.button_handball);

    buttonTennis.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          getTennisCourtJSON();
        } catch (IOException e) {
          e.printStackTrace();
        }
        courtsAdapter = new CourtsAdapter(tennisBallCourts);
        courtRV.setAdapter(courtsAdapter);
        courtsAdapter.notifyDataSetChanged();
      }
    });
    buttonBasketBall.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          getBasketBallJSON();
        } catch (IOException e) {
          e.printStackTrace();
        }
        courtsAdapter = new CourtsAdapter(tennisBallCourts);
        courtRV.setAdapter(courtsAdapter);
        courtsAdapter.notifyDataSetChanged();
      }
    });
    buttonHandBall.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          getHandBallJSON();
        } catch (IOException e) {
          e.printStackTrace();
        }
        courtsAdapter = new CourtsAdapter(tennisBallCourts);
        courtRV.setAdapter(courtsAdapter);
        courtsAdapter.notifyDataSetChanged();
      }
    });
    try {
      getTennisCourtJSON();
    } catch (IOException e) {
      e.printStackTrace();
    }
    courtsAdapter = new CourtsAdapter(tennisBallCourts);
    linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    courtRV.setAdapter(courtsAdapter);
    courtRV.setLayoutManager(linearLayoutManager);

    return rootview;
  }

  public void getBasketBallJSON() throws IOException {
    tennisBallCourts.clear();
    InputStream inputStream = getContext().getAssets()
      .open("basketball_courts.json");
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

      for (int i = 0; i < keyArray.length(); i++) {
        name = keyArray.getJSONObject(i)
          .getString("Name");
        location = keyArray.getJSONObject(i)
          .getString("Location");

        TennisCourt bc = new TennisCourt();
        bc.setName(name);
        bc.setLocation(location);
        bc.setImage(R.drawable.basketball);

        tennisBallCourts.add(bc);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public void getHandBallJSON() throws IOException {
    tennisBallCourts.clear();
    InputStream inputStream = getContext().getAssets()
      .open("handball_courts.json");
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
      String name;
      String location;

      for (int i = 0; i < keyArray.length(); i++) {
        name = keyArray.getJSONObject(i)
          .getString("Name");
        location = keyArray.getJSONObject(i)
          .getString("Location");

        TennisCourt hc = new TennisCourt();
        hc.setName(name);
        hc.setLocation(location);
        hc.setImage(R.drawable.handball);

        tennisBallCourts.add(hc);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public void getTennisCourtJSON() throws IOException {
    tennisBallCourts.clear();
    InputStream inputStream = getContext().getAssets()
      .open("tennis_courts.json");
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
      String name;
      String location;

      for (int i = 0; i < keyArray.length(); i++) {
        name = keyArray.getJSONObject(i)
          .getString("Name");
        location = keyArray.getJSONObject(i)
          .getString("Location");

        TennisCourt tc = new TennisCourt();
        tc.setName(name);
        tc.setLocation(location);
        tc.setImage(R.drawable.tennis);

        tennisBallCourts.add(tc);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
