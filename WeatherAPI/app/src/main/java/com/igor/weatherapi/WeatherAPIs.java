package com.igor.weatherapi;

import com.igor.weatherapi.models.WeatherApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPIs {

    @GET("/data/2.5/weather")
    Call<WeatherApi> getWeatherByCity(@Query("q") String city,
                                      @Query("appid") String apiKey);

}



