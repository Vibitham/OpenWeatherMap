package com.example.ottr008.openweathermap.feature.weather.presenter.contracts;


import com.example.ottr008.openweathermap.services.model.forecastresponsemodel.List;
import com.example.ottr008.openweathermap.base.BaseView;

public interface ForecastTabContract {

    interface View extends BaseView<Presenter> {

        void viewUpdate(java.util.List<List> datas);

        void updateCount(int cnt,String restoredUnitsText,String restoredForecastText);
    }

    interface Presenter{

        void forcastWeatherApi(Double latitude, Double longitude, int cnt, String appID,
                String metric);

        void getData();
    }
}
