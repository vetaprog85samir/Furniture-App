package com.artfurniture.furniture.data.dataModels.dto.shopping.expos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExposPaginatedResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("msg")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private ExposPaginatedData data;

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

    public ExposPaginatedData getData() {
        return data;
    }

    public void setData(ExposPaginatedData data) {
        this.data = data;
    }
}
