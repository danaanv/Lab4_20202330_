package com.example.lab4_20202330;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab4_20202330.databinding.ActivityAppBinding;


public class AppActivity extends AppCompatActivity {

    ActivityAppBinding binding;

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
                return true;
            }
            else if (menuItemId ==  R.id.clima) {
                replaceFragment(new ClimaFragment());
                return true;
            }
            return true;
        });




    }

    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();

    }
}