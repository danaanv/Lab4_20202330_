package com.example.lab4_20202330.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClimaDto {

    @SerializedName("main")
    private List<Clima> lista;

    public List<Clima> getLista() {
        return lista;
    }

    public void setLista(List<Clima> lista) {
        this.lista = lista;
    }

}
