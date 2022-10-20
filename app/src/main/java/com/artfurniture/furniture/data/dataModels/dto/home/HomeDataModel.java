
package com.artfurniture.furniture.data.dataModels.dto.home;

import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.DiscountsDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeDataModel {

    @SerializedName("categories")
    @Expose
    private List<CategoriesDataModel> categories = null;
    @SerializedName("offers")
    @Expose
    private List<OffersDataModel> offers = null;
    @SerializedName("saves")
    @Expose
    private List<Object> saves = null;
    @SerializedName("discounts")
    @Expose
    private List<DiscountsDataModel> discounts = null;
    @SerializedName("branch_type")
    @Expose
    private List<BranchType> branchType = null;



    public List<CategoriesDataModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesDataModel> categories) {
        this.categories = categories;
    }

    public List<OffersDataModel> getOffers() {
        return offers;
    }

    public void setOffers(List<OffersDataModel> offers) {
        this.offers = offers;
    }

    public List<Object> getSaves() {
        return saves;
    }

    public void setSaves(List<Object> saves) {
        this.saves = saves;
    }

    public List<DiscountsDataModel> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountsDataModel> discounts) {
        this.discounts = discounts;
    }

    public List<BranchType> getBranchType() {
        return branchType;
    }

    public void setBranchType(List<BranchType> branchType) {
        this.branchType = branchType;
    }

}
