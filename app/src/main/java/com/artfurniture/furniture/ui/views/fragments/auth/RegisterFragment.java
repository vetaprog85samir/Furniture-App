package com.artfurniture.furniture.ui.views.fragments.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.dto.auth.UserResponseModel;
import com.artfurniture.furniture.databinding.FragmentRegBinding;
import com.artfurniture.furniture.ui.views.activities.HomeActivity;
import com.artfurniture.furniture.utils.HelperMethod;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment{

    private FragmentRegBinding binding;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String passwordConfirmation;

    private static final String TAG = "RegisterFragment ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg,
                container, false);

        binding.fragmentRegAccessBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                name = binding.fragmentRegNameEt.getText().toString();
                email = binding.fragmentRegEmailEt.getText().toString();
                phone = binding.fragmentRegPhoneEt.getText().toString();
                address = binding.fragmentRegAddressEt.getText().toString();
                password = binding.fragmentRegPasswordEt.getText().toString();
                passwordConfirmation = binding.fragmentRegPasswordConfirmationEt.getText().toString();

                userRegister(name, email, phone, address, password, passwordConfirmation);

//                userRegister();

            }
        });

        binding.fragmentRegHaveAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(new LoginFragment(),
                        getActivity().getSupportFragmentManager(), R.id.activity_auth_container);
            }
        });



        return binding.getRoot();
    }

    private void userRegister(String name, String email, String phone,
                              String address, String password,
                              String passwordConfirmation){

//    private void userRegister(){
//
//        String name = binding.fragmentRegNameEt.getText().toString();
//        String email = binding.fragmentRegEmailEt.getText().toString();
//        String phone = binding.fragmentRegPhoneEt.getText().toString();
//        String address = binding.fragmentRegAddressEt.getText().toString();
//        String password = binding.fragmentRegPasswordEt.getText().toString();
//        String passwordConfirmation = binding.fragmentRegPasswordConfirmationEt.getText().toString();


        ApiClient.getClient2().userRegister(name, email, phone, address,
                password, passwordConfirmation).enqueue(new Callback<UserResponseModel>() {
            @Override
            public void onResponse(Call<UserResponseModel> call, Response<UserResponseModel> response) {
                try {
                    if (response.body().getStatus()) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        startActivity(new Intent(getActivity(), HomeActivity.class));
                    }
                }catch (Exception e){
                    Log.d(TAG, "onResponse: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserResponseModel> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());
            }
        });

    }

}
