package com.example.ottr008.openweathermap.presenter.contracts;

import com.example.ottr008.openweathermap.model.weatherresponsemodel.WeatherResponse;
import com.example.ottr008.openweathermap.presenter.BaseView;

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
