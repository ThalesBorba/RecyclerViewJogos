package com.example.recyclerview.uiActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.R;
import com.example.recyclerview.modelos.Jogo;
import com.example.recyclerview.utilitarios.JogoResponse;
import com.example.recyclerview.utilitarios.RetrofitCall;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitCall.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitCall chamada = retrofit.create(RetrofitCall.class);
        Call<JogoResponse> requestDeJogos = chamada.getJogos();
        requestDeJogos.enqueue(new Callback<JogoResponse>() {
            @Override
            public void onResponse(Call<JogoResponse> call, Response<JogoResponse> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                JogoResponse jogoResponse = response.body();
            }

            @Override
            public void onFailure(Call<JogoResponse> call, Throwable t) {

            }
        });
    }
}