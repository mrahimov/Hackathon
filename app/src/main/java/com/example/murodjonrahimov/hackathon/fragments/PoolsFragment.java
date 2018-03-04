package com.example.murodjonrahimov.hackathon.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PoolsFragment extends Fragment {

  View rootView;
  public PoolsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_pools, container, false);





    return rootView;
  }

}
