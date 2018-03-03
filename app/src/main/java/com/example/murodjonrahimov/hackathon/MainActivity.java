package com.example.murodjonrahimov.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

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
  }
}
