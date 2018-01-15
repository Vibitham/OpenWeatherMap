package com.example.ottr008.openweathermap.base.datalayer;


import retrofit2.Call;
import retrofit2.Response;

public class  ApiExecutor<T> implements ApiCall<T>{

    private ApiCallback<T> mCallback;

    @Override
    public void setCallback(ApiCallback<T> callback) {
        this.mCallback = callback;
    }

    @Override
    public void execute(Call<T> call) {
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        mCallback.onResponse(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        mCallback.onFailure(t);
    }
}
