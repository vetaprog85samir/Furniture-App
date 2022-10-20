package com.artfurniture.furniture.data.dataModels.dto.shopping.expos;

import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.braches.BranchDataModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.comments.CommentDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExpoDataModel {

    @SerializedName("_id")
    @Expose
    private String expoId;

    @SerializedName("expoName")
    @Expose
    private String expoName;

    @SerializedName("expoLogo")
    @Expose
    private String expoLogo;

//    @SerializedName("branches")
//    @Expose
//    private List<BranchDataModel> branches = null;
//
//    @SerializedName("comments")
//    @Expose
//    private List<CommentDataModel> comments;

    @SerializedName("branches")
    @Expose
    private List<String> branches;

    @SerializedName("comments")
    @Expose
    private List<String> comments;


    public String getExpoId() {
        return expoId;
    }

    public void setExpoId(String expoId) {
        this.expoId = expoId;
    }


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

//    public List<BranchDataModel> getBranches() {
//        return branches;
//    }
//
//    public void setBranches(List<BranchDataModel> branches) {
//        this.branches = branches;
//    }

        public List<String> getBranches() {
        return branches;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
