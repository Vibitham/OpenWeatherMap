package com.example.ottr008.openweathermap.feature.weather.di.component;

import com.example.ottr008.openweathermap.feature.weather.di.module.ForecastModule;
import com.example.ottr008.openweathermap.feature.weather.ui.activity.WeatherMapActivity;

import dagger.Component;

/**
 * Created by vibitha on 11/1/18.
 */
@Component(modules = ForecastModule.class)

public interface ForecastPresenterComponent {

    void inject(WeatherMapActivity activity);
}
