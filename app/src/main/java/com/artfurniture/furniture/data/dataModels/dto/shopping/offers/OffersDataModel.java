
package com.artfurniture.furniture.data.dataModels.dto.shopping.offers;

import java.util.List;

import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.ProductDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.ImageDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OffersDataModel {

//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("offer_id")
//    @Expose
//    private Integer offerId;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("price")
//    @Expose
//    private Integer price;
//    @SerializedName("video")
//    @Expose
//    private Object video;
//    @SerializedName("images")
//    @Expose
//    private List<ImageDataModel> images = null;
//    @SerializedName("furniture_id")
//    @Expose
//    private Integer furnitureId;
//    @SerializedName("furniture_name")
//    @Expose
//    private String furnitureName;
//    @SerializedName("furniture_logo")
//    @Expose
//    private String furnitureLogo;
//    @SerializedName("products")
//    @Expose
//    private List<ProductDataModel> productDataModels = null;
//    @SerializedName("rate")
//    @Expose
//    private Integer rate;
//    @SerializedName("rate_count")
//    @Expose
//    private Integer rateCount;
//    @SerializedName("model_type")
//    @Expose
//    private String modelType;
//    @SerializedName("qty_cart")
//    @Expose
//    private String qtyCart;

    @SerializedName("offerName")
    @Expose
    private String offerName;

    @SerializedName("offerImg")
    @Expose
    private String offerImg;

    @SerializedName("offerPrice")
    @Expose
    private String offerPrice;

    @SerializedName("expoName")
    @Expose
    private String expoName;

    @SerializedName("expoLogo")
    @Expose
    private String expoLogo;

    public String getExpoName() {
        return expoName;
    }

    public void setExpoName(String expoName) {
        this.expoName = expoName;
    }

    public String getExpoLogo() {
        return expoLogo;
    }

    public void setExpoLogo(String expoLogo) {
        this.expoLogo = expoLogo;
    }

    @SerializedName("product1Img")
    @Expose
    private String product1Img;

    @SerializedName("product1Name")
    @Expose
    private String product1Name;

    @SerializedName("product1No")
    @Expose
    private String product1No;

    @SerializedName("product2Img")
    @Expose
    private String product2Img;

    @SerializedName("product2Name")
    @Expose
    private String product2Name;

    @SerializedName("product2No")
    @Expose
    private String product2No;

    @SerializedName("product3Img")
    @Expose
    private String product3Img;

    @SerializedName("product3Name")
    @Expose
    private String product3Name;

    @SerializedName("product3No")
    @Expose
    private String product3No;

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferImg() {
        return offerImg;
    }

    public void setOfferImg(String offerImg) {
        this.offerImg = offerImg;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getProduct1Img() {
        return product1Img;
    }

    public void setProduct1Img(String product1Img) {
        this.product1Img = product1Img;
    }

    public String getProduct1Name() {
        return product1Name;
    }

    public void setProduct1Name(String product1Name) {
        this.product1Name = product1Name;
    }

    public String getProduct1No() {
        return product1No;
    }

    public void setProduct1No(String product1No) {
        this.product1No = product1No;
    }

    public String getProduct2Img() {
        return product2Img;
    }

    public void setProduct2Img(String product2Img) {
        this.product2Img = product2Img;
    }

    public String getProduct2Name() {
        return product2Name;
    }

    public void setProduct2Name(String product2Name) {
        this.product2Name = product2Name;
    }

    public String getProduct2No() {
        return product2No;
    }

    public void setProduct2No(String product2No) {
        this.product2No = product2No;
    }

    public String getProduct3Img() {
        return product3Img;
    }

    public void setProduct3Img(String product3Img) {
        this.product3Img = product3Img;
    }

    public String getProduct3Name() {
        return product3Name;
    }

    public void setProduct3Name(String product3Name) {
        this.product3Name = product3Name;
    }

    public String getProduct3No() {
        return product3No;
    }

    public void setProduct3No(String product3No) {
        this.product3No = product3No;
    }
}
