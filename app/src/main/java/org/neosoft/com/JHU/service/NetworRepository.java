package org.neosoft.com.JHU.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Creating network repository using API
 */

public class NetworRepository {
    private static NetworRepository sRepository;
    private APIService mApiService;

    public static final String BASE_URL = "https://eguru.000webhostapp.com/";

    private NetworRepository(){
        mApiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class);
    }

    public  static APIService getApiService(){
        if(sRepository == null){
            sRepository = new NetworRepository();
        }

        return sRepository.mApiService;
    }
}
