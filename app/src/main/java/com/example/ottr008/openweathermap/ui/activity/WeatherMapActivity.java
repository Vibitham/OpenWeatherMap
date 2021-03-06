package com.example.ottr008.openweathermap.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.di.component.DaggerForecastPresenterComponent;
import com.example.ottr008.openweathermap.di.component.ForecastPresenterComponent;
import com.example.ottr008.openweathermap.di.module.ForecastModule;
import com.example.ottr008.openweathermap.presenter.CurrentWeatherPresenter;
import com.example.ottr008.openweathermap.presenter.ForecastTabPresenter;
import com.example.ottr008.openweathermap.ui.fragment.CurrentWeatherFragment;
import com.example.ottr008.openweathermap.ui.fragment.ForecastTabFragment;
import com.example.ottr008.openweathermap.utils.ActivityUtils;

import javax.inject.Inject;

public class WeatherMapActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener{


   @Inject
   ForecastTabPresenter mForecastTabPresenter;

  /* @Inject
   CurrentWeatherPresenter mCurrentWeatherPresenter;*/

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

        initPresenter(initView());
    }

    /**
     * This method will initilaize presenter
     *
     * @param forecastTabFragment ForecastTabFragment
     */

    private void initPresenter(ForecastTabFragment forecastTabFragment) {

        //mForecastPresenterComponent.getForecastPresenter();

        ForecastModule sForecastModule = new ForecastModule();

        sForecastModule.setForecastTabFragment(forecastTabFragment);
        sForecastModule.setContext(this);
        ForecastPresenterComponent mForecastPresenterComponent = DaggerForecastPresenterComponent
                .builder()
                .forecastModule(sForecastModule)
                .build();
        mForecastPresenterComponent.inject(this);
       /* OpenWeatherApplication.setForecastView(forecastTabFragment);
        OpenWeatherApplication.setContext(this);
        OpenWeatherApplication.buildApplicationComponent();
        OpenWeatherApplication.getForecastPresenterComponent().inject(this);*/
    }

    /**
     * This method will initilaize view
     *
     * @return weatherMapFragment WeatherMapFragment
     */
    private ForecastTabFragment initView() {

        ForecastTabFragment forecastTabFragment = (ForecastTabFragment) getSupportFragmentManager().findFragmentById(R.id.baseContainer);
        if (forecastTabFragment == null) {
            forecastTabFragment = ForecastTabFragment.newInstance(this);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), forecastTabFragment, R.id.baseContainer);
        }
        return forecastTabFragment;
    }


    @Override
    public final boolean onMenuItemClick(MenuItem item) {
     switch (item.getItemId()) {

            case R.id.settings:
                Intent settingsActivity = new Intent(this,SettingsActivity.class);
                startActivityForResult(settingsActivity,1);
                return true;

         case R.id.options:
             initCurrentWeather();
        }
        return true;
    }

    private void initCurrentWeather() {
        initCurrentWeatherPresenter(initCurrentWeatherView());
    }

    private void initCurrentWeatherPresenter(CurrentWeatherFragment currentWeatherFragment) {
       /* CurrentWeatherModule currentWeatherModule = new CurrentWeatherModule();

        currentWeatherModule.setCurrentWeatherView(currentWeatherFragment);
        currentWeatherModule.setWeatherContext(this);
        CurrentWeatherComponent currentWeatherComponent = DaggerForecastPresenterComponent
                .builder()
                .currentWeatherModule(currentWeatherModule)
                .build();
        currentWeatherComponent.inject(this);*/
        /*OpenWeatherApplication.setCurrentWeatherView(currentWeatherFragment);
        OpenWeatherApplication.setWeatherContext(this);
        OpenWeatherApplication.buildWeatherComponent();
        OpenWeatherApplication.getCurrentWeatherComponent().inject(this);*/
       new CurrentWeatherPresenter(currentWeatherFragment,this);
    }

    private CurrentWeatherFragment initCurrentWeatherView() {
            CurrentWeatherFragment currentWeatherFragment = CurrentWeatherFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), currentWeatherFragment, R.id.baseContainer);

        return currentWeatherFragment;
    }

}
