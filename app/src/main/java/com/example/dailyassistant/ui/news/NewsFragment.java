package com.example.dailyassistant.ui.news;

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
import com.example.dailyassistant.databinding.FragmentNewsBinding;


public class NewsFragment extends Fragment {
    private NewsViewModel newsViewModel;
    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NewsData newsData = new NewsData();
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setNewsData(newsData);
        Button button = root.findViewById(R.id.refresh_news);
        button.setOnClickListener(
                view -> {
                    NewsData newNewsData = new NewsData();
                    setNewsData(newNewsData);
                }
        );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setNewsData(NewsData newsData) {
        TextView title = binding.titleNews;
        TextView description = binding.descriptionNews;
        TextView url = binding.urlNews;
        ImageView imageView = binding.imageNews;
        title.setText(newsData.getTitle());
        description.setText(newsData.getDescription());
        url.setText(newsData.getNewsURL());
        imageView.setImageDrawable(newsData.getImage());
    }
}