package com.example.ottr008.openweathermap.feature.weather.presenter.contracts;

import com.example.ottr008.openweathermap.base.presenter.BasePresenter;
import com.example.api.api.model.response.weather.WeatherResponse;
import com.example.ottr008.openweathermap.base.presenter.BaseView;

import retrofit2.Response;

/**
 * Created by vibitha on 11/1/18.
 */

public interface CurrentWeatherContract {

    interface  View extends BaseView<Presenter>{

        void setViewOnResponse(Response<WeatherResponse> response);
    }
    
    interface Presenter extends BasePresenter {
        void apiService(Double lat, Double lng, String apiid, String units);
    }
}
