
package com.artfurniture.furniture.data.dataModels.dto.shopping.furnitures;

import java.util.List;

import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.Paginator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FurnitureResponse {

    @SerializedName("data")
    @Expose
    private List<FurnitureDataModel> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("paginator")
    @Expose
    private Paginator paginator;

    public List<FurnitureDataModel> getData() {
        return data;
    }

    public void setData(List<FurnitureDataModel> data) {
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
