package com.example.ottr008.openweathermap.feature.settings;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.base.ui.BaseActivity;
import com.example.ottr008.openweathermap.utils.ActivityUtils;

public class SettingsActivity extends BaseActivity {

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
        new SettingsPresenter(settingsFragment, this);
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
