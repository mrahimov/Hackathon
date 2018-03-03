package com.example.murodjonrahimov.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.http.HEAD;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

<<<<<<<HEAD
    Button recreationButton = findViewById(R.id.recreation_button);
    Button programsButton = findViewById(R.id.programs_button);

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
=======

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/")
            .build();

>>>>>>> 2654348aba186f7cf3814e6aceed4c398f9bf6d9
  }
}
