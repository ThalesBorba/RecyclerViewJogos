package com.example.recyclerview.utilitarios;

import com.example.recyclerview.modelos.Jogo;

import java.util.ArrayList;

public class JogoResponse {

    private ArrayList<Jogo> jogos;

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    @Override
    public String toString() {
        return jogos.toString();
    }
}
