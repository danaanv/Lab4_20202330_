package com.example.lab4_20202330.retrofitHelpers;

import com.example.lab4_20202330.entity.GeoLocalizacionDto;

import retrofit2.Call;
import retrofit2.http.GET;

public class GeoLocalizacionService {

    @GET("/")
    Call<GeoLocalizacionDto> getList();
}
