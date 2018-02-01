package com.example.ottr008.openweathermap.feature.weather.di.module;

import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.CurrentWeatherContract;
import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.ForecastTabContract;
import com.example.ottr008.openweathermap.feature.weather.presenter.impl.CurrentWeatherPresenter;
import com.example.ottr008.openweathermap.feature.weather.presenter.impl.ForecastTabPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 11/1/18.
 */

@Module
public class ForecastModule {

    private ForecastTabContract.View forecastTabView;

    private CurrentWeatherContract.View currentWearherView;


    public ForecastModule(ForecastTabContract.View forecastTabView, CurrentWeatherContract.View currentWearherView) {
        this.forecastTabView = forecastTabView;
        this.currentWearherView = currentWearherView;
    }


    @Provides
    ForecastTabContract.View getForecastTabView(){
        return forecastTabView;
    }

    @Provides
    CurrentWeatherContract.View getCurrentWeatherView(){
        return currentWearherView;
    }


    @Provides
    ForecastTabContract.Presenter getForecastPresenter(){
        return new ForecastTabPresenter(forecastTabView);
    }

    @Provides
    CurrentWeatherContract.Presenter getCurrentWeatherPresenter(){
        return new CurrentWeatherPresenter(currentWearherView);
    }


}
