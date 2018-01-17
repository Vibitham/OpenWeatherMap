package com.example.ottr008.openweathermap.ui.activity;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.di.component.DaggerSettingsComponent;
import com.example.ottr008.openweathermap.di.component.SettingsComponent;
import com.example.ottr008.openweathermap.di.module.SettingsModule;
import com.example.ottr008.openweathermap.presenter.ForecastTabPresenter;
import com.example.ottr008.openweathermap.presenter.SettingsPresenter;
import com.example.ottr008.openweathermap.ui.fragment.SettingsFragment;
import com.example.ottr008.openweathermap.utils.ActivityUtils;

import javax.inject.Inject;

public class SettingsActivity extends BaseActivity {

    @Inject
    SettingsPresenter mSettingsPresenter;

    @Override
    protected final int getResourceLayout() {
        return R.layout.activity_base;
    }

    @Override
    protected final void buildConfig() {
        getSupportActionBar().hide();
        setToolbatTitle("Settings");
        init();
    }

    private void init() {

        initPresenter(initView());
    }

    /**
     * This method will initilaize presenter
     *
     * @param settingsFragment SettingsFragment
     */
    private void initPresenter(SettingsFragment settingsFragment) {
        SettingsModule settingsModule = new SettingsModule();

        settingsModule.setSettingsView(settingsFragment);
        settingsModule.setContext(this);
        SettingsComponent settingsComponent = DaggerSettingsComponent
                .builder()
                .settingsModule(settingsModule)
                .build();
        settingsComponent.inject(this);
       // new SettingsPresenter(settingsFragment, this);
    }

    /**
     * This method will initilaize view
     *
     * @return settingsFragment SettingsFragment
     */
    private SettingsFragment initView() {

        SettingsFragment settingsFragment = (SettingsFragment) getSupportFragmentManager().findFragmentById(R.id.baseContainer);
        if (settingsFragment == null) {
            settingsFragment = SettingsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), settingsFragment, R.id.baseContainer);
        }
        return settingsFragment;
    }

}
