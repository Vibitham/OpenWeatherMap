package com.example.ottr008.openweathermap.feature.weather.presenter.contracts;


import com.example.ottr008.openweathermap.base.presenter.BasePresenter;
import com.example.api.api.model.response.forecast.ForcastList;
import com.example.ottr008.openweathermap.base.presenter.BaseView;

public interface ForecastTabContract {

    interface View extends BaseView<Presenter> {

        void viewUpdate(java.util.List<ForcastList> datas);

        void updateCount(int cnt,String restoredUnitsText,String restoredForecastText);
    }

    interface Presenter extends BasePresenter {

        void forcastWeatherApi(Double latitude, Double longitude, int cnt, String appID,
                String metric);

        void getData();
    }
}
