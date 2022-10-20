package com.artfurniture.furniture.ui.views.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.ActivityHomeBinding;
import com.artfurniture.furniture.databinding.FragmentHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

//import android.app.Fragment;
public class HomeFragment extends Fragment{


    private FragmentHomeBinding binding;

    private BottomNavigationView bottomNavigationView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.VISIBLE);

        bottomNavigationView = getActivity().findViewById(R.id.activity_home_bottom_nav_bar);

        setBottomNav(bottomNavigationView);

        return binding.getRoot();


    }

    private void setBottomNav(BottomNavigationView bottomNavigationView){

        bottomNavigationView.setVisibility(View.VISIBLE);

        Menu menu = bottomNavigationView.getMenu();

        menu.findItem(R.id.nav_home).setChecked(true);
    }


}
