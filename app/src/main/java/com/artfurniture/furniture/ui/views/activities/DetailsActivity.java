package com.artfurniture.furniture.ui.views.activities;

import android.os.Bundle;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.ActivityDetailsBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

//        setContentView(R.layout.activity_details);


    }
}