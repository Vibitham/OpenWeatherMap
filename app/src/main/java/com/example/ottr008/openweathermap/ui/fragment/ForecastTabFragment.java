package com.example.ottr008.openweathermap.ui.fragment;


import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.di.component.DaggerForecastAdapterComponent;
import com.example.ottr008.openweathermap.di.component.ForecastAdapterComponent;
import com.example.ottr008.openweathermap.di.module.ForecastAdapterModule;
import com.example.ottr008.openweathermap.presenter.contracts.ForecastTabContract;
import com.example.ottr008.openweathermap.ui.activity.WeatherMapActivity;
import com.example.ottr008.openweathermap.ui.adapter.CustomAdapter;

import java.util.List;

import javax.inject.Inject;

public class ForecastTabFragment extends BaseFragment implements ForecastTabContract.View {

    private static  final Double LATITUDE = 10.2632;
    private static final Double LONGITUDE = 76.3493;
    private String appID = "60b2d06d250e18d590998f59dac35d99";
    public static final int CNT = 7;
    private int count;
    public static final int COUNT = 16;
    @Inject
    CustomAdapter dataAdapter;
    private RecyclerView recyclerView;
    private ForecastTabContract.Presenter currentWeatherPresenter;
    private ProgressDialog loading;
    private String restoredUnitsText;
    private String restoredForecastText;

    @Override
    protected final int getLayoutResource() {
        return R.layout.fragment_forecast_tab;
    }

    @Override
    protected final void configView() {
        recyclerView = getResId(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        loading = ProgressDialog.show(getActivity(), "Fetching Data", "Please wait...", false, false);
        currentWeatherPresenter.forcastWeatherApi(LATITUDE, LONGITUDE,CNT, appID,"metric");
    }

    @Override
    public final void onResume() {
        super.onResume();
        currentWeatherPresenter.getData();
        if (restoredUnitsText != null && restoredForecastText!=null) {
            currentWeatherPresenter.forcastWeatherApi(LATITUDE, LONGITUDE,count, appID,restoredUnitsText);
        }
    }

    public static ForecastTabFragment newInstance(WeatherMapActivity weatherMapActivity) {
       /* TabFragmentModule tabFragmentModule = new TabFragmentModule();

        TabFragmentComponent tabFragmentComponent = DaggerTabFragmentModule
                .builder()
                .tabFragmentModule(tabFragmentModule)
                .build();
        tabFragmentComponent.inject(weatherMapActivity);*/
        return new ForecastTabFragment();
    }

    @Override
    public void setPresenter(ForecastTabContract.Presenter currentWeatherPresenter) {
        this.currentWeatherPresenter = currentWeatherPresenter;
    }

    @Override
    public void viewUpdate(List<com.example.ottr008.openweathermap.model.forecastresponsemodel.List> datas) {
        loading.dismiss();
        ForecastAdapterModule forecastAdapterModule = new ForecastAdapterModule();

        forecastAdapterModule.setAdapterList(datas);
        ForecastAdapterComponent mForecastAdapterComponent = DaggerForecastAdapterComponent
                .builder()
                .forecastAdapterModule(forecastAdapterModule)
                .build();
        mForecastAdapterComponent.inject(this);
        //dataAdapter = new CustomAdapter(datas);
        recyclerView.setAdapter(dataAdapter);
    }

    @Override
    public void updateCount(int cnt, String restoredUnitsText, String restoredForecastText) {
        count = cnt;
        this.restoredUnitsText = restoredUnitsText;
        this.restoredForecastText = restoredForecastText;
    }
}
