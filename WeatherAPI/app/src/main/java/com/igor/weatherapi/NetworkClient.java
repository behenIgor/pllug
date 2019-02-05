package com.igor.weatherapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    public static final String BASE_URL = "http://api.openweathermap.org";
    public static Retrofit retrofit = null;;

    public static Retrofit getRetrofitClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


        }
        return retrofit;
    }
}





