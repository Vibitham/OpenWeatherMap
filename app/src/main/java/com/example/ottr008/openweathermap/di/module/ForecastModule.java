package com.example.ottr008.openweathermap.di.module;

import android.content.Context;

import com.example.ottr008.openweathermap.presenter.ForecastTabPresenter;
import com.example.ottr008.openweathermap.presenter.contracts.ForecastTabContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 11/1/18.
 */

@Module
public class ForecastModule {
    private ForecastTabContract.View forecastTabView;
    private Context context;

    public ForecastModule() {

    }

    public void setForecastTabFragment(ForecastTabContract.View forecastTabFragment){
        this.forecastTabView = forecastTabFragment;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Provides
    ForecastTabContract.View getForecastView(){
        return forecastTabView;
    }

    @Provides
    Context getContext(){
        return context;
    }

    @Provides
    ForecastTabContract.Presenter getForecastPresenter(){
        return new ForecastTabPresenter(getForecastView(),getContext());
    }


}
