package com.example.ottr008.openweathermap.feature.weather.ui.fragment;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ottr008.openweathermap.R;
import com.example.ottr008.openweathermap.base.ui.BaseFragment;
import com.example.api.api.model.response.weather.WeatherResponse;
import com.example.ottr008.openweathermap.feature.weather.presenter.contracts.CurrentWeatherContract;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Response;

public class CurrentWeatherFragment extends BaseFragment implements LocationListener ,CurrentWeatherContract.View{

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final long MIN_TIME =0 ;
    private static final float MIN_DISTANCE = 0f;
    private static final int REQUEST_LOCATION = 0;
    private Double latitude  ;
    private Double longitude ;
    private static final int TO_SECONDS = 1000;
    private String appID = "60b2d06d250e18d590998f59dac35d99";
    private String unit = "metric";
    private TextView currentPlace, temperature, humidity, pressure, lowTemperature, highTemperature, currentTime, weatherDescription;
    private ImageView weatherImage;
    private String separator = ", ";
    private GoogleApiClient mGoogleApiClient;
    private CurrentWeatherContract.Presenter currentWeatherPresenter;

    @Override
    protected final int getLayoutResource() {
        return R.layout.fragment_current_weather;
    }

    @Override
    protected final void configView() {

        initView();

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {

            @Override
            public void onPlaceSelected(Place place) {
                Double latitude = place.getLatLng().latitude;
                Double longitude = place.getLatLng().longitude;
                currentWeatherPresenter.apiService(latitude, longitude, appID, unit);

            }

            @Override
            public void onError(Status status) {
                Log.i("An error occurred: ", status.toString());
            }
        });

    }



    public void setViewOnResponse(Response<WeatherResponse> response) {
        setView(response.body().getName().toString(), response.body().getMain().getTemp().toString(), response.body().getMain().getHumidity().toString(),
                response.body().getMain().getPressure().toString(), response.body().getMain().getTempMin().toString(), response.body().getMain().getTempMax().
                        toString(), response.body().getDt().longValue(), response.body().getWeather().get(0).getDescription().toString());

        switch (response.body().getWeather().get(0).getDescription()) {
            case "light rain":
                weatherImage.setImageResource(R.drawable.lightrain);
                break;

            case "moderate rain":
                weatherImage.setImageResource(R.drawable.moderate_rain);
                break;

            case "heavy intensity rain":
                weatherImage.setImageResource(R.drawable.heavyrain);
                break;

            case "sky is clear":
                weatherImage.setImageResource(R.drawable.sunnycloud);
                break;

            default:
                weatherImage.setImageResource(R.drawable.sunnycloud);
                break;
        }
    }

    @Override
    public final void onResume() {
        super.onResume();
       updateLocation();
    }

    public final void initView() {
        currentPlace = getResId(R.id.currentplace);
        temperature = getResId(R.id.temperature);
        humidity = getResId(R.id.humidity);
        pressure = getResId(R.id.pressure);
        lowTemperature = getResId(R.id.lowtemperature);
        highTemperature = getResId(R.id.hightemperature);
        currentTime = getResId(R.id.currentTime);
        weatherImage = getResId(R.id.weatherimage);
        weatherDescription = getResId(R.id.weatherDescription);
    }


    public final void setView(String cityName, String temp, String humidity, String pressure, String lowTemp, String highTemp, Long datetime, String description) {

        this.humidity.setText("Humidity: " + humidity + " %");
        this.pressure.setText("Pressure: " + pressure + "  " + "mmHg");
        lowTemperature.setText(lowTemp + " ");
        highTemperature.setText(highTemp);
        currentPlace.setText(cityName);
        temperature.setText(temp);
        weatherDescription.setText(description);
        Long timesec = datetime * TO_SECONDS;
        Date date = new Date(timesec);
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                currentTime.setText("Sunday" + separator + time);
                break;

            case Calendar.MONDAY:
                currentTime.setText("Monday" + separator + time);
                break;

            case Calendar.TUESDAY:
                currentTime.setText("Tuesday" + separator + time);
                break;

            case Calendar.WEDNESDAY:
                currentTime.setText("Wednesday" + separator + time);
                break;

            case Calendar.THURSDAY:
                currentTime.setText("Thursday" + separator + time);
                break;

            case Calendar.FRIDAY:
                currentTime.setText("Friday" + separator + time);
                break;

            case Calendar.SATURDAY:
                currentTime.setText("Saturday" + separator + time);
                break;
        }
    }

    public final void onStart() {
//        mGoogleApiClient.connect();
        super.onStart();
    }

    public final void onStop() {
       // mGoogleApiClient.disconnect();
        super.onStop();
    }

    private void updateLocation() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        Location location = null;
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if ( locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
            }else{
                locationManager.requestLocationUpdates(android.location.LocationManager.NETWORK_PROVIDER,MIN_TIME,MIN_DISTANCE,this);
            }
            location = locationManager.getLastKnownLocation("gps");
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_LOCATION);
        }
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();

            currentWeatherPresenter.apiService(latitude, longitude, appID, unit);

        }
    }


    @Override
    public final void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        currentWeatherPresenter.apiService(latitude, longitude, appID, unit);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public static CurrentWeatherFragment newInstance() {
        return new CurrentWeatherFragment();
    }

    @Override
    public void setPresenter(CurrentWeatherContract.Presenter currentWeatherPresenter) {
        this.currentWeatherPresenter = currentWeatherPresenter;
    }
}