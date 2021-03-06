package com.example.ottr008.openweathermap.presenter;

import android.content.Context;
import android.util.Log;

import com.example.ottr008.openweathermap.model.weatherresponsemodel.WeatherResponse;
import com.example.ottr008.openweathermap.presenter.contracts.CurrentWeatherContract;
import com.example.ottr008.openweathermap.services.ApiClient;
import com.example.ottr008.openweathermap.services.ApiContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vibitha on 11/1/18.
 */

public class CurrentWeatherPresenter implements CurrentWeatherContract.Presenter {
    private CurrentWeatherContract.View currentWeatherContractView;
    private Context mContext;

    public CurrentWeatherPresenter(CurrentWeatherContract.View currentWeatherContract, Context ctxt) {
        this.currentWeatherContractView = currentWeatherContract;
        currentWeatherContractView.setPresenter(this);
        mContext = ctxt;
    }

    public void apiService(Double lat, Double lng, String apiid, String units) {
        ApiContract apiService = ApiClient.getLoginClient().create(ApiContract.class);
        Call<WeatherResponse> call = apiService.openWeatherResponse(lat, lng, apiid, units);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                currentWeatherContractView.setViewOnResponse(response);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("Response", "Failure" + t.getMessage());
            }
        });
    }
}
