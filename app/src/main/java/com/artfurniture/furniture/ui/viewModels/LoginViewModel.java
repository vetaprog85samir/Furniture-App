package com.artfurniture.furniture.ui.viewModels;

import android.app.Activity;

import com.artfurniture.furniture.data.dataManagers.repo.LoginRepo;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    LoginRepo loginRepo;

    public LoginViewModel() {
        loginRepo = new LoginRepo();
    }

    public void userLogin(String username, String password, Activity activity){
        loginRepo.userLogin(username, password, activity);
    }

}
