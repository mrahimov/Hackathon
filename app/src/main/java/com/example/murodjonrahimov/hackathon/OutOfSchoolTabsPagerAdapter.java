package com.example.murodjonrahimov.hackathon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.murodjonrahimov.hackathon.fragments.JobsAndInternshipFragment;
import com.example.murodjonrahimov.hackathon.fragments.VolunteeringOpportunitiesFragment;

/**
 * Created by olgakoleda on 3/3/18.
 */

public class OutOfSchoolTabsPagerAdapter extends FragmentPagerAdapter {

    private int NUMBER_OF_ITEMS = 2;
    private String[] titles = new String[]{"Jobs & Internships", "Volunteering Opportunities"};

    public OutOfSchoolTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new JobsAndInternshipFragment();
            case 1:
                return new VolunteeringOpportunitiesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


}
