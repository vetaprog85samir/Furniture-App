package com.artfurniture.furniture.data.dataModels.dto.auth;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("user")
    @Expose
    private UserDataModel data;

    @SerializedName("token")
    @Expose
    private String token;


    public UserDataModel getData() {
        return data;
    }

    public void setData(UserDataModel data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
