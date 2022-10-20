package com.artfurniture.furniture.adapters.recyclerViewAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataModels.dto.shopping.furnitures.FurnitureDataModel;
import com.artfurniture.furniture.databinding.FurnRowItemBinding;
import com.artfurniture.furniture.ui.views.activities.BaseActivity;
import com.artfurniture.furniture.utils.HelperMethod;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class FurnRVAdapter extends RecyclerView.Adapter<FurnRVAdapter.ViewHolder> {

    public Activity activity;
    private List<FurnitureDataModel> furnitureDataModels = new ArrayList<>();

    public FurnRVAdapter(Activity activity, List<FurnitureDataModel> furnitureDataModels) {
        this.activity = activity;
        this.furnitureDataModels = furnitureDataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FurnRowItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(activity),
                        R.layout.furn_row_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder,position);
        setAction(holder,position);


    }

    private void setData(ViewHolder holder, int position) {

        holder.binding.furnRowItemNameTv
                .setText(furnitureDataModels.get(position).getName());

//        HelperMethod.onLoadImageFromUrl(holder.binding.furnRowItemIconIv,
//                furnitureDataModels.get(position).getLogo());

    }

    private void setAction(ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return furnitureDataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private FurnRowItemBinding binding;
        public ViewHolder(@NonNull FurnRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
