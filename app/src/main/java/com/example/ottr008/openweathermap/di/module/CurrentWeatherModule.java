package com.example.ottr008.openweathermap.di.module;

import android.content.Context;

import com.example.ottr008.openweathermap.presenter.CurrentWeatherPresenter;
import com.example.ottr008.openweathermap.presenter.contracts.CurrentWeatherContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 12/1/18.
 */

@Module
public class CurrentWeatherModule {

    private CurrentWeatherContract.View currentWeatherView;
    private Context weatherContext;

    public void setCurrentWeatherView(CurrentWeatherContract.View currentWeatherFragment){
        this.currentWeatherView = currentWeatherFragment;
    }

    public void setWeatherContext(Context weatherContext){
        this.weatherContext = weatherContext;
    }

    @Provides
    CurrentWeatherContract.Presenter getCurrentWeatherpresenter(){
        return new CurrentWeatherPresenter(currentWeatherView, weatherContext);
    }


    @Provides
    CurrentWeatherContract.View getCurrentWeatherView(){
        return currentWeatherView;
    }

    @Provides
    Context getWeatherContext(){
        return weatherContext;
    }

}
