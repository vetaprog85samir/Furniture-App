package com.artfurniture.furniture.data.dataModels.domain;

public class LoginModel {

    private String username;
    private String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
