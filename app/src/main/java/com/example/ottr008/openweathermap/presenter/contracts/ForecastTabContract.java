package com.example.ottr008.openweathermap.presenter.contracts;


import com.example.ottr008.openweathermap.model.forecastresponsemodel.List;
import com.example.ottr008.openweathermap.presenter.BaseView;

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
