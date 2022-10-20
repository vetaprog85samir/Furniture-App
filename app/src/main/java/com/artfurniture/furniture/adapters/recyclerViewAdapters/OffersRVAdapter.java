package com.artfurniture.furniture.adapters.recyclerViewAdapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersDataModel;
import com.artfurniture.furniture.databinding.OffersRowItemBinding;
import com.artfurniture.furniture.ui.views.activities.BaseActivity;
import com.artfurniture.furniture.ui.views.fragments.details.offers.OfferDetailsFragment;
import com.artfurniture.furniture.utils.HelperMethod;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class OffersRVAdapter extends RecyclerView.Adapter<OffersRVAdapter.ViewHolder> {

    public FragmentActivity activity;
    private List<OffersDataModel> offersDataModels = new ArrayList<>();

    public OffersRVAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        OffersRowItemBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(activity),
                        R.layout.offers_row_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder,position);
        setAction(holder,position);


    }

    private void setData(ViewHolder holder, int position) {

        holder.binding.offersRowItemOfferNameTv
                .setText(offersDataModels.get(position).getOfferName());

        HelperMethod.onLoadImageFromUrl(holder.binding.offersRowItemIv,
                offersDataModels.get(position).getOfferImg(), activity);

        holder.binding.offersRowItemProduct1NameTv
                .setText(offersDataModels.get(position).getProduct1Name());

        holder.binding.offersRowItemProduct1NoTv
                .setText(offersDataModels.get(position).getProduct1No());

        HelperMethod.onLoadImageFromUrl(holder.binding.offersRowItemProduct1Iv,
                offersDataModels.get(position).getProduct1Img(), activity);

        holder.binding.offersRowItemProduct2NameTv
                .setText(offersDataModels.get(position).getProduct2Name());

        holder.binding.offersRowItemProduct2NoTv
                .setText(offersDataModels.get(position).getProduct2No());

        HelperMethod.onLoadImageFromUrl(holder.binding.offersRowItemProduct2Iv,
                offersDataModels.get(position).getProduct2Img(), activity);

        holder.binding.offersRowItemProduct3NameTv
                .setText(offersDataModels.get(position).getProduct3Name());

        holder.binding.offersRowItemProduct3NoTv
                .setText(offersDataModels.get(position).getProduct3No());

        HelperMethod.onLoadImageFromUrl(holder.binding.offersRowItemProduct3Iv,
                offersDataModels.get(position).getProduct3Img(), activity);

        holder.binding.offersRowItemFurnTv
                .setText(offersDataModels.get(position).getExpoName());


        HelperMethod.onLoadImageFromUrl(holder.binding.offersRowItemFurnIv,
                offersDataModels.get(position).getExpoLogo(), activity);

        holder.binding.offersRowItemOfferPriceTv
                .setText(String.valueOf(offersDataModels.get(position).getOfferPrice()));
    }

    private void setAction(ViewHolder holder, int position) {

        holder.binding.offersRowItemOrderNowLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OfferDetailsFragment offerDetailsFragment = new OfferDetailsFragment();
                offerDetailsFragment.offersDataModel = offersDataModels.get(position);
                HelperMethod.replaceFragment(activity.getSupportFragmentManager(),
                        R.id.nav_host_fragment, offerDetailsFragment);
            }
        });

    }
    @Override
    public int getItemCount() {
        return offersDataModels.size();
    }

    public void setOffersDataList(List<OffersDataModel> offersDataModels){
        this.offersDataModels = offersDataModels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private OffersRowItemBinding binding;
        public ViewHolder(@NonNull OffersRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
