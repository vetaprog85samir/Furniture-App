package com.artfurniture.furniture.ui.views.fragments.details.discounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class DiscountDetailsFragment extends Fragment{

    FragmentEmptyBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_empty,
                container, false);

        return binding.getRoot();
    }

}
