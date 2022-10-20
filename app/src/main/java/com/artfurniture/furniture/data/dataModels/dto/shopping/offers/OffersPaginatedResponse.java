
package com.artfurniture.furniture.data.dataModels.dto.shopping.offers;

import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.DiscountsPaginatedData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OffersPaginatedResponse {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private OffersPaginatedData data;

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

    public OffersPaginatedData getData() {
        return data;
    }

    public void setData(OffersPaginatedData data) {
        this.data = data;
    }
}
