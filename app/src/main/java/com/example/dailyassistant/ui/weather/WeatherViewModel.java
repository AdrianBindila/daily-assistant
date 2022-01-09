package com.example.dailyassistant.ui.weather;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ImageView> mWeatherImage;
    private WeatherData weatherData;

    public WeatherViewModel() {
        weatherData = new WeatherData();
        mText.setValue(weatherData.getDescription());
        mText = new MutableLiveData<>();
        mWeatherImage = new MutableLiveData<>();

//        mWeatherImage.setValue(mWeatherImage.getValue());
    }


    public LiveData<String> getText() {

        return mText;
    }

//    public LiveData<ImageView> getImage() {
//        return mWeatherImage;
//    }
}