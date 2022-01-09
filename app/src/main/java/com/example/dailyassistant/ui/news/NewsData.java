package com.example.dailyassistant.ui.news;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

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

public class NewsData {
    private final String GETURL = "https://newsapi.org/v2/top-headlines?country=ro&apiKey=a9b246d49a0049239e8ce95bf9ad73ea";
    private OkHttpClient client = new OkHttpClient();

    private String title;
    private String description;
    private Drawable image;
    private String newsURL;

    public NewsData() {
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
                    JSONObject latestArticle = reader.getJSONArray("articles").getJSONObject(0);
                    String title = latestArticle.getString("title");
                    String description = latestArticle.getString("description");
                    String imgURL = latestArticle.getString("urlToImage");
                    Drawable image = Drawable.createFromStream((InputStream) new URL(imgURL).getContent(), "news-image");
                    String articleURL = latestArticle.getString("url");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setData(String title, String description, Drawable image, String url) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.newsURL = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getImage() {
        return image;
    }

    public String getNewsURL() {
        return newsURL;
    }
}
