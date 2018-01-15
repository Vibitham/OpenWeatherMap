package com.example.ottr008.openweathermap.feature.weather.presenter.contracts;

import com.example.ottr008.openweathermap.services.model.weatherresponsemodel.WeatherResponse;
import com.example.ottr008.openweathermap.base.BaseView;

import retrofit2.Response;

/**
 * Created by vibitha on 11/1/18.
 */

public interface CurrentWeatherContract {

    interface  View extends BaseView<Presenter>{

        void setViewOnResponse(Response<WeatherResponse> response);
    }
    
    interface Presenter{
        void apiService(Double lat, Double lng, String apiid, String units);
    }
}
