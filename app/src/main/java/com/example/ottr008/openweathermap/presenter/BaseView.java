package com.example.ottr008.openweathermap.presenter;

/**
 * Created by Vibitha on 7/3/17.
 */

public interface BaseView<T> {
    void setPresenter(T currentWeatherPresenter);
}