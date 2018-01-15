package com.example.ottr008.openweathermap.feature.weather.di.component;

import com.example.ottr008.openweathermap.feature.weather.di.module.ForecastAdapterModule;
import com.example.ottr008.openweathermap.feature.weather.ui.fragment.ForecastTabFragment;

import dagger.Component;

/**
 * Created by vibitha on 12/1/18.
 */
@Component(modules = ForecastAdapterModule.class)

public interface ForecastAdapterComponent {
    void inject(ForecastTabFragment forecastTabFragment);
}
