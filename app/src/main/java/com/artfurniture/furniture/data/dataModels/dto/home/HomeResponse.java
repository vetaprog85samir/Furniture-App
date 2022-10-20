
package com.artfurniture.furniture.data.dataModels.dto.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResponse {

    @SerializedName("homeDataModel")
    @Expose
    private HomeDataModel homeDataModel;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HomeResponse() {
    }

    /**
     * 
     * @param homeDataModel
     * @param message
     * @param status
     */
    public HomeResponse(HomeDataModel homeDataModel, String message, Boolean status) {
        super();
        this.homeDataModel = homeDataModel;
        this.message = message;
        this.status = status;
    }

    public HomeDataModel getData() {
        return homeDataModel;
    }

    public void setData(HomeDataModel homeDataModel) {
        this.homeDataModel = homeDataModel;
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
