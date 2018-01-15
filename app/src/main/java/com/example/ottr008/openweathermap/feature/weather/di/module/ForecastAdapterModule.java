package com.example.ottr008.openweathermap.feature.weather.di.module;

import com.example.ottr008.openweathermap.services.model.forecastresponsemodel.List;
import com.example.ottr008.openweathermap.feature.weather.ui.adaptor.CustomAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 11/1/18.
 */
@Module
public class ForecastAdapterModule {

    private java.util.List<List> list;

    public void setAdapterList(java.util.List<List> list){
        this.list = list;
    }

    @Provides
    java.util.List<List> getList(){
        return list;
    }

    @Provides
    CustomAdapter getCustomAdapter(){
        return new CustomAdapter(getList());
    }
}
