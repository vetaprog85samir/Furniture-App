package com.artfurniture.furniture.ui.views.fragments.details.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.CategoriesRVAdapter;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesResponse;
import com.artfurniture.furniture.databinding.FragmentCategoriesBinding;
import com.artfurniture.furniture.ui.views.fragments.home.ShoppingFragment;
import com.artfurniture.furniture.utils.HelperMethod;
import com.artfurniture.furniture.utils.OnEndLess;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesFragment extends Fragment{

    private FragmentCategoriesBinding binding;

    private GridLayoutManager categoriesLayoutManager;
    private OnEndLess categoriesOnEndLess;
    private int categoriesMaxPage = 0;
    private CategoriesRVAdapter categoriesRVAdapter;
    private List<CategoriesDataModel> categoriesDataModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories,
                container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.GONE);

        getActivity().findViewById(R.id.activity_home_bottom_nav_bar).setVisibility(View.GONE);

        binding.fragmentCategoriesIv.setOnClickListener(new View.OnClickListener() {
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

        categoriesLayoutManager = new GridLayoutManager(getActivity(), 3);

        binding.fragmentCategoriesRv.setLayoutManager(categoriesLayoutManager);

        categoriesOnEndLess = new OnEndLess(categoriesLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= categoriesMaxPage) {
                    if (categoriesMaxPage != 0 && current_page != 1) {
                        categoriesOnEndLess.previous_page = current_page;
                        getCategories(current_page);
                    } else {
                        categoriesOnEndLess.current_page = categoriesOnEndLess.previous_page;
                    }
                } else {
                    categoriesOnEndLess.current_page = categoriesOnEndLess.previous_page;
                }
            }
        };
        binding.fragmentCategoriesRv.addOnScrollListener(categoriesOnEndLess);

        categoriesRVAdapter = new CategoriesRVAdapter(getActivity(), categoriesDataModels);
        binding.fragmentCategoriesRv.setAdapter(categoriesRVAdapter);

        getCategories(1);
    }

    private void getCategories(int page) {

        ApiClient.getClient2().getCategories().enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                try {
                    if (response.body().getStatus()) {
                        categoriesDataModels.clear();
                        categoriesDataModels.addAll(response.body().getData());
                        categoriesRVAdapter.notifyDataSetChanged();
                    }
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {

            }
        });

    }

}
