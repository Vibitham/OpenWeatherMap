package com.example.ottr008.openweathermap.feature.weather.di.module;

import android.content.Context;

import com.example.ottr008.openweathermap.feature.weather.presenter.impl.CurrentWeatherPresenter;
import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.CurrentWeatherContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 12/1/18.
 */

@Module
public class CurrentWeatherModule {

    private CurrentWeatherContract.View currentWeatherView;

    @Provides
    CurrentWeatherContract.View getCurrentWeatherView(){
        return currentWeatherView;
    }

    @Provides
    CurrentWeatherContract.Presenter getCurrentWeatherpresenter(){
        return new CurrentWeatherPresenter(currentWeatherView);
    }
}
