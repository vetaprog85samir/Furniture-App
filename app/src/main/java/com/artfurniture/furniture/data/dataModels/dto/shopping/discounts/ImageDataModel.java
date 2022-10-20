
package com.artfurniture.furniture.data.dataModels.dto.shopping.discounts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageDataModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("path_id")
    @Expose
    private Integer pathId;
    @SerializedName("path")
    @Expose
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
