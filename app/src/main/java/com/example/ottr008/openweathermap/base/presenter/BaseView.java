package com.example.ottr008.openweathermap.base.presenter;

import com.example.ottr008.openweathermap.base.presenter.BasePresenter;

/**
 * Created by Vibitha on 7/3/17.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T currentWeatherPresenter);
}