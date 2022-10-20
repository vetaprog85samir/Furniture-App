package com.artfurniture.furniture.ui.views.fragments.details.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesDataModel;
import com.artfurniture.furniture.databinding.FragmentCategoryDetailsBinding;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;
import com.artfurniture.furniture.ui.views.fragments.home.ShoppingFragment;
import com.artfurniture.furniture.utils.HelperMethod;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class CategoryDetailsFragment extends Fragment{

    private FragmentCategoryDetailsBinding binding;

    public CategoriesDataModel categoriesDataModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_details,
                container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.GONE);

        getActivity().findViewById(R.id.activity_home_bottom_nav_bar).setVisibility(View.GONE);

        binding.fragmentCategoryDetailsTv.setText(categoriesDataModel.getCategoryName());

        binding.fragmentCategoryDetailsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new CategoriesFragment(),
                        getActivity().getSupportFragmentManager(),
                        R.id.nav_host_fragment);
            }
        });

        return binding.getRoot();
    }

}
