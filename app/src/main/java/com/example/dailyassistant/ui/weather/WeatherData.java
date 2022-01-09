package com.example.dailyassistant.ui.weather;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class WeatherData{
    private final String GETURL = "https://api.openweathermap.org/data/2.5/weather?q=cluj-napoca&appid=aed4a9b0e84a0c3c39403279cbd4441e";
    private Drawable weatherImage;
    private String description;
    private Integer temperature;
    private OkHttpClient client = new OkHttpClient();

    public WeatherData(){
        Request request = new Request.Builder().url(GETURL).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

                         @Override
                         public void onFailure(Call call, IOException e) {
                             System.out.println("failed call enqueue");
                             e.printStackTrace();
                         }

                         @Override
                         public void onResponse(Call call, Response response) throws IOException {
                             try {
                                 JSONObject reader = new JSONObject(response.body().string());
                                 JSONObject weather = reader.getJSONArray("weather").getJSONObject(0);
                                 String imgCode = weather.getString("icon");
                                 String imgURL = "https://openweathermap.org/img/wn/" + imgCode + "@2x.png";

                                 Drawable tempWeatherImage = loadImage(imgURL);
                                 String tempDescription = weather.getString("description");
                                 int tempTemperature = reader.getJSONObject("main").getInt("temp") - 273;
                                 setData(tempWeatherImage, tempDescription, tempTemperature);

                             } catch (JSONException e) {
                                 e.printStackTrace();
                             }
                         }
                     }
        );
    }

    private void setData(Drawable weatherImage, String description, Integer temperature) {
        this.weatherImage = weatherImage;
        this.description = description;
        this.temperature = temperature;
    }

    private Drawable loadImage(String url) {
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            return Drawable.createFromStream(inputStream, "weather-img");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Drawable getWeatherImage() {
        return weatherImage;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void print(){
        System.out.println("===============");
        System.out.println(this.description);
        System.out.println(this.temperature);
    }
}
