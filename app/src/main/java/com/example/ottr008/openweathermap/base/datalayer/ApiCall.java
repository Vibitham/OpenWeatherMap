package com.example.ottr008.openweathermap.base.datalayer;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface ApiCall<T> extends Callback<T> {

    void setCallback(ApiExecutor.ApiCallback<T> callback);

    void execute(Call<T> call);

    interface ApiCallback<Q>{
        void onResponse(Response<Q> response);
        void onFailure(Throwable t);
    }
}
