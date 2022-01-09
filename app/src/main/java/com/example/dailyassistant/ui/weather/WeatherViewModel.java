package com.example.dailyassistant.ui.weather;

import android.widget.Button;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<ImageView> mWeatherImage;
    private MutableLiveData<String> mDescription;
    private MutableLiveData<String> mTemp;
    private Button mButton;

    public WeatherViewModel() {
        mDescription = new MutableLiveData<>();
        mWeatherImage = new MutableLiveData<>();
        mTemp = new MutableLiveData<>();
    }

}