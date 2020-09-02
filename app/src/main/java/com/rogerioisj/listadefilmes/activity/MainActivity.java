package com.rogerioisj.listadefilmes.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerioisj.listadefilmes.R;
import com.rogerioisj.listadefilmes.adapter.AdapterFilmes;
import com.rogerioisj.listadefilmes.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public List<Filme> filmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarFilmes();

        recyclerView = findViewById(R.id.recyclerFilmes);

        //Configurar Adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(filmes);

        //Configurar Recycler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterFilmes);
    }

    public void criarFilmes() {
        Filme filme = new Filme("Jogos Vorazes", "Ação", "2013");
        filmes.add(filme);

        filme = new Filme("Interstellar", "Ficção", "2015");
        filmes.add(filme);

        filme = new Filme("John Wick", "Ação", "2015");
        filmes.add(filme);

        filme = new Filme("John Wick Chapter II", "Ação", "2017");
        filmes.add(filme);

        filme = new Filme("John Wick Parabellum", "Ação", "2019");
        filmes.add(filme);

        filme = new Filme("Presságio", "Suspense", "2007");
        filmes.add(filme);

        filme = new Filme("Warcraft", "Fantasia", "2016");
        filmes.add(filme);

        filme = new Filme("O Senhor dos Anéis", "Fantasia", "2001");
        filmes.add(filme);
    }


}