package com.example.ottr008.openweathermap.di.component;

import com.example.ottr008.openweathermap.di.module.ForecastModule;
import com.example.ottr008.openweathermap.presenter.ForecastTabPresenter;
import com.example.ottr008.openweathermap.ui.activity.WeatherMapActivity;

import dagger.Component;

/**
 * Created by vibitha on 11/1/18.
 */
@Component(modules = ForecastModule.class)

public interface ForecastPresenterComponent {

    ForecastTabPresenter getForecastPresenter();
    void inject(WeatherMapActivity activity);


}
