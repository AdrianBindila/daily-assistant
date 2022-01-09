package com.example.dailyassistant.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailyassistant.databinding.FragmentWeatherBinding;

public class WeatherFragment extends Fragment {
    private WeatherViewModel weatherViewModel;
    private FragmentWeatherBinding binding;
    private WeatherData weatherData;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        weatherData = new WeatherData();
        System.out.println(weatherData.getDescription());
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textWeather;
        weatherViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (s!=null)
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void refreshData(View view){

    }
}