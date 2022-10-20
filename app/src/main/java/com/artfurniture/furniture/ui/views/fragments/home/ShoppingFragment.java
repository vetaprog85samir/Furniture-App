package com.artfurniture.furniture.ui.views.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
//import android.app.Fragment;
import androidx.fragment.app.Fragment;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.CategoriesRVAdapter;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.DiscountRVAdapter;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.ExposRVAdapter;
import com.artfurniture.furniture.adapters.recyclerViewAdapters.OffersRVAdapter;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.DiscountsDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.DiscountsResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExpoDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExposPaginatedResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersPaginatedResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersResponse;
import com.artfurniture.furniture.databinding.FragmentShoppingBinding;
import com.artfurniture.furniture.ui.views.fragments.details.categories.CategoriesFragment;
import com.artfurniture.furniture.ui.views.fragments.details.expos.ExposFragment;
import com.artfurniture.furniture.ui.views.fragments.details.offers.OffersFragment;
import com.artfurniture.furniture.utils.HelperMethod;
import com.artfurniture.furniture.utils.OnEndLess;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ShoppingFragment extends Fragment {

    private FragmentShoppingBinding binding;
    private LinearLayoutManager categoriesLinearLayoutManager;
    private LinearLayoutManager offersLinearLayoutManager;
    private LinearLayoutManager discountsLinearLayoutManager;
    private LinearLayoutManager exposLinearLayoutManager;
    private OnEndLess categoriesOnEndLess;
    private OnEndLess offersOnEndLess;
    private OnEndLess discountsOnEndLess;
    private OnEndLess exposOnEndLess;
    private int categoriesMaxPage = 0;
    private int offersMaxPage = 0;
    private int discountsMaxPage = 0;
    private int exposMaxPage = 0;
    private CategoriesRVAdapter categoriesRVAdapter;
    private OffersRVAdapter offersRVAdapter;
    private DiscountRVAdapter discountRVAdapter;
    private ExposRVAdapter exposRVAdapter;
    private List<CategoriesDataModel> categoriesDataModels = new ArrayList<>();
    private List<OffersDataModel> offersDataModels = new ArrayList<>();
    private List<DiscountsDataModel> discountsDataModels = new ArrayList<>();
    private List<ExpoDataModel> expoDataModels = new ArrayList<>();

    private BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping,
                container, false);

        getActivity().findViewById(R.id.activity_home_rl_top).setVisibility(View.VISIBLE);

        bottomNavigationView = getActivity().findViewById(R.id.activity_home_bottom_nav_bar);

        setBottomNav(bottomNavigationView);

        binding.fragmentShoppingCategoriesShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new CategoriesFragment(),
                        getActivity().getSupportFragmentManager(),
                        R.id.nav_host_fragment);
            }
        });

        binding.fragmentShoppingOffersShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new OffersFragment(),
                        getActivity().getSupportFragmentManager(),
                        R.id.nav_host_fragment);
            }
        });

        binding.fragmentShoppingFurnShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new ExposFragment(),
                        getActivity().getSupportFragmentManager(),
                        R.id.nav_host_fragment);
            }
        });

        init();

        return binding.getRoot();
    }

    private void setBottomNav(BottomNavigationView bottomNavigationView){

        bottomNavigationView.setVisibility(View.VISIBLE);

        Menu menu = bottomNavigationView.getMenu();

        menu.findItem(R.id.nav_shopping).setChecked(true);

    }

    private void init() {

        categoriesLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        offersLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        discountsLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        exposLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.fragmentShoppingCategoriesRv.setLayoutManager(categoriesLinearLayoutManager);
        binding.fragmentShoppingOffersRv.setLayoutManager(offersLinearLayoutManager);
        binding.fragmentShoppingDiscountsRv.setLayoutManager(discountsLinearLayoutManager);
        binding.fragmentShoppingFurnRv.setLayoutManager(exposLinearLayoutManager);

        categoriesOnEndLess = new OnEndLess(categoriesLinearLayoutManager, 1) {
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
        binding.fragmentShoppingCategoriesRv.addOnScrollListener(categoriesOnEndLess);


        offersOnEndLess = new OnEndLess(offersLinearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= offersMaxPage) {
                    if (offersMaxPage != 0 && current_page != 1) {
                        offersOnEndLess.previous_page = offersOnEndLess.current_page;
                        getOffers(current_page);
                    } else {
                        offersOnEndLess.current_page = offersOnEndLess.previous_page;
                    }
                } else {
                    offersOnEndLess.current_page = offersOnEndLess.previous_page;
                }
            }
        };
        binding.fragmentShoppingOffersRv.addOnScrollListener(offersOnEndLess);

        discountsOnEndLess = new OnEndLess(discountsLinearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= discountsMaxPage) {
                    if (discountsMaxPage != 0 && current_page != 1) {
                        discountsOnEndLess.previous_page = current_page;
                        getCategories(current_page);
                    } else {
                        discountsOnEndLess.current_page = discountsOnEndLess.previous_page;
                    }
                } else {
                    discountsOnEndLess.current_page = discountsOnEndLess.previous_page;
                }
            }
        };
        binding.fragmentShoppingDiscountsRv.addOnScrollListener(discountsOnEndLess);

        exposOnEndLess = new OnEndLess(exposLinearLayoutManager, 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= exposMaxPage) {
                    if (exposMaxPage != 0 && current_page != 1) {
                        exposOnEndLess.previous_page = current_page;
                        getExpos(current_page);
                    } else {
                        exposOnEndLess.current_page = exposOnEndLess.previous_page;
                    }
                } else {
                    exposOnEndLess.current_page = exposOnEndLess.previous_page;
                }

            }
        };
        binding.fragmentShoppingFurnRv.addOnScrollListener(exposOnEndLess);

        categoriesRVAdapter = new CategoriesRVAdapter(getActivity(), categoriesDataModels);
        binding.fragmentShoppingCategoriesRv.setAdapter(categoriesRVAdapter);

        offersRVAdapter = new OffersRVAdapter(getActivity());
        offersRVAdapter.setOffersDataList(offersDataModels);
        binding.fragmentShoppingOffersRv.setAdapter(offersRVAdapter);

        discountRVAdapter = new DiscountRVAdapter(getActivity(), discountsDataModels);
        binding.fragmentShoppingDiscountsRv.setAdapter(discountRVAdapter);

        exposRVAdapter = new ExposRVAdapter(getActivity());
        exposRVAdapter.setDataList(expoDataModels);
        binding.fragmentShoppingFurnRv.setAdapter(exposRVAdapter);

        getCategories(1);

        getOffers(1);

        getDiscounts(1);

        getExpos(1);

    }

    private void getCategories(int page) {
        binding.categoriesProgressBar.setVisibility(View.VISIBLE);
        ApiClient.getClient2().getCategories().enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                binding.categoriesProgressBar.setVisibility(View.GONE);
                try {

                    if (response.body().getStatus()) {
//                        categoriesDataModels.clear();
                        categoriesDataModels.addAll(response.body().getData());
                        categoriesRVAdapter.notifyDataSetChanged();
                    }

                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {

            }
        });
    }

    private void getOffers(int page) {
        binding.offersProgressBar.setVisibility(View.VISIBLE);
        ApiClient.getClient2().getOffers(page)
                .enqueue(new Callback<OffersPaginatedResponse>() {
                    @Override
                    public void onResponse(Call<OffersPaginatedResponse> call, Response<OffersPaginatedResponse> response) {
                        binding.offersProgressBar.setVisibility(View.GONE);
                        try {
                            if (response.body().getStatus()) {

//                                offersDataModels.clear();
                                offersMaxPage = response.body().getData().getLastPage();
                                offersDataModels.addAll(response.body().getData().getData());
                                offersRVAdapter.notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onFailure(Call<OffersPaginatedResponse> call, Throwable t) {

                    }
                });

    }

    private void getDiscounts(int page){

        ApiClient.getClient1().getDiscounts("DESC", page)
                .enqueue(new Callback<DiscountsResponse>() {
                    @Override
                    public void onResponse(Call<DiscountsResponse> call, Response<DiscountsResponse> response) {
                        try {

                            if (response.body().getStatus()){
                                discountsMaxPage = response.body().getPaginator().getLastPage();
                                discountsDataModels.addAll(response.body().getData());
                                discountRVAdapter.notifyDataSetChanged();
                            }

                        }catch (Exception e){}
                    }

                    @Override
                    public void onFailure(Call<DiscountsResponse> call, Throwable t) {

                    }
                });

    }

    private void getExpos(int page){

        ApiClient.getClient2().getExpos(page).enqueue(new Callback<ExposPaginatedResponse>() {
            @Override
            public void onResponse(Call<ExposPaginatedResponse> call, Response<ExposPaginatedResponse> response) {
                try {

                    if (response.body().getStatus()) {
                        exposMaxPage = response.body().getData().getLastPage();
                        expoDataModels.addAll(response.body().getData().getData());
                        exposRVAdapter.notifyDataSetChanged();
                    }

                }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<ExposPaginatedResponse> call, Throwable t) {

            }
        });
    }

}
