package com.artfurniture.furniture.ui.views.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.databinding.ActivityAuthBinding;
import com.artfurniture.furniture.ui.views.fragments.auth.LoginFragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import static com.artfurniture.furniture.utils.HelperMethod.replace;

public class AuthActivity extends AppCompatActivity {

    private static final String TAG = "Hash Key";

    ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);

        LoginFragment loginFragment = new LoginFragment();
        replace(loginFragment, getSupportFragmentManager(), R.id.activity_auth_container);

//        setContentView(R.layout.activity_auth);

        printHashKey();

    }

    public void printHashKey(){
        try {
            PackageInfo info =
                    getPackageManager().getPackageInfo(
                            "com.artfurniture.furniture",
                            PackageManager.GET_SIGNATURES
                    );

            for (Signature signature : info.signatures){
                MessageDigest md =
                        MessageDigest.getInstance("SHA");

                md.update(signature.toByteArray());

                Log.d(TAG, Base64.encodeToString(
                        md.digest(),Base64.DEFAULT
                ));
            }
        }
        catch (PackageManager.NameNotFoundException e){}
        catch (NoSuchAlgorithmException e){}
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        for (Fragment fragment : getSupportFragmentManager().getFragments()){
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}