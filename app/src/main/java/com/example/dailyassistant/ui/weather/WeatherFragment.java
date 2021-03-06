package com.example.dailyassistant.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailyassistant.R;
import com.example.dailyassistant.databinding.FragmentWeatherBinding;
import com.example.dailyassistant.ui.news.NewsData;

public class WeatherFragment extends Fragment {
    private WeatherViewModel weatherViewModel;
    private FragmentWeatherBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WeatherData weatherData = new WeatherData();
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setWeatherData(weatherData);
        Button button = root.findViewById(R.id.refresh_weather);
        button.setOnClickListener(
                view -> {
                    WeatherData newWeatherData = new WeatherData();
                    setWeatherData(newWeatherData);
                }
        );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setWeatherData(WeatherData weatherData){
        TextView textView = binding.textWeather;
        ImageView imageView = binding.imageWeather;
        TextView temp = binding.textTemp;
        textView.setText(weatherData.getDescription());
        imageView.setImageDrawable(weatherData.getWeatherImage());
        temp.setText(String.format("%d",weatherData.getTemperature())+" °C");
    }
}