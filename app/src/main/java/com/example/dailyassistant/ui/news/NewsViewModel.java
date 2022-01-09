package com.example.dailyassistant.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private NewsData newsData;
    public NewsViewModel() {
        newsData=new NewsData();
        mText = new MutableLiveData<>();
        mText.setValue("This is news ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}