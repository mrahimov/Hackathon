package com.example.murodjonrahimov.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/")
            .build();

  }
}
