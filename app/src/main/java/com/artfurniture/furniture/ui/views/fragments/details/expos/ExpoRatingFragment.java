package com.artfurniture.furniture.ui.views.fragments.details.expos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;
import com.artfurniture.furniture.databinding.FragmentExpoRatingBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class ExpoRatingFragment extends Fragment{

    private FragmentExpoRatingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expo_rating,
                container, false);

        return binding.getRoot();
    }

}
