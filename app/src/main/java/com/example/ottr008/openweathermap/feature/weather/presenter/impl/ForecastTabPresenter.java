package com.example.ottr008.openweathermap.feature.weather.presenter.impl;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.ottr008.openweathermap.datalayer.api.model.response.forecast.ForecastData;
import com.example.ottr008.openweathermap.datalayer.api.model.response.forecast.ForcastList;
import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.ForecastTabContract;
import com.example.ottr008.openweathermap.datalayer.api.ApiClient;
import com.example.ottr008.openweathermap.datalayer.api.ApiContract;
import com.example.ottr008.openweathermap.datalayer.api.ServiceConstants;
import com.example.ottr008.openweathermap.feature.weather.ui.fragment.ForecastTabFragment;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vibitha on 9/1/18.
 */

public class ForecastTabPresenter implements ForecastTabContract.Presenter{

    private ForecastTabContract.View view;


    @Inject
    public ForecastTabPresenter(ForecastTabContract.View forecastTabContract) {
        view = forecastTabContract;
        view.setPresenter(this);

    }

    @Override
    public void forcastWeatherApi(Double latitude, Double longitude, int cnt, String appID,
            String metric) {
        ApiContract apiService = ApiClient.getLoginClient().create(ApiContract.class);
        Call<ForecastData> call = apiService.forecastWeatherResponse(latitude, longitude,cnt, appID,"metric");
        call.enqueue(new Callback<ForecastData>() {
            @Override
            public void onResponse(Call<ForecastData> call, Response<ForecastData> response) {
                java.util.List<ForcastList> datas = response.body().getForcastList();
                view.viewUpdate(datas);

            }

            @Override
            public void onFailure(Call<ForecastData> call, Throwable t) {
                Log.d("Response", "Failure" + t.getMessage());
            }
        });
    }

    @Override
    public void getData() {
        SharedPreferences unitsprefs = view.getSharedPref(ServiceConstants.UNITS_PREF_NAME, MODE_PRIVATE);
        String restoredUnitsText = unitsprefs.getString("Units", null);
        SharedPreferences forecastprefs =  view.getSharedPref(ServiceConstants.FORECAST_PREF_NAME, MODE_PRIVATE);
        String restoredForecastText = forecastprefs.getString("Forecast", null);
        if(forecastprefs.getString("Forecast", null) == "Short(7 Days)" ){
            view.updateCount(ForecastTabFragment.CNT,restoredUnitsText,restoredForecastText);
        }
        else
        {
            view.updateCount(ForecastTabFragment.COUNT,restoredUnitsText,restoredForecastText);
        }
    }
}
