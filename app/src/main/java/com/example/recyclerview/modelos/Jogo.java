package com.example.recyclerview.modelos;

public class Jogo {
    private int id;
    private String data;
    private String local;
    private String hora;
    private Placar placar;
    private Time mandante;
    private Time visitante;

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public String getHora() {
        return hora;
    }

    public Placar getPlacar() {
        return placar;
    }

    public Time getMandante() {
        return mandante;
    }

    public Time getVisitante() {
        return visitante;
    }
}
