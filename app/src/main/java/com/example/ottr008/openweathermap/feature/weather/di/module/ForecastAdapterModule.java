package com.example.ottr008.openweathermap.feature.weather.di.module;

import com.example.ottr008.openweathermap.datalayer.api.model.response.forecast.ForcastList;
import com.example.ottr008.openweathermap.feature.weather.ui.adaptor.CustomAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 11/1/18.
 */
@Module
public class ForecastAdapterModule {

    private java.util.List<ForcastList> mForcastList;

    public void setAdapterList(java.util.List<ForcastList> forcastList){
        this.mForcastList = forcastList;
    }

    @Provides
    java.util.List<ForcastList> getForcastList(){
        return mForcastList;
    }

    @Provides
    CustomAdapter getCustomAdapter(){
        return new CustomAdapter(getForcastList());
    }
}
