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

    public ForecastModule(ForecastTabFragment forecastTabFragment,Context context) {
        this.forecastTabFragment = forecastTabFragment;
        this.context = context;
    }

    @Provides
    ForecastTabPresenter getForecastPresenter(){
        return new ForecastTabPresenter(forecastTabFragment,context);
    }


}
