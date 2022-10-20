
package com.artfurniture.furniture.data.dataModels.dto.shopping.discounts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscountsResponse {

    @SerializedName("data")
    @Expose
    private List<DiscountsDataModel> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("paginator")
    @Expose
    private Paginator paginator;

    public List<DiscountsDataModel> getData() {
        return data;
    }

    public void setData(List<DiscountsDataModel> data) {
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
