package com.foo.gagofarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.foo.gagofarm.databinding.ActivityDetailBinding;
import com.foo.gagofarm.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private ImageSliderAdapter mAdapter;
    private int[] images = {R.drawable.login_logo,R.drawable.login_logo_margin,R.drawable.main_icon,R.drawable.main_logo_white};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar4);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter = new ImageSliderAdapter(this);
        mAdapter.setList(images);
        binding.sliderViewPager.setOffscreenPageLimit(4);
        binding.sliderViewPager.setAdapter(mAdapter);
    }

}