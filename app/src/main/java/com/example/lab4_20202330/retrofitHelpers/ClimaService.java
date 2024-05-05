package com.example.lab4_20202330.retrofitHelpers;

import com.example.lab4_20202330.entity.Clima;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClimaService {

    @GET("data/2.5/weather")
    Call<List<Clima>> getClima(
            @Query("lat") String latitud,
            @Query("lon") String longitud,
            @Query("appid") String apiKey
    );
}
