package com.artfurniture.furniture.ui.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;

public class EmptyFragment extends Fragment{

    FragmentEmptyBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_empty,
                container, false);

        return binding.getRoot();
    }

}
