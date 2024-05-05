package com.example.lab4_20202330.entity;

import java.io.Serializable;

public class Clima implements Serializable {

    private static String lat_clima;
    private static String lon_clima;
    private static String viento;
    private static String nombre;
    private static String temperatura;
    private static String min;
    private static String max;


    public static String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getViento() {
        return viento;
    }

    public void setViento(String viento) {
        this.viento = viento;
    }

    public static String getLon_clima() {
        return lon_clima;
    }

    public void setLon_clima(String lon_clima) {
        this.lon_clima = lon_clima;
    }

    public static String getLat_clima() {
        return lat_clima;
    }

    public void setLat_clima(String lat_clima) {
        this.lat_clima = lat_clima;
    }

    public static String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public static String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
