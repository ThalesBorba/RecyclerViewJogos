package com.example.recyclerview.uiActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.modelos.Jogo;
import com.example.recyclerview.utilitarios.JogoResponse;
import com.example.recyclerview.utilitarios.JogoAdapter;
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
        setContentView(R.layout.activity_recyclerview);

        RecyclerView jogosRecyclerView = findViewById(R.id.lista_notas_recyclerview);
        Call<JogoResponse> requestDeJogos = jogosRecebidosDoServidor();
        aplicaRespostaAoView(jogosRecyclerView, requestDeJogos);

    }

    private void aplicaRespostaAoView(RecyclerView jogosRecyclerView, Call<JogoResponse> requestDeJogos) {
        requestDeJogos.enqueue(new Callback<JogoResponse>() {
            @Override
            public void onResponse(Call<JogoResponse> call, Response<JogoResponse> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<Jogo> jogos = getJogoArrayList(response);
                criaAdapter(jogos, jogosRecyclerView);

            }

            @Override
            public void onFailure(Call<JogoResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void criaAdapter(ArrayList<Jogo> jogos, RecyclerView jogosRecyclerView) {
        JogoAdapter jogosAdapter = new
                JogoAdapter(MainActivity.this, jogos);
        jogosRecyclerView.setAdapter(jogosAdapter);
    }

    private ArrayList<Jogo> getJogoArrayList(Response<JogoResponse> response) {
        JogoResponse jogoResponse = response.body();
        return jogoResponse.getJogos();
    }

    private Call<JogoResponse> jogosRecebidosDoServidor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitCall.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitCall chamada = retrofit.create(RetrofitCall.class);
        return chamada.getJogos();
    }
}