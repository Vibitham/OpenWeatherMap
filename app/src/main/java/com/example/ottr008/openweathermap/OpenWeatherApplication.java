package com.example.ottr008.openweathermap;

import android.app.Application;

/**
 * Created by vibitha on 11/1/18.
 */

public class OpenWeatherApplication extends Application {
    private static Application application;


    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
    }

    public static void setApplication(Application application) {
        OpenWeatherApplication.application = application;
    }
}
