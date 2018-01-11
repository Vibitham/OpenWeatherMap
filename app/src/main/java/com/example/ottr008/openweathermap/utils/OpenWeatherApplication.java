package com.example.ottr008.openweathermap.utils;

import android.app.Application;
import android.content.Context;

import com.example.ottr008.openweathermap.component.DaggerForecastPresenterComponent;
import com.example.ottr008.openweathermap.component.ForecastPresenterComponent;
import com.example.ottr008.openweathermap.module.ForecastModule;
import com.example.ottr008.openweathermap.ui.fragment.CurrentWeatherFragment;
import com.example.ottr008.openweathermap.ui.fragment.ForecastTabFragment;

/**
 * Created by vibitha on 11/1/18.
 */

public class OpenWeatherApplication extends Application {
    private static ForecastPresenterComponent sForecastPresenterComponent;
    private static ForecastModule sForecastModule;
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
    }

    public static void setApplication(Application application) {
        OpenWeatherApplication.application = application;
    }

    public static void setForecastView(ForecastTabFragment forecastFragment){
        if(sForecastModule == null){
            sForecastModule = new ForecastModule();
        }
        sForecastModule.setForecastTabFragment(forecastFragment);
    }

    public static void setContext(Context context){
        if(sForecastModule == null){
            sForecastModule = new ForecastModule();
        }
        sForecastModule.setContext(context);
    }

    public static void buildApplicationComponent(){
        sForecastPresenterComponent = DaggerForecastPresenterComponent.builder()
                .forecastModule(sForecastModule)
                .build();
    }

    public static ForecastPresenterComponent getForecastPresenterComponent() {
        return sForecastPresenterComponent;
    }

    public static void setCurrentWeatherView(CurrentWeatherFragment currentWeatherFragment){
        if(sForecastModule == null){
            sForecastModule = new ForecastModule();
        }

        sForecastModule.setCurrentWeatherView(currentWeatherFragment);
    }

}
