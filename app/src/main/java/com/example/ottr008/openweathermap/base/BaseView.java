package com.example.ottr008.openweathermap.base;

/**
 * Created by Vibitha on 7/3/17.
 */

public interface BaseView<T> {
    void setPresenter(T currentWeatherPresenter);
}