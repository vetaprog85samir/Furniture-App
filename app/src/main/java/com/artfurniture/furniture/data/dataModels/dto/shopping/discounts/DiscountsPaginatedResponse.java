
package com.artfurniture.furniture.data.dataModels.dto.shopping.discounts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscountsPaginatedResponse {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DiscountsPaginatedData data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DiscountsPaginatedData getData() {
        return data;
    }

    public void setData(DiscountsPaginatedData data) {
        this.data = data;
    }
}
