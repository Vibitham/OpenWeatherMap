package com.example.ottr008.openweathermap.feature.weather.presenter.contracts;

import android.support.design.widget.TabLayout;

import com.example.ottr008.openweathermap.base.presenter.BasePresenter;
import com.example.ottr008.openweathermap.base.presenter.BaseView;

/**
 * Created by Vibitha on 7/3/17.
 */

public interface WeatherMapContract {

    interface  View extends BaseView<Presenter>
    {

    }

    interface Presenter extends BasePresenter
    {
        void setTabText(TabLayout tablayout);
    }
}
