package com.test.renata.projetorenata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import circList.CircularLinkedList;
import elementos.Receita;

public class ComidaActivity extends AppCompatActivity {

    private static CircularLinkedList<Receita> receita;


    public static void setReceita(CircularLinkedList<Receita> r){
        receita = r;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComidaActivity.this,AvaliacaoActivity.class);
                startActivity(i);
            }
        });
        ImageView comida = findViewById(R.id.comida_image);
        TextView textIngredientes = findViewById(R.id.comida_ingrediente);
        TextView textPreparo = findViewById(R.id.comida_preparo);
        textIngredientes.setText("");
        textPreparo.setText("");
        comida.setImageResource(receita.element().getImagem());
        textIngredientes.setText(receita.element().getAllIngredientes());
        textPreparo.setText(receita.element().getModoPrep());

    }
}
