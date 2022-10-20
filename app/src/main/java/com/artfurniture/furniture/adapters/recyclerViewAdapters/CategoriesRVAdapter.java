package com.artfurniture.furniture.adapters.recyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.CategoryRowItemBinding;
import com.artfurniture.furniture.ui.views.activities.BaseActivity;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesDataModel;
import com.artfurniture.furniture.ui.views.fragments.details.categories.CategoryDetailsFragment;
import com.artfurniture.furniture.utils.HelperMethod;


public class CategoriesRVAdapter extends RecyclerView.Adapter<CategoriesRVAdapter.ViewHolder> {

    public FragmentActivity activity;
    private List<CategoriesDataModel> categoriesDataModels = new ArrayList<>();


    public CategoriesRVAdapter(FragmentActivity activity, List<CategoriesDataModel> categoriesDataModels) {
        this.activity = activity;
        this.categoriesDataModels = categoriesDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CategoryRowItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(activity),
                        R.layout.category_row_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder,position);
        setAction(holder,position);


    }

    private void setData(ViewHolder holder, int position) {

        holder.binding.categoryRowItemNameTv
                .setText(categoriesDataModels.get(position).getCategoryName());

        HelperMethod.onLoadImageFromUrl(holder.binding.categoryRowItemIconIv,
                categoriesDataModels.get(position).getCategoryImg(), activity);

    }

    private void setAction(ViewHolder holder, int position) {

        holder.binding.categoryRowItemLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CategoryDetailsFragment categoryDetailsFragment = new CategoryDetailsFragment();
                categoryDetailsFragment.categoriesDataModel = categoriesDataModels.get(position);
                HelperMethod.replaceFragment(activity.getSupportFragmentManager(),
                        R.id.nav_host_fragment, categoryDetailsFragment);

            }
        });


    }
    @Override
    public int getItemCount() {
        return categoriesDataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private CategoryRowItemBinding binding;

        public ViewHolder(@NonNull CategoryRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
