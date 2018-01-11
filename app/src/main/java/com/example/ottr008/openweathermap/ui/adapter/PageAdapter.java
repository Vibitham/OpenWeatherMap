package com.example.ottr008.openweathermap.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.example.ottr008.openweathermap.ui.fragment.CurrentWeatherFragment;
import com.example.ottr008.openweathermap.ui.fragment.ForecastTabFragment;

/**
 * Created by Vibitha on 7/3/17.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
   private int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public final Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new CurrentWeatherFragment();
            case 1:
                return new ForecastTabFragment();
            default:
                return null;
        }
    }

    @Override
    public final int getCount() {
        return mNumOfTabs;
    }
}