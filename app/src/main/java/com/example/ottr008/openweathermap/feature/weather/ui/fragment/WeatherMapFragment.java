package com.example.ottr008.openweathermap.feature.weather.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.base.BaseFragment;
import com.example.ottr008.openweathermap.feature.weather.ui.adaptor.PageAdapter;
import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.WeatherMapContract;

/**
 * Created by Vibitha on 7/3/17.
 */

public class WeatherMapFragment extends BaseFragment implements WeatherMapContract.View {

    private WeatherMapContract.Presenter weatherMapPresenter;

    @Override
    protected final int getLayoutResource() {
        return R.layout.fragment_weathermap;
    }

    @Override
    protected final void configView() {
        final ViewPager viewPager = getResId(R.id.viewpager);
        TabLayout tabLayout = getResId(R.id.tabid);
        weatherMapPresenter.setTabText(tabLayout);
        final PageAdapter adapter = new PageAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public static WeatherMapFragment newInstance() {
        return new WeatherMapFragment();
    }

    public final void setPresenter(WeatherMapContract.Presenter currentWeatherPresenter) {

        weatherMapPresenter = currentWeatherPresenter;
    }
}
