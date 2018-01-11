package com.example.ottr008.openweathermap.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import com.example.ottr008.openweathermap.presenter.contracts.SettingsContract;
import com.example.ottr008.openweathermap.services.ServiceConstants;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Vibitha on 8/3/17.
 */

public class SettingsPresenter implements SettingsContract.Presenter {
    private Context context;
    private SettingsContract.View view;

    public SettingsPresenter(SettingsContract.View settingsView, Context ctxt) {
        view = settingsView;
        view.setPresenter(this);
        context = ctxt;
    }
    @Override
    public final void addItemsToUnitsSpinner() {
        List<String> list = new ArrayList<String>();
        list.add("Metric");
        list.add("Imperial");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        view.setUnitSpinnerAdapter(adapter);
    }

    @Override
    public final void addItemsToForecastSpinner() {
        List<String> list = new ArrayList<String>();
        list.add("Short(7 Days)");
        list.add("Extended(16 Days)");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        view.setForecastSpinnerAdapter(adapter);
    }

    @Override
    public final void unitSavedToPreference(String selectedUnit) {
        SharedPreferences prefs = context.getSharedPreferences(ServiceConstants.UNITS_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor unitsPreference = prefs.edit();
        unitsPreference.putString("Units", selectedUnit);
        unitsPreference.commit();

    }

    @Override
    public final void forecastSavedToPreference(String selectedForecast) {
        SharedPreferences.Editor forecastPreference = context.getSharedPreferences(ServiceConstants.FORECAST_PREF_NAME, MODE_PRIVATE).edit();
        forecastPreference.putString("Forecast", selectedForecast);
        forecastPreference.commit();

    }
}
