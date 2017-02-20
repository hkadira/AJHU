package org.neosoft.com.JHU.data.api;


//import com.google.gson.annotations.SerializedName;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Request using gson implementation
 */

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/insert.php")
    public void insertUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<Response> callback);
}
