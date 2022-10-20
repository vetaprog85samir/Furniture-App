package com.artfurniture.furniture.data.dataModels.dto.shopping.expos.comments;

import com.artfurniture.furniture.data.dataModels.dto.auth.UserDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExpoDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentDataModel {

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("expo")
    @Expose
    private String expo;

    @SerializedName("createdBy")
    @Expose
    private String createdBy;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExpo() {
        return expo;
    }

    public void setExpo(String expo) {
        this.expo = expo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
