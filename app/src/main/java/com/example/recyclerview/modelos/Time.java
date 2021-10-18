package com.example.recyclerview.modelos;

import com.google.gson.annotations.SerializedName;

public class Time {
    private int id;
    private String nome;
    @SerializedName("logo")
    private String urlDaImagem;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getUrlDaImagem() {
        return urlDaImagem;
    }
    @Override
    public String toString() {
        return (String) urlDaImagem;
    }
}
