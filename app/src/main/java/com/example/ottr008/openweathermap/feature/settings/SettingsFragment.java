package com.example.ottr008.openweathermap.feature.settings;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.base.ui.BaseFragment;

/**
 * Created by Vibitha on 8/3/17.
 */

public class SettingsFragment extends BaseFragment implements SettingsContract.View {

    private SettingsContract.Presenter presenter;
    private Spinner unitsSpinner, forecastSpinner;
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    protected final int getLayoutResource() {
        return R.layout.fragment_settings;
    }

    @Override
    protected final void configView() {
        initView();
        presenter.addItemsToUnitsSpinner();
        presenter.addItemsToForecastSpinner();

        SharedPreferences prefs = getActivity(). getPreferences(0);
        unitsSpinner.setSelection(prefs.getInt("unitsSpinnerSelection",0));
        forecastSpinner.setSelection(prefs.getInt("forecastSpinnerSelection",0));
        unitsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedUnit = unitsSpinner.getSelectedItem().toString();
                presenter.unitSavedToPreference(selectedUnit);

                SharedPreferences.Editor editor = getActivity().getPreferences(0).edit();
                int selectedPosition = unitsSpinner.getSelectedItemPosition();
                editor.putInt("unitsSpinnerSelection", selectedPosition);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        forecastSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedForecast = forecastSpinner.getSelectedItem().toString();
                presenter.forecastSavedToPreference(selectedForecast);

                SharedPreferences.Editor editor = getActivity().getPreferences(0).edit();
                int selectedPosition = forecastSpinner.getSelectedItemPosition();
                editor.putInt("forecastSpinnerSelection", selectedPosition);
                editor.apply();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initView() {
        unitsSpinner = getResId(R.id.unitspinner);
        forecastSpinner = getResId(R.id.forecastSpinner);
    }

    public final void setPresenter(SettingsContract.Presenter currentWeatherPresenter) {
        this.presenter = currentWeatherPresenter;
    }

    @Override
    public final void setUnitSpinnerAdapter(ArrayAdapter<String> adapter) {
        unitsSpinner.setAdapter(adapter);
    }

    @Override
    public final void setForecastSpinnerAdapter(ArrayAdapter<String> adapter) {
        forecastSpinner.setAdapter(adapter);
    }
}
