package com.example.murodjonrahimov.hackathon.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.RecreationalActivitiesTabsPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecreationalFragment extends Fragment {

    private ViewPager pager;
    private RecreationalActivitiesTabsPagerAdapter adapter;



    public RecreationalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recreational, container, false);


        pager = rootView.findViewById(R.id.pager);
        adapter = new RecreationalActivitiesTabsPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
        return rootView;
    }

}
