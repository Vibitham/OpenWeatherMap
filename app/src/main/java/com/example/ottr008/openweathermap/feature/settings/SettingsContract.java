package com.example.ottr008.openweathermap.feature.settings;

import android.widget.ArrayAdapter;

import com.example.ottr008.openweathermap.base.presenter.BasePresenter;
import com.example.ottr008.openweathermap.base.presenter.BaseView;

/**
 * Created by Vibitha on 8/3/17.
 */

public interface SettingsContract {

    interface  View extends BaseView<Presenter>
    {

        void setUnitSpinnerAdapter(ArrayAdapter<String> adapter);

        void setForecastSpinnerAdapter(ArrayAdapter<String> adapter);
    }

    interface Presenter extends BasePresenter
    {

        void addItemsToUnitsSpinner();

        void addItemsToForecastSpinner();

        void unitSavedToPreference(String selectedUnit);

        void forecastSavedToPreference(String selectedForecast);
    }
}
