package com.example.ottr008.openweathermap.di.component;

import com.example.ottr008.openweathermap.di.module.ForecastAdapterModule;
import com.example.ottr008.openweathermap.ui.fragment.ForecastTabFragment;

import dagger.Component;

/**
 * Created by vibitha on 12/1/18.
 */
@Component(modules = ForecastAdapterModule.class)

public interface ForecastAdapterComponent {
    void inject(ForecastTabFragment forecastTabFragment);
}
