package com.example.ottr008.openweathermap.di.component;

import com.example.ottr008.openweathermap.di.module.ForecastModule;
import com.example.ottr008.openweathermap.di.module.SettingsModule;
import com.example.ottr008.openweathermap.ui.activity.SettingsActivity;
import com.example.ottr008.openweathermap.ui.activity.WeatherMapActivity;

import dagger.Component;

/**
 * Created by vibitha on 17/1/18.
 */
@Component(modules = SettingsModule.class)

public interface SettingsComponent {
    void inject(SettingsActivity activity);
}
