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

public class JogoAdapter extends RecyclerView.Adapter<JogoAdapter.JogoViewHolder> {

        private Context jogosContext;
        private ArrayList<Jogo> jogoArrayList;

        public JogoAdapter(Context context, ArrayList<Jogo> movieArrayList) {
            jogosContext = context;
            jogoArrayList = movieArrayList;
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

            String logoMandantePath = jogoAtual.getMandante().getUrlDaImagem();
            String logoVisitantePath = jogoAtual.getVisitante().getUrlDaImagem();
            String dataHoraPath = jogoAtual.getData() + " " + jogoAtual.getLocal() + " " +
                    jogoAtual.getHora();
            String placarPath;
            if (jogoAtual.getPlacar() == null) {
                placarPath = " X ";
            } else {
                placarPath = jogoAtual.getPlacar().getConcatenado();
            }
            holder.dataHora.setText(dataHoraPath.toUpperCase());
            holder.placar.setText(placarPath);
            Picasso.get().load(logoMandantePath).fit().centerInside().into(holder.logoMandante);
            Picasso.get().load(logoVisitantePath).fit().centerInside().into(holder.logoVisitante);
        }

        @Override
        public int getItemCount() {
            return jogoArrayList.size();
        }

        public class JogoViewHolder extends RecyclerView.ViewHolder {

            public ImageView logoMandante;
            public ImageView logoVisitante;
            public TextView dataHora;
            public TextView placar;
            public JogoViewHolder(@NonNull View itemView) {
                super(itemView);

                logoMandante = itemView.findViewById(R.id.logoMandante);
                logoVisitante = itemView.findViewById(R.id.logoVisitante);
                dataHora = itemView.findViewById(R.id.dataHora);
                placar = itemView.findViewById(R.id.placar);
            }
        }
    }