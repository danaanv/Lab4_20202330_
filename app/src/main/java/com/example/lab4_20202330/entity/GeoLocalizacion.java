package com.example.lab4_20202330.entity;

import java.io.Serializable;

public class GeoLocalizacion implements Serializable {

    private String nombre;
    private String lat;
    private String lon;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
