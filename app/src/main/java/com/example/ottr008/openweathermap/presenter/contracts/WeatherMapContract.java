package com.example.ottr008.openweathermap.presenter.contracts;

import android.support.design.widget.TabLayout;

import com.example.ottr008.openweathermap.presenter.BaseView;

/**
 * Created by Vibitha on 7/3/17.
 */

public interface WeatherMapContract {

    interface  View extends BaseView<Presenter>
    {

    }

    interface Presenter
    {
        void setTabText(TabLayout tablayout);
    }
}
