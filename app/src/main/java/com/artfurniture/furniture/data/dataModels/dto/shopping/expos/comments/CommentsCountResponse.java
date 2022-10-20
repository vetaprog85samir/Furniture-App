package com.artfurniture.furniture.data.dataModels.dto.shopping.expos.comments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentsCountResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("msg")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
