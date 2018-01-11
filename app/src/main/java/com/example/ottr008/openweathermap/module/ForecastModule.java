package com.example.ottr008.openweathermap.module;

import android.content.Context;

import com.example.ottr008.openweathermap.presenter.ForecastTabPresenter;
import com.example.ottr008.openweathermap.ui.fragment.ForecastTabFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 11/1/18.
 */

@Module
public class ForecastModule {
    private ForecastTabFragment forecastTabFragment;
    private Context context;

    public ForecastModule() {

    }

    public void setForecastTabFragment(ForecastTabFragment forecastTabFragment){
        this.forecastTabFragment = forecastTabFragment;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Provides
    ForecastTabFragment getForecastTabFragment(){
        return forecastTabFragment;
    }

    @Provides
    Context getContext(){
        return context;
    }

    @Provides
    ForecastTabPresenter getForecastPresenter(){
        return new ForecastTabPresenter(forecastTabFragment,context);
    }


}
