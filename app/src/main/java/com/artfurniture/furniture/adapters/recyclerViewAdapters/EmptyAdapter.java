package com.artfurniture.furniture.adapters.recyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.RowItemEmptyBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {

    public FragmentActivity activity;
//    private List<DataModel> DataModels = new ArrayList<>();


    public EmptyAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RowItemEmptyBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(activity),
                        R.layout.row_item_empty, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder,position);
        setAction(holder,position);


    }

    private void setData(ViewHolder holder, int position) {

    }

    private void setAction(ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }

//    public void setDataList(List<DataModel> DataModels){
//        this.DataModels = DataModels;
//        notifyDataSetChanged();
//    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private RowItemEmptyBinding binding;
        public ViewHolder(@NonNull RowItemEmptyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
