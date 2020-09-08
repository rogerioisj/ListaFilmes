package com.rogerioisj.listadefilmes.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerioisj.listadefilmes.Others.RecyclerItemClickListener;
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
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = filmes.get(position);
                        Toast.makeText(MainActivity.this, "Click simples em: " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = filmes.get(position);
                        Toast.makeText(MainActivity.this, "Click longo em: " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
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