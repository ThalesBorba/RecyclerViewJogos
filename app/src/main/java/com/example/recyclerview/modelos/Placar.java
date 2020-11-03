package com.example.recyclerview.modelos;

import com.google.gson.annotations.SerializedName;

public class Placar {
    @SerializedName("gols_mandante")
    private int golsDoMandante;
    @SerializedName("gols_visitante")
    private int getGolsDoVisitante;

    public int getGolsDoMandante() {
        return golsDoMandante;
    }

    public int getGetGolsDoVisitante() {
        return getGolsDoVisitante;
    }

    }

