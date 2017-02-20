package org.neosoft.com.JHU.service;

import org.neosoft.com.JHU.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Neyomal on 2/18/2017.
 */

public interface APIService {
    @GET("/my_json")
    Call<List<User>> getUserDetails();
}