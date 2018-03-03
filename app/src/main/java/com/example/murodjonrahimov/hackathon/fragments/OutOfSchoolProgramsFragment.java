package com.example.murodjonrahimov.hackathon.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.murodjonrahimov.hackathon.OutOfSchoolTabsPagerAdapter;
import com.example.murodjonrahimov.hackathon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutOfSchoolProgramsFragment extends Fragment {

    private ViewPager pager;
    private OutOfSchoolTabsPagerAdapter adapter;


    public OutOfSchoolProgramsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_out_of_school_programs, container, false);

        pager = rootView.findViewById(R.id.pager);
        adapter = new OutOfSchoolTabsPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
        return rootView;

    }

}
