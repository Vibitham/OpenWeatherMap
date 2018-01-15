package com.example.ottr008.openweathermap.feature.weather.presenter.impl;

import android.content.Context;
import android.support.design.widget.TabLayout;


import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.WeatherMapContract;

/**
 * Created by Vibitha on 7/3/17.
 */

public class WeatherMapPresenter implements WeatherMapContract.Presenter{

    private WeatherMapContract.View view;

    public WeatherMapPresenter(WeatherMapContract.View weatherMapContract, Context ctxt) {
        view = weatherMapContract;
        view.setPresenter(this);
    }

    @Override
    public final void setTabText(TabLayout tablayout) {
        tablayout.addTab(tablayout.newTab().setText("Now"));
        tablayout.addTab(tablayout.newTab().setText("Forecast"));
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
}
