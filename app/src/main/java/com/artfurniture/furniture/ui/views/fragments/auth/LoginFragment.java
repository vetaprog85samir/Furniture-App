package com.artfurniture.furniture.ui.views.fragments.auth;

import android.content.Intent;
import android.media.FaceDetector;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.artfurniture.furniture.R;
import com.artfurniture.furniture.data.dataManagers.local.sharedPrefsManager.SharedPrefsManager;
import com.artfurniture.furniture.data.dataManagers.remote.retrofit.ApiClient;
import com.artfurniture.furniture.data.dataModels.domain.LoginModel;
import com.artfurniture.furniture.data.dataModels.dto.auth.UserDataModel;
import com.artfurniture.furniture.data.dataModels.dto.auth.UserResponseModel;
import com.artfurniture.furniture.databinding.FragmentLoginBinding;
import com.artfurniture.furniture.ui.viewModels.LoginViewModel;
import com.artfurniture.furniture.ui.views.activities.HomeActivity;
import com.artfurniture.furniture.utils.HelperMethod;
import com.cloudinary.api.exceptions.ApiException;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.lang.Object;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import okhttp3.RequestBody;
import okhttp3.MultipartBody;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;
    private String username;
    private String password;
    private UserDataModel userDataModel;

    private CallbackManager callbackManager;
    private LoginManager loginManager;

    private static final String TAG = "Login Fragment";

    private GoogleSignInClient googleSignInClient;

    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);


        FacebookSdk.sdkInitialize(getActivity());
        callbackManager = CallbackManager.Factory.create();

        facebookLogin();

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken("829154751753-td3nhv0j0m96gu1trcmpgb8j2m5gt3gm.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(getActivity(),
                googleSignInOptions);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());


        binding.fragmentLoginNewAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethod.replace(
                        new RegisterFragment(), getActivity().getSupportFragmentManager(),
                        R.id.activity_auth_container
                );
            }
        });

        binding.fragmentLoginGoogleRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = googleSignInClient.getSignInIntent();
                startActivityForResult(intent, 100);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {
            startActivity(new Intent(getActivity(), HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }



        binding.fragmentLoginFacebookRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginManager.logInWithReadPermissions(
                        getActivity(),
                        Arrays.asList(
                                "email",
                                "public_profile"
//                                "user_birthday"
                        )
                );
            }
        });


//        RequestBody usernameRB = RequestBody.create(MediaType.parse("multipart/form-data"), username);
//        RequestBody passwordRB = RequestBody.create(MediaType.parse("multipart/form-data"), password);
//        RequestBody usernameRB = RequestBody.create(MediaType.parse("text/plain"), username);
//        RequestBody passwordRB = RequestBody.create(MediaType.parse("text/plain"), password);
//        MultipartBody multipartBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("username", username)
//                .addFormDataPart("password", password)
//                .build();

        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);



        binding.fragmentLoginAccessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                username = binding.fragmentLoginUsernameEt.getText().toString();
                password = binding.fragmentLoginPasswordEt.getText().toString();

                HelperMethod.showProgressDialog(getActivity(), getString(R.string.waiting));

                ApiClient.getClient2().userLogin(username, password)
                        .enqueue(new Callback<UserResponseModel>() {
                            @Override
                            public void onResponse(Call<UserResponseModel> call, Response<UserResponseModel> response) {

                                HelperMethod.dismissProgressDialog();

                                try {
                                    if (response.body().getStatus()) {
                                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                                        startActivity(intent);
                                    }
                                    Log.d(TAG, "onResponseError: " + response.body().getMessage());
                                }catch (Exception e){
                                    Log.d(TAG, "onException: " + e.getMessage());
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponseModel> call, Throwable t) {
                                HelperMethod.dismissProgressDialog();
                            }
                        });

//                loginViewModel.userLogin(username, password, getActivity());


            }
        });

        View v = binding.getRoot();

        return v;
    }

    public void facebookLogin(){
        loginManager = LoginManager.getInstance();
        callbackManager = CallbackManager.Factory.create();

        loginManager.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {

                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        if (object != null) {
                                            try {
                                                String name = object.getString("name");
                                                String email = object.getString("email");
                                                String fbUserID = object.getString("id");

                                                String picUrl = object.getJSONObject("picture")
                                                        .getJSONObject("data").getString("url");

                                                disconnectFromFacebook();

//                                                Intent intent = new Intent(getActivity(), HomeActivity.class);
//                                                startActivity(intent);


                                                // do action after Facebook login success
                                                // or call your API
                                            }
                                            catch (JSONException | NullPointerException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                        );

                        Bundle parameters = new Bundle();
                        parameters.putString(
                                "fields",
                                "id, name, email, gender, birthday"
                        );

                        request.setParameters(parameters);
                        request.executeAsync();

                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {

                        Log.v("LoginScreen", "---onCancel");
                    }

                    @Override
                    public void onError(FacebookException error) {

                        // here write code when get error
                        Log.v("LoginScreen", "----onError: "+ error.getMessage());
                    }
                });
    }

    public void disconnectFromFacebook(){
        if (AccessToken.getCurrentAccessToken() == null) {
            return;
        }

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/permissions/",
                null,
                HttpMethod.DELETE,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        LoginManager.getInstance().logOut();
                    }
                }
        ).executeAsync();
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100)
        {
            // When request code is equal to 100
            // Initialize task

            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn
                    .getSignedInAccountFromIntent(data);

            // check condition
//            if(signInAccountTask.isSuccessful())
//            {
                // When google sign in successful
                // Initialize string
//                String s="Google sign in successful";
//                // Display Toast
//                displayToast(s);
                // Initialize sign in account
                try {
                    // Initialize sign in account
                    GoogleSignInAccount googleSignInAccount=signInAccountTask
                            .getResult(ApiException.class);

                    startActivity(new Intent(getActivity(), HomeActivity.class));

//                    // Check condition
//                    if(googleSignInAccount!=null)
//                    {
//                        // When sign in account is not equal to null
//                        // Initialize auth credential
//                        AuthCredential authCredential = GoogleAuthProvider
//                                .getCredential((googleSignInAccount.getIdToken()), null);
//
//                        // Check credential
//                        firebaseAuth.signInWithCredential(authCredential)
//                                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        // Check condition
//                                        if(task.isSuccessful())
//                                        {
//                                            // When task is successful
//                                            // Redirect to profile activity
//                                            startActivity(new Intent(getActivity()
//                                                    ,HomeActivity.class)
//                                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                                            // Display Toast
//                                            displayToast("Firebase authentication successful");
//                                        }
//                                        else
//                                        {
//                                            // When task is unsuccessful
//                                            // Display Toast
//                                            displayToast("Authentication Failed :"+task.getException()
//                                                    .getMessage());
//                                        }
//                                    }
//                                });
//
//                    }
                }
                catch (ApiException e)
                {
                    e.printStackTrace();
                    Log.d(TAG, "signInResult:failed code=" + e.getMessage());
                }
//            }
        }
    }

    private void displayToast(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null) {
            startActivity(new Intent(getActivity(), HomeActivity.class));
        }
    }
}
