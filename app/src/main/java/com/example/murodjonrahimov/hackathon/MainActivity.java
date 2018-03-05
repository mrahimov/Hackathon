package com.example.murodjonrahimov.hackathon;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.murodjonrahimov.hackathon.fragments.FavoriteFragment;
import com.example.murodjonrahimov.hackathon.fragments.HomeFragment;
import com.example.murodjonrahimov.hackathon.fragments.MapFragment;
import com.example.murodjonrahimov.hackathon.fragments.OutOfSchoolProgramsFragment;
import com.example.murodjonrahimov.hackathon.fragments.RecreationalFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.FragmentListener {

  private ActionBar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String customFont = "Carrington.ttf";

    toolbar = getSupportActionBar();
    toolbar.setTitle("Home");
    loadFragment(new HomeFragment());

    BottomNavigationView navigation = findViewById(R.id.navigation);

    navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment;

        switch (item.getItemId()) {
          case R.id.navigation_home:
            toolbar.setTitle("Home");
            fragment = new HomeFragment();
            loadFragment(fragment);
            return true;
          case R.id.navigation_favorite:
            toolbar.setTitle("Favourite");
            fragment = new FavoriteFragment();
            loadFragment(fragment);
            return true;
          case R.id.navigation_map:
            toolbar.setTitle("Map");
            fragment = new MapFragment();
            loadFragment(fragment);
            return true;
        }
        return false;
      }
    });
  }

  private void loadFragment(Fragment fragment) {

    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.frame_container, fragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

  @Override
  public void swapWithRecreationalFragment() {
    RecreationalFragment recreationalFragment = new RecreationalFragment();
    loadFragment(recreationalFragment);
  }

  @Override
  public void swapWithOutOfSchoolFragment() {
    OutOfSchoolProgramsFragment outOfSchoolProgramsFragment = new OutOfSchoolProgramsFragment();
    loadFragment(outOfSchoolProgramsFragment);
  }


}

