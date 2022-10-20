package com.artfurniture.furniture.ui.views.fragments.details.offers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.OffersRVAdapter;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersPaginatedResponse;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;
import com.artfurniture.furniture.databinding.FragmentOffersBinding;
import com.artfurniture.furniture.ui.views.fragments.home.ShoppingFragment;
import com.artfurniture.furniture.utils.HelperMethod;
import com.artfurniture.furniture.utils.OnEndLess;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffersFragment extends Fragment{

    private FragmentOffersBinding binding;

    private LinearLayoutManager linearLayoutManager;
    private OnEndLess offersOnEndless;
    private int offersMaxPage = 0;
    private OffersRVAdapter offersRVAdapter;
    private List<OffersDataModel> offersDataModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_offers,
                container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.GONE);

        getActivity().findViewById(R.id.activity_home_bottom_nav_bar).setVisibility(View.GONE);

        binding.fragmentOffersIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new ShoppingFragment(),
                        getActivity().getSupportFragmentManager(),
                        R.id.nav_host_fragment);
            }
        });

        init();

        return binding.getRoot();
    }

    private void init(){

        linearLayoutManager = new LinearLayoutManager(getActivity());

        binding.fragmentOffersRv.setLayoutManager(linearLayoutManager);

        offersOnEndless = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= offersMaxPage) {
                    if (offersMaxPage != 0 && current_page != 1) {
                        offersOnEndless.previous_page = offersOnEndless.current_page;
                        getOffers(current_page);
                    } else {
                        offersOnEndless.current_page = offersOnEndless.previous_page;
                    }
                } else {
                    offersOnEndless.current_page = offersOnEndless.previous_page;
                }
            }
        };
        binding.fragmentOffersRv.addOnScrollListener(offersOnEndless);

        offersRVAdapter = new OffersRVAdapter(getActivity());
        offersRVAdapter.setOffersDataList(offersDataModels);
        binding.fragmentOffersRv.setAdapter(offersRVAdapter);

        getOffers(1);


    }

    private void getOffers(int page){

//        HelperMethod.showProgressDialog(getActivity(), getString(R.string.waiting));
        binding.progressBar.setVisibility(View.VISIBLE);

        ApiClient.getClient2().getOffers(page).enqueue(new Callback<OffersPaginatedResponse>() {
            @Override
            public void onResponse(Call<OffersPaginatedResponse> call, Response<OffersPaginatedResponse> response) {
//                HelperMethod.dismissProgressDialog();
                binding.progressBar.setVisibility(View.GONE);
//                offersDataModels.clear();
                try {
                    if (response.body().getStatus()){
                        offersMaxPage = response.body().getData().getLastPage();
                        offersDataModels.addAll(response.body().getData().getData());
                        offersRVAdapter.notifyDataSetChanged();
                    }

                }catch (Exception e){}

            }

            @Override
            public void onFailure(Call<OffersPaginatedResponse> call, Throwable t) {
                HelperMethod.dismissProgressDialog();
            }
        });

    }

}
