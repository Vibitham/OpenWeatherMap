package com.example.ottr008.openweathermap.datalayer.api;

import com.example.ottr008.openweathermap.datalayer.api.model.response.forecast.ForecastData;
import com.example.ottr008.openweathermap.datalayer.api.model.response.weather.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vibitha on 8/3/17.
 */

public interface ApiContract {

    @GET("weather")
    Call<WeatherResponse> openWeatherResponse(@Query("lat") Double lattitude ,@Query("lon") Double longitude,@Query("APPID") String appID,@Query("units") String unit);

    @GET("forecast/daily")
    Call<ForecastData> forecastWeatherResponse(@Query("lat") Double lattitude , @Query("lon") Double longitude,@Query("cnt") int cnt, @Query("APPID") String appID,@Query("units") String unit);

}
