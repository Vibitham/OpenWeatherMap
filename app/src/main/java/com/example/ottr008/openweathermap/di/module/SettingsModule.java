package com.example.ottr008.openweathermap.di.module;

import android.content.Context;

import com.example.ottr008.openweathermap.presenter.SettingsPresenter;
import com.example.ottr008.openweathermap.presenter.contracts.SettingsContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vibitha on 17/1/18.
 */
@Module
public class SettingsModule {
    private SettingsContract.View settingsView;
    private Context context;

    public SettingsModule() {

    }

    public void setSettingsView(SettingsContract.View settingsView){
        this.settingsView = settingsView;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Provides
    SettingsContract.View getSettingsView(){
        return settingsView;
    }

    @Provides
    Context getContext(){
        return context;
    }

    @Provides
    SettingsContract.Presenter getForecastPresenter(){
        return new SettingsPresenter(getSettingsView(),getContext());
    }
}
