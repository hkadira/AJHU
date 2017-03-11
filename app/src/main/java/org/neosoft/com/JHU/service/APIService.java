package org.neosoft.com.JHU.service;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Neyomal on 2/18/2017.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("/insert.php")
    Call<String> registerUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("email") String email,
            @Field("address") String address,
            @Field("district") String district);

    @FormUrlEncoded
    @POST("/login.php")
    Call<String> loginUser(
            @Field("username") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("/update.php")
    Call<String> resetPassword(
            @Field("username") String username,
            @Field("password") String password);

}