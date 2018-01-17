package com.example.ottr008.openweathermap.di.module;

import com.example.ottr008.openweathermap.ui.fragment.ForecastTabFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 17/1/18.
 */
@Module
public class TabFragmentModule {

    @Provides
    public ForecastTabFragment getTabFragment(){
        return new ForecastTabFragment();
    }
}
