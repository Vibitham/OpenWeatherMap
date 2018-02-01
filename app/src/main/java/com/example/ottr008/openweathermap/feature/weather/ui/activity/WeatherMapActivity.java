package com.example.ottr008.openweathermap.feature.weather.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.base.ui.BaseActivity;
import com.example.ottr008.openweathermap.feature.settings.SettingsActivity;
import com.example.ottr008.openweathermap.feature.weather.di.component.DaggerForecastComponent;
import com.example.ottr008.openweathermap.feature.weather.di.component.ForecastComponent;
import com.example.ottr008.openweathermap.feature.weather.di.module.ForecastModule;
import com.example.ottr008.openweathermap.feature.weather.presenter.impl.CurrentWeatherPresenter;
import com.example.ottr008.openweathermap.feature.weather.presenter.impl.ForecastTabPresenter;
import com.example.ottr008.openweathermap.feature.weather.ui.fragment.CurrentWeatherFragment;
import com.example.ottr008.openweathermap.feature.weather.ui.fragment.ForecastTabFragment;
import com.example.ottr008.openweathermap.utils.ActivityUtils;

import javax.inject.Inject;

public class WeatherMapActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener{


    ForecastTabFragment forecastTabFragment;
    CurrentWeatherFragment currentWeatherFragment;

   @Inject
   ForecastTabPresenter mForecastTabPresenter;

   @Inject
   CurrentWeatherPresenter mCurrentWeatherPresenter;

    private Toolbar toolbar;

    @Override
    protected final int getResourceLayout() {
        return R.layout.activity_base;
    }

    @Override
    protected final void buildConfig() {
        getSupportActionBar().hide();
        toolbar = getViewId(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(this);
        toolbar.setNavigationIcon(null);
        toolbar.inflateMenu(R.menu.main_menu);
        init();
        setToolbatTitle("Kochi");
    }

    private void init() {

        initPresenter();
    }



    private void initPresenter() {
        initFragments();
        initForcastComponent();

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), forecastTabFragment, R.id.baseContainer);

    }


    private void initForcastComponent() {
        ForecastModule forecastModule = new ForecastModule(forecastTabFragment,currentWeatherFragment);


        ForecastComponent mForecastComponent = DaggerForecastComponent
                .builder()
                .forecastModule(forecastModule)
                .build();
        mForecastComponent.inject(this);
    }

    private void initFragments() {
        forecastTabFragment = ForecastTabFragment.newInstance();
        currentWeatherFragment = CurrentWeatherFragment.newInstance();
    }


    @Override
    public final boolean onMenuItemClick(MenuItem item) {
     switch (item.getItemId()) {

            case R.id.settings:
                Intent settingsActivity = new Intent(this,SettingsActivity.class);
                startActivityForResult(settingsActivity,1);
                return true;

         case R.id.options:
            // new CurrentWeatherPresenter(currentWeatherFragment);
             ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), currentWeatherFragment, R.id.baseContainer);
             return true;
        }
        return false;
    }



}
