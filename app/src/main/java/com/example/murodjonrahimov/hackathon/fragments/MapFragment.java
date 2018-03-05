package com.example.murodjonrahimov.hackathon.fragments;


import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.backend.AppDatabase;
import com.example.murodjonrahimov.hackathon.model.MyFavourite;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    View rootView;
    MapView mapView;
    GoogleMap myGoogleMap;
    FusedLocationProviderClient fLocationPC;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = rootView.findViewById(R.id.mapView_id);
        mapView.getMapAsync(this);
        fLocationPC = LocationServices.getFusedLocationProviderClient(getActivity());


        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = rootView.findViewById(R.id.mapView_id);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (getContext() != null) {
            MapsInitializer.initialize(getContext());
            this.myGoogleMap = googleMap;
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        }
        MapsInitializer.initialize(getContext());
        myGoogleMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1020);
        } else {
            myGoogleMap.setMyLocationEnabled(true);
            fLocationPC.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null) {
                        double lat = location.getLatitude();
                        double lng = location.getLongitude();
                        LatLng currentLocation = new LatLng(lat, lng);
//                        CameraPosition cameraPosition = new CameraPosition.Builder().target(currentLocation).zoom(12).build();
//                        myGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        myGoogleMap.addMarker(new MarkerOptions().position(currentLocation).title("Current Location"));
                        myGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
                        UiSettings uiSettings = myGoogleMap.getUiSettings();
                        uiSettings.setZoomControlsEnabled(true);
                        uiSettings.setMyLocationButtonEnabled(true);

                    }
                }
            });
        }

        Geocoder geocoder = new Geocoder(getContext());
        AppDatabase db = AppDatabase.getAppDatabase(getActivity());
        List<MyFavourite> favoriteFellows = db.myFavDao().getFavorite();
        List<Address> myFavesAddresses;
        LatLng faves;

        for (int i = 0; i < favoriteFellows.size(); i++) {
            try {
                myFavesAddresses = geocoder.getFromLocationName(favoriteFellows.get(i).getLocation()+favoriteFellows.get(i), favoriteFellows.size());
                if(myFavesAddresses != null) {
                    for (int j = 0; j < myFavesAddresses.size(); j++) {
                        Address location = myFavesAddresses.get(j);
                        faves = new LatLng(location.getLatitude(), location.getLongitude());
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(faves).zoom(12).build();
                        myGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        myGoogleMap.addMarker(new MarkerOptions().position(faves));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}