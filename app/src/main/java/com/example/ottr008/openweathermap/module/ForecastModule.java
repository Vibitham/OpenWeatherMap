package com.example.ottr008.openweathermap.module;

import android.content.Context;

import com.example.ottr008.openweathermap.presenter.CurrentWeatherPresenter;
import com.example.ottr008.openweathermap.presenter.ForecastTabPresenter;
import com.example.ottr008.openweathermap.presenter.contracts.CurrentWeatherContract;
import com.example.ottr008.openweathermap.presenter.contracts.ForecastTabContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 11/1/18.
 */

@Module
public class ForecastModule {
    private ForecastTabContract.View forecastTabView;
    private CurrentWeatherContract.View currentWeatherView;
    private Context context;

    public ForecastModule() {

    }

    public void setForecastTabFragment(ForecastTabContract.View forecastTabFragment){
        this.forecastTabView = forecastTabFragment;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void setCurrentWeatherView(CurrentWeatherContract.View currentWeatherFragment){
        this.currentWeatherView = currentWeatherFragment;
    }

    @Provides
    ForecastTabContract.View getForecastView(){
        return forecastTabView;
    }

    @Provides
    CurrentWeatherContract.View getCurrentWeatherView(){
        return currentWeatherView;
    }

    @Provides
    Context getContext(){
        return context;
    }

    @Provides
    ForecastTabContract.Presenter getForecastPresenter(){
        return new ForecastTabPresenter(getForecastView(),context);
    }

    @Provides
    CurrentWeatherContract.Presenter getCurrentWeatherpresenter(){
        return new CurrentWeatherPresenter(getCurrentWeatherView(),context);
    }


}
