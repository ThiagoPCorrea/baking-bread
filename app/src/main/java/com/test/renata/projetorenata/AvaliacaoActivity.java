package com.test.renata.projetorenata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AvaliacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_avaliacao);

        Button avaliar = findViewById(R.id.button_avaliar);
        avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AvaliacaoActivity.this,ComidaActivity.class);
                startActivity(i);
            }
        });
    }
}
