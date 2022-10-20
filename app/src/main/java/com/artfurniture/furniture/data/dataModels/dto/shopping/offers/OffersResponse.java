
package com.artfurniture.furniture.data.dataModels.dto.shopping.offers;

import java.util.List;

import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.Paginator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OffersResponse {

    @SerializedName("data")
    @Expose
    private List<OffersDataModel> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("paginator")
    @Expose
    private Paginator paginator;

    public List<OffersDataModel> getData() {
        return data;
    }

    public void setData(List<OffersDataModel> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

}
