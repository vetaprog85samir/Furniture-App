package com.artfurniture.furniture.adapters.recyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExpoDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExposPaginatedResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.comments.CommentsCountResponse;
import com.artfurniture.furniture.databinding.RowItemEmptyBinding;
import com.artfurniture.furniture.databinding.RowItemExposBinding;
import com.artfurniture.furniture.ui.views.fragments.details.expos.ExpoDetailsFragment;
import com.artfurniture.furniture.utils.HelperMethod;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExposRVAdapter extends RecyclerView.Adapter<ExposRVAdapter.ViewHolder> {

    public FragmentActivity activity;
    private List<ExpoDataModel> expoDataModels = new ArrayList<>();

    private String expoId;


    public ExposRVAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RowItemExposBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(activity),
                        R.layout.row_item_expos, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder,position);
        setAction(holder,position);
    }

    private void setData(ViewHolder holder, int position) {

        holder.binding.rowItemExposExpoNameTv.setText(expoDataModels.get(position).getExpoName());

        HelperMethod.onLoadImageFromUrl(holder.binding.rowItemExposExpoIconIv,
                expoDataModels.get(position).getExpoLogo(), activity);

//        holder.binding.rowItemExposExpoAddressTv.setText(
//                expoDataModels.get(position).getBranches().get(1).getAddress()
//        );

        expoId = expoDataModels.get(position).getExpoId();

        ApiClient.getClient2().getCommentsCountByExpoId(expoId).enqueue(
                new Callback<CommentsCountResponse>() {
                    @Override
                    public void onResponse(Call<CommentsCountResponse> call, Response<CommentsCountResponse> response) {
                        try {

                            if (response.body().getStatus()) {
                                holder.binding.rowItemExposCommentsCount.setText(
                                        response.body().getData()
                                );
                            }

                        }catch (Exception e){}
                    }

                    @Override
                    public void onFailure(Call<CommentsCountResponse> call, Throwable t) {

                    }
                }
        );


    }

    private void setAction(ViewHolder holder, int position) {

        holder.binding.rowItemExposLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpoDetailsFragment expoDetailsFragment = new ExpoDetailsFragment();
                expoDetailsFragment.expoDataModel = expoDataModels.get(position);
                HelperMethod.replaceFragment(activity.getSupportFragmentManager(),
                        R.id.nav_host_fragment, expoDetailsFragment);
            }
        });

    }
    @Override
    public int getItemCount() {
        return expoDataModels.size();
    }

    public void setDataList(List<ExpoDataModel> expoDataModels){
        this.expoDataModels = expoDataModels;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private RowItemExposBinding binding;
        public ViewHolder(@NonNull RowItemExposBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
