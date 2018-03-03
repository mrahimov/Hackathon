package com.example.murodjonrahimov.hackathon.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.TabsPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private Button recreationalActivitiesButton;
    private Button outOfSchoolPrograms;
    private FragmentListener fragmentListener;

    public HomeFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            fragmentListener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recreationalActivitiesButton = rootView.findViewById(R.id.recreational_activities_button);
        outOfSchoolPrograms = rootView.findViewById(R.id.programs_button);

        recreationalActivitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.swapWithRecreationalFragment();
            }
        });

        outOfSchoolPrograms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.swapWithOutOfSchoolFragment();

            }
        });
        return rootView;
    }

    public interface FragmentListener {
        void swapWithRecreationalFragment();
        void swapWithOutOfSchoolFragment();
    }


}
