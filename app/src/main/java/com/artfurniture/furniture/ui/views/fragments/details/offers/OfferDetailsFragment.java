package com.artfurniture.furniture.ui.views.fragments.details.offers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersDataModel;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;
import com.artfurniture.furniture.databinding.OffersRowItemBinding;
import com.artfurniture.furniture.ui.views.fragments.details.categories.CategoriesFragment;
import com.artfurniture.furniture.ui.views.fragments.home.OrdersFragment;
import com.artfurniture.furniture.utils.HelperMethod;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class OfferDetailsFragment extends Fragment{

    private OffersRowItemBinding binding;

    public OffersDataModel offersDataModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.offers_row_item,
                container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.GONE);

        getActivity().findViewById(R.id.activity_home_bottom_nav_bar).setVisibility(View.GONE);

        binding.offersRowItemOfferNameTv.setText(offersDataModel.getExpoName());
        HelperMethod.onLoadImageFromUrl(binding.offersRowItemIv, offersDataModel.getExpoLogo(), getActivity());
        binding.offersRowItemOfferPriceTv.setText(offersDataModel.getOfferPrice());

        binding.offersRowItemProduct1NameTv.setText(offersDataModel.getProduct1Name());
        HelperMethod.onLoadImageFromUrl(binding.offersRowItemProduct1Iv, offersDataModel.getProduct1Img(), getActivity());
        binding.offersRowItemProduct1NoTv.setText(offersDataModel.getProduct1No());

        binding.offersRowItemProduct2NameTv.setText(offersDataModel.getProduct2Name());
        HelperMethod.onLoadImageFromUrl(binding.offersRowItemProduct2Iv, offersDataModel.getProduct2Img(), getActivity());
        binding.offersRowItemProduct2NoTv.setText(offersDataModel.getProduct2No());

        binding.offersRowItemProduct3NameTv.setText(offersDataModel.getProduct3Name());
        HelperMethod.onLoadImageFromUrl(binding.offersRowItemProduct3Iv, offersDataModel.getProduct3Img(), getActivity());
        binding.offersRowItemProduct3NoTv.setText(offersDataModel.getProduct3No());

        binding.offersRowItemOrderNowLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new OrdersFragment(),
                        getActivity().getSupportFragmentManager(),
                        R.id.nav_host_fragment);
            }
        });

        return binding.getRoot();
    }

}
