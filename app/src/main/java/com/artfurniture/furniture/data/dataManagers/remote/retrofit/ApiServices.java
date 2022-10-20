package com.artfurniture.furniture.data.dataManagers.remote.retrofit;


import com.artfurniture.furniture.data.dataModels.domain.LoginModel;
import com.artfurniture.furniture.data.dataModels.dto.auth.UserResponseModel;
import com.artfurniture.furniture.data.dataModels.dto.shopping.categories.CategoriesResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.discounts.DiscountsResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.ExposPaginatedResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.expos.comments.CommentsCountResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersPaginatedResponse;
import com.artfurniture.furniture.data.dataModels.dto.shopping.offers.OffersResponse;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("category/getAllCategories")
    Call<CategoriesResponse> getCategories();

//    @GET("home/offers/{price}")
//    Call<OffersResponse> getOffers(@Path("price") String price,
//                                   @Query("page") int page);

    @GET("offer/paginatedResults")
    Call<OffersPaginatedResponse> getOffers(@Query("page") int page);

    @GET("home/discounts/{price}")
    Call<DiscountsResponse> getDiscounts(@Path("price") String price,
                                                  @Query("page") int page);

    @POST("auth/login")
    @FormUrlEncoded
    Call<UserResponseModel> userLogin(@Field("email") String email,
                                          @Field("password") String password);

    @POST("auth/register")
    @FormUrlEncoded
    Call<UserResponseModel> userRegister(@Field("name") String name,
                                         @Field("email") String email,
                                         @Field("phoneNo") String phone,
                                         @Field("address") String address,
                                         @Field("password") String password,
                                         @Field("passwordConfirmation") String passwordConfirmation);

    @GET("expo/paginatedResults")
    Call<ExposPaginatedResponse> getExpos(@Query("page") int page);

    @POST("comment/getCommentsCountByExpoId")
    @FormUrlEncoded
    Call<CommentsCountResponse> getCommentsCountByExpoId(@Field("expo") String expoId);

//    @POST("login")
//    @Headers({
//            "Content-Type: multipart/form-data"
//    })
//    @Multipart
//    Flowable<UserResponseModel> userLogin(@Part("username") RequestBody username,
//                                      @Part("password") RequestBody password);

//    @POST("login")
//    @Multipart
//    Flowable<UserResponseModel> userLogin(@Part("username") RequestBody username,
//                                          @Part("password") RequestBody password);

//    @POST("login")
//    @Multipart
//    Call<UserResponseModel> userLogin(@Part("username") RequestBody username,
//                                          @Part("password") RequestBody password);

//    @POST("login")
//    Call<UserResponseModel> userLogin(@Body MultipartBody body);

//    @POST("login")
//    @Headers({
//            "Content-Type: multipart/form-data"
//    })
//    Flowable<UserResponseModel> userLogin(@Body RequestBody body);


//    @POST("login")
//    Call<UserResponseModel> userLogin(@Body RequestBody body);

//    @POST("auth/restaurant/login")
//    @FormUrlEncoded
//    Flowable<RequestBody> restaurantLogin(@Field("email") String email,
//                                              @Field("password") String password);

}


