package com.artfurniture.furniture.ui.views.fragments.details.expos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.adapters.viewPager.ViewPagerWithFragmentAdapter;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExpoDataModel;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;
import com.artfurniture.furniture.databinding.FragmentExpoDetailsBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class ExpoDetailsFragment extends Fragment{

    private FragmentExpoDetailsBinding binding;

    private ViewPagerWithFragmentAdapter vPAdapter;

    public ExpoDataModel expoDataModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expo_details,
                container, false);

        vPAdapter = new ViewPagerWithFragmentAdapter(getChildFragmentManager());

        initViewPager(vPAdapter);

        binding.expoTabs.setupWithViewPager(binding.expoViewPager);

        return binding.getRoot();
    }

    private void initViewPager(ViewPagerWithFragmentAdapter vPAdapter){
        vPAdapter = new ViewPagerWithFragmentAdapter(getChildFragmentManager());
        vPAdapter.addPager(new ExpoInfoFragment(), "معلومات عن المعرض");
        vPAdapter.addPager(new ExpoInfoFragment(), "تقييم المعرض");
        vPAdapter.addPager(new ExpoInfoFragment(), "صفحة المعرض");

        binding.expoViewPager.setAdapter(vPAdapter);

    }

}
