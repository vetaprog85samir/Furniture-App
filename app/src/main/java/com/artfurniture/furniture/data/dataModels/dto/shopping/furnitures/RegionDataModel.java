
package com.artfurniture.furniture.data.dataModels.dto.shopping.furnitures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionDataModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("region_id")
    @Expose
    private Integer regionId;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
