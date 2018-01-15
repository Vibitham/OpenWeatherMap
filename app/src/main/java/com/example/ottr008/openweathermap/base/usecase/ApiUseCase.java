package com.example.ottr008.openweathermap.base.usecase;

import com.example.ottr008.openweathermap.base.datalayer.ApiCall;
import com.example.ottr008.openweathermap.base.datalayer.ApiExecutor;

import retrofit2.Call;


public abstract class ApiUseCase<P, T> implements BaseUseCase, ApiCall.ApiCallback<P> {

    private ApiRequest mApiRequest;
    private UseCaseCallback<T> mUseCaseCallback;

    public ApiRequest getApiRequest() {
        return mApiRequest;
    }

    public void setApiRequest(ApiRequest apiRequest) {
        this.mApiRequest = apiRequest;
    }

    public UseCaseCallback<T> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<T> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    protected void callApi(Call<P> call) {
        ApiCall<P> apiCall = new ApiExecutor<>();
        apiCall.setCallback(this);
        apiCall.execute(call);
    }


    public interface ApiRequest {

    }

    public interface UseCaseCallback<R> {

        void onSuccess(R response);

        void onError(Throwable t);
    }
}
