package com.example.lab4_20202330;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonIngresar = findViewById(R.id.buttonIngresar);

        if (!NetworkUtils.isNetworkAvailable(this)) {
            showNetworkDialog();
            ingresar = false;
            buttonIngresar.setEnabled(false);
        }else{
            ingresar = true;
            buttonIngresar.setEnabled(true);
        }

        buttonIngresar.setOnClickListener(v->{
            if(ingresar){
                Intent intent = new Intent(MainActivity.this,AppActivity.class);
                startActivity(intent);
            }
        });


    }

    private void showNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No hay conexión a Internet");
        builder.setMessage("No se detectó una conexión a Internet. ¿Desea abrir la configuración de red?");

        builder.setPositiveButton("Configuración", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });

        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showConnectionToast() {
        Toast.makeText(this, "¡Hay conexión!", Toast.LENGTH_SHORT).show();
    }

    // Método para verificar la conexión y mostrar el Toast si hay conexión
    private void checkConnectionAndShowToast() {
        if (NetworkUtils.isNetworkAvailable(this)) {
            showConnectionToast();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Verificar la conexión y mostrar el Toast al reanudar la actividad
        checkConnectionAndShowToast();
    }
}