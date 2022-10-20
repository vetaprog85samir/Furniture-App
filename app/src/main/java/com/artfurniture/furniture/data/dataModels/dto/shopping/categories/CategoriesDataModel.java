
package com.artfurniture.furniture.data.dataModels.dto.shopping.categories;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesDataModel {

//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("category_id")
//    @Expose
//    private Integer categoryId;
//    @SerializedName("code")
//    @Expose
//    private Object code;
//    @SerializedName("image")
//    @Expose
//    private String image;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("count")
//    @Expose
//    private Integer count;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    @SerializedName("categoryImg")
    @Expose
    private String categoryImg;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }
}
