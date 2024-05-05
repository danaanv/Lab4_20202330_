package com.example.lab4_20202330.retrofitHelpers;

import com.example.lab4_20202330.entity.GeoLocalizacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeoLocalizacionService {

    @GET("geo/1.0/direct")
    Call<List<GeoLocalizacion>> getGeoLocation(
            @Query("q") String cityName,
            @Query("limit") int limit,
            @Query("appid") String apiKey
    );
}
