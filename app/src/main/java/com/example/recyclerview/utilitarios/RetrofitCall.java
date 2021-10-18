package com.example.recyclerview.utilitarios;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitCall {

    public static final String urlBase = "https://private-f97c07-brasileirao2020.apiary-mock.com/";

    @GET("rodada/1")
    Call<JogoResponse> getJogos();
}
