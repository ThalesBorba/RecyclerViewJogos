package com.example.recyclerview.utilitarios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.modelos.Jogo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class JogoAdapter extends RecyclerView.Adapter<JogoAdapter.JogoViewHolder> {

        private final Context jogosContext;
        private final ArrayList<Jogo> jogoArrayList;

        public JogoAdapter(Context context, ArrayList<Jogo> listaDeJogos) {
            jogosContext = context;
            jogoArrayList = listaDeJogos;
        }

        @NonNull
        @Override
        public JogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(jogosContext).inflate(R.layout.activity_cardview,
                    parent, false);
            return new JogoViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull JogoViewHolder holder, int position) {
            Jogo jogoAtual = jogoArrayList.get(position);
            adaptaImagens(holder, jogoAtual);
            adaptaDataHoraLocal(holder, jogoAtual);
            adaptaPlacar(holder, jogoAtual);
            configuraSeparator(holder, position);
        }

    private void configuraSeparator(@NonNull JogoViewHolder holder, int position) {
        if (position == jogoArrayList.size() -1) {
            holder.separador.setVisibility(View.GONE);
        }
    }

    private void adaptaDataHoraLocal(@NonNull JogoViewHolder holder, Jogo jogoAtual) {
        String dataHoraPath = jogoAtual.getData() + " " + jogoAtual.getLocal() + " " +
                jogoAtual.getHora();
        holder.dataHora.setText(dataHoraPath.toUpperCase());
    }

    private void adaptaImagens(@NonNull JogoViewHolder holder, Jogo jogoAtual) {
        String logoMandantePath = jogoAtual.getMandante().getUrlDaImagem();
        String logoVisitantePath = jogoAtual.getVisitante().getUrlDaImagem();
        Picasso.get().load(logoMandantePath).fit().centerInside().into(holder.logoMandante);
        Picasso.get().load(logoVisitantePath).fit().centerInside().into(holder.logoVisitante);
    }

    private void adaptaPlacar(@NonNull JogoViewHolder holder, Jogo jogoAtual) {
        int golsMandantePath;
        int golsVisitantePath;
        if (jogoAtual.getPlacar() != null) {
            golsMandantePath = jogoAtual.getPlacar().getGolsDoMandante();
            golsVisitantePath = jogoAtual.getPlacar().getGetGolsDoVisitante();
            holder.golsMandante.setText(String.valueOf(golsMandantePath));
            holder.golsVisitante.setText(String.valueOf(golsVisitantePath));
        }
    }

    @Override
        public int getItemCount() {
            return jogoArrayList.size();
        }

        public static class JogoViewHolder extends RecyclerView.ViewHolder {

            public ImageView logoMandante;
            public ImageView logoVisitante;
            public TextView dataHora;
            public TextView golsMandante;
            public TextView golsVisitante;
            public View separador;
            public JogoViewHolder(@NonNull View itemView) {
                super(itemView);
                vinculaVariaveis(itemView);
            }

            private void vinculaVariaveis(@NonNull View itemView) {
                logoMandante = itemView.findViewById(R.id.logoMandante);
                logoVisitante = itemView.findViewById(R.id.logoVisitante);
                dataHora = itemView.findViewById(R.id.dataHora);
                golsMandante = itemView.findViewById(R.id.golsMandante);
                golsVisitante = itemView.findViewById(R.id.golsVisitante);
                separador = itemView.findViewById(R.id.separador);
            }
        }
    }