package com.example.ottr008.openweathermap.component;

import com.example.ottr008.openweathermap.module.CurrentWeatherModule;
import com.example.ottr008.openweathermap.ui.activity.WeatherMapActivity;

import dagger.Component;

/**
 * Created by vibitha on 12/1/18.
 */
@Component(modules = CurrentWeatherModule.class)
public interface CurrentWeatherComponent {



    void inject(WeatherMapActivity activity);
}
