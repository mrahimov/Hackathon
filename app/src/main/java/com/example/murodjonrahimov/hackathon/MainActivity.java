package com.example.murodjonrahimov.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.murodjonrahimov.hackathon.model.Job;
import com.example.murodjonrahimov.hackathon.network.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button recreationButton = findViewById(R.id.recreation_button);
    Button programsButton = findViewById(R.id.programs_button);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Service service = retrofit.create(Service.class);

    Call<List<Job>> call = service.getJobs();

    call.enqueue(new Callback<List<Job>>() {
      @Override
      public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
        Log.d("SUCESSSSSS", response.body().get(0).toString());
      }

      @Override
      public void onFailure(Call<List<Job>> call, Throwable t) {

        t.printStackTrace();
      }
    });

    recreationButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, RecreationalActivity.class);
        startActivity(intent);

      }
    });

    programsButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, OutOfSchoolProgramsActivity.class);
        startActivity(intent);

      }
    });




  }
}
