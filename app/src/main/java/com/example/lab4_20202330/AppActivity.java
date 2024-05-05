package com.example.lab4_20202330;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab4_20202330.adapter.ClimaAdapter;
import com.example.lab4_20202330.adapter.GeoLocationAdapter;
import com.example.lab4_20202330.databinding.ActivityAppBinding;
import com.example.lab4_20202330.entity.Clima;
import com.example.lab4_20202330.entity.GeoLocalizacion;
import com.example.lab4_20202330.retrofitHelpers.ClimaService;
import com.example.lab4_20202330.retrofitHelpers.GeoLocalizacionService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class AppActivity extends AppCompatActivity {

    ActivityAppBinding binding;

    private RecyclerView recyclerView;
    private GeoLocationAdapter adapter;
    private ClimaAdapter climaAdapter;

    private static final String BASE_URL = "http://api.openweathermap.org/";
    private static final String API_KEY = "8dd6fc3be19ceb8601c2c3e811c16cf1";
    private static final String API_KEY1 = "792edf06f1f5ebcaf43632b55d8b03fe";
    private boolean caso = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        replaceFragment(new GeolocaFragment());

        binding.bottomNavigation1.setOnItemSelectedListener(item -> {
            int menuItemId =  item.getItemId();
            if (menuItemId ==  R.id.geo) {
                replaceFragment(new GeolocaFragment());
                caso = true;
                return true;
            }
            else if (menuItemId ==  R.id.clima) {
                caso = false;
                replaceFragment(new ClimaFragment());
                return true;
            }
            return true;
        });

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("Hola", String.valueOf(caso));
        if(caso){
            String lugar = "Lima";
            obtenerGeoLocalizacion(lugar);
        }else {
            String latitud = "-12.0621065";
            String longitud = "-77.0365256";
            obtenerClima(latitud,longitud);
        }



    }

    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    public void obtenerClima(String latitud,String longitud){
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClimaService service1 = retrofit1.create(ClimaService.class);
        Call<List<Clima>> call1 = service1.getClima(latitud, longitud, API_KEY1);
        Log.d("API URL", "URL: " + call1.request().url().toString());

        call1.enqueue(new Callback<List<Clima>>() {
            @Override
            public void onResponse(Call<List<Clima>> call, Response<List<Clima>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Clima> climaList = response.body();
                    if (!climaList.isEmpty()) {
                        Log.d("danita","entre a clima is not empty");
                        /*
                        climaAdapter = new ClimaAdapter(AppActivity.this, climaList);
                        recyclerView.setAdapter(climaAdapter);
                        */
                    }
                } else {
                    Log.e("ClimaFragment", "Error al obtener datos del clima");
                }
            }

            @Override
            public void onFailure(Call<List<Clima>> call, Throwable t) {
                Log.e("API Error 2", "onFailure: " + t.getMessage());
            }
        });
    }

    public void obtenerGeoLocalizacion(String lugar){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GeoLocalizacionService service = retrofit.create(GeoLocalizacionService.class);

        Call<List<GeoLocalizacion>> call = service.getGeoLocation(lugar, 1, API_KEY);
        call.enqueue(new Callback<List<GeoLocalizacion>>() {
            @Override
            public void onResponse(Call<List<GeoLocalizacion>> call, Response<List<GeoLocalizacion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<GeoLocalizacion> geoLocations = response.body();
                    if (!geoLocations.isEmpty()) {
                        adapter = new GeoLocationAdapter(AppActivity.this, geoLocations);
                        recyclerView.setAdapter(adapter);
                    }
                } else {
                    Log.e("API Error", "Failed to get geolocation");
                }
            }

            @Override
            public void onFailure(Call<List<GeoLocalizacion>> call, Throwable t) {
                Log.e("API Error", "onFailure: " + t.getMessage());
            }
        });
    }

}