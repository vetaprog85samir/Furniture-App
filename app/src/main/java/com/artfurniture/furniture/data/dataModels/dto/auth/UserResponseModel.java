package com.artfurniture.furniture.data.dataModels.dto.auth;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.artfurniture.furniture.data.dataModels.dto.auth.UserDataModel;

public class UserResponseModel {
    @SerializedName("data")
    @Expose
    private UserModel data;
    @SerializedName("msg")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;


    public UserModel getData() {
        return data;
    }

    public void setData(UserModel data) {
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
}
