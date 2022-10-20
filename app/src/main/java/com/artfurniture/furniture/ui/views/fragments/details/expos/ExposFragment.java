package com.artfurniture.furniture.ui.views.fragments.details.expos;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.ExposRVAdapter;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExpoDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExposPaginatedResponse;
import com.artfurniture.furniture.databinding.FragmentEmptyBinding;
import com.artfurniture.furniture.databinding.FragmentExposBinding;
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

public class ExposFragment extends Fragment{

    private FragmentExposBinding binding;

    private LinearLayoutManager linearLayoutManager;
    private ExposRVAdapter adapter;
    private List<ExpoDataModel> expoDataModels = new ArrayList<>();
    private OnEndLess onEndLess;
    private int maxPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expos,
                container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.GONE);

        getActivity().findViewById(R.id.activity_home_bottom_nav_bar).setVisibility(View.GONE);

        binding.fragmentExpoBackLl.setOnClickListener(new View.OnClickListener() {
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
        binding.fragmentExposRv.setLayoutManager(linearLayoutManager);

        onEndLess = new OnEndLess(linearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= maxPage) {
                    if (maxPage != 0 && current_page != 1) {
                        onEndLess.previous_page = onEndLess.current_page;
                        getExpos(current_page);
                    }else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                }else {
                    onEndLess.current_page = onEndLess.previous_page;
                }

            }
        };
        binding.fragmentExposRv.addOnScrollListener(onEndLess);

        adapter = new ExposRVAdapter(getActivity());
        adapter.setDataList(expoDataModels);
        binding.fragmentExposRv.setAdapter(adapter);

        getExpos(1);
    }

    private void getExpos(int page){

        ApiClient.getClient2().getExpos(page).enqueue(new Callback<ExposPaginatedResponse>() {
            @Override
            public void onResponse(Call<ExposPaginatedResponse> call, Response<ExposPaginatedResponse> response) {
                try {
                    if (response.body().getStatus()) {
                        maxPage = response.body().getData().getLastPage();
                        expoDataModels.addAll(response.body().getData().getData());
                        adapter.notifyDataSetChanged();
                    }
                }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<ExposPaginatedResponse> call, Throwable t) {

            }
        });

    }

}
