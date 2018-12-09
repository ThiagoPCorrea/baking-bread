package com.test.renata.projetorenata;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton back = findViewById(R.id.filter_back_arrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FilterActivity.this,Main.class);
                startActivity(i);
            }
        });
        Button confirm = findViewById(R.id.button_filter_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FilterActivity.this,Main.class);
                startActivity(i);
            }
        });
        Button clean = findViewById(R.id.button_filter_limparFiltros);
        final CheckBox doce = findViewById(R.id.checkBox_filter_doce);
        final CheckBox salgado = findViewById(R.id.checkBox_filter_salgado);
        final CheckBox massas = findViewById(R.id.checkBox_filter_massas);
        final CheckBox sucos = findViewById(R.id.checkBox_filter_sucos);
        final CheckBox lanches = findViewById(R.id.checkBox_filter_lanches);
        final CheckBox vegetariana = findViewById(R.id.checkBox_filter_vegetariana);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doce.setChecked(false);
                salgado.setChecked(false);
                massas.setChecked(false);
                sucos.setChecked(false);
                lanches.setChecked(false);
                vegetariana.setChecked(false);
            }
        });

    }

}
