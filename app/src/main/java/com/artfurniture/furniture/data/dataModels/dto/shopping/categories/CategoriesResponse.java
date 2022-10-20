
package com.artfurniture.furniture.data.dataModels.dto.shopping.categories;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CategoriesResponse {

    @SerializedName("data")
    @Expose
    private List<CategoriesDataModel> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;

    public List<CategoriesDataModel> getData() {
        return data;
    }

    public void setData(List<CategoriesDataModel> data) {
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
