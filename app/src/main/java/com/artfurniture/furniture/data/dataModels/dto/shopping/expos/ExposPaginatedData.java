package com.artfurniture.furniture.data.dataModels.dto.shopping.expos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExposPaginatedData {

    @SerializedName("previous_page")
    @Expose
    private Integer previousPage;
    @SerializedName("next_page")
    @Expose
    private Integer nextPage;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;
    @SerializedName("data")
    @Expose
    private List<ExpoDataModel> data = null;

    public Integer getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Integer previousPage) {
        this.previousPage = previousPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public List<ExpoDataModel> getData() {
        return data;
    }

    public void setData(List<ExpoDataModel> data) {
        this.data = data;
    }
}
