
package com.artfurniture.furniture.data.dataModels.dto.shopping.furnitures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GovernorateDataModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("governorate_id")
    @Expose
    private Integer governorateId;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(Integer governorateId) {
        this.governorateId = governorateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
