package com.example.murodjonrahimov.hackathon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.murodjonrahimov.hackathon.fragments.CourtsFragment;
import com.example.murodjonrahimov.hackathon.fragments.ParksFragment;
import com.example.murodjonrahimov.hackathon.fragments.PoolsFragment;

/**
 * Created by olgakoleda on 3/3/18.
 */

public class RecreationalActivitiesTabsPagerAdapter extends FragmentPagerAdapter {

    private int NUMBER_OF_ITEMS = 3;
    private String[] titles = new String[]{"Park", "Pools", "Courts"};

    public RecreationalActivitiesTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ParksFragment();
            case 1:
                return new PoolsFragment();
            case 2:
                return new CourtsFragment();
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
