package com.artfurniture.furniture.data.dataManagers.repo;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.artfurniture.furniture.data.dataManagers.local.sharedPrefsManager.SharedPrefsManager;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiServices;
import com.artfurniture.furniture.data.dataModels.dto.auth.UserResponseModel;
import com.artfurniture.furniture.ui.views.activities.AuthActivity;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {

    private static final String TAG = "Login Repo";

    public LoginRepo() {
    }



    public void userLogin(String username, String password, Activity activity) {

//        ApiClient.getClient().userLogin(username, password).enqueue(
//                new Callback<UserResponseModel>() {
//                    @Override
//                    public void onResponse(@NonNull Call<UserResponseModel> call, Response<UserResponseModel> response) {
//
////                        if(response.isSuccessful()){
////
////                            Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
////                            SharedPrefsManager.saveUserData(activity, response.body().getData());
////                            Log.d(TAG, "onResponse: " + response.body().getMessage());
////                        }
////
////                        Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
////                        Log.d(TAG, "onResponse: " + response.body().getMessage());
//
//                        try {
//
////                            if(response.body().getStatus()){
//                            if(response.isSuccessful()){
//                                Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                                SharedPrefsManager.saveUserData(activity, response.body().getData());
//                                Log.d(TAG, "onResponse: " + response.body().getMessage());
//                            }
//                            Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "onResponse: " + response.body().getMessage());
//                        }catch (Exception e){
//                            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "onResponse: exception " + e.getMessage());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<UserResponseModel> call, Throwable t) {
//
//                        Toast.makeText(activity, t.getMessage(),Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, "onFailure: "+ t.getMessage());
//                    }
//                }
//        );
    }
}
