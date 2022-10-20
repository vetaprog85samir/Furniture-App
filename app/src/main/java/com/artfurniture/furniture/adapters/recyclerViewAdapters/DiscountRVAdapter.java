package com.artfurniture.furniture.adapters.recyclerViewAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.DiscountsDataModel;
import com.artfurniture.furniture.databinding.DiscountsRowItemBinding;
import com.artfurniture.furniture.ui.views.activities.BaseActivity;
import com.artfurniture.furniture.utils.HelperMethod;

public class DiscountRVAdapter extends RecyclerView.Adapter<DiscountRVAdapter.ViewHolder> {

    public Activity activity;
    private List<DiscountsDataModel> discountsDataModels = new ArrayList<>();

    public DiscountRVAdapter(Activity activity, List<DiscountsDataModel> discountsDataModels) {
        this.activity = activity;
        this.discountsDataModels = discountsDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        DiscountsRowItemBinding binding =
//                DiscountsRowItemBinding.inflate(LayoutInflater.from(activity),
//                        R.layout.discounts_row_item, parent, false);
//
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder,position);
        setAction(holder,position);


    }

    private void setData(ViewHolder holder, int position) {

        holder.binding.discountsRowItemFurnNameTv
                .setText(discountsDataModels.get(position).getFurnitureName());

        HelperMethod.onLoadImageFromUrl(holder.binding.discountsRowItemFurnLogoIv,
                discountsDataModels.get(position).getFurnitureLogo(), activity);

        holder.binding.discountsRowItemProduct1NameTv
                .setText(discountsDataModels.get(position).getProductName());

//        HelperMethod.onLoadImageFromUrl(holder.binding.discountsRowItemProduct1Iv,
//                discountsDataModels.get(position).getImages().get(position).getPath());



    }

    private void setAction(ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return discountsDataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private DiscountsRowItemBinding binding;
        public ViewHolder(@NonNull DiscountsRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
