package com.example.diegomunoz.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    Button jugar;
    Button acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jugar = (Button)findViewById(R.id.btnJugar);
        acerca = (Button)findViewById(R.id.btnInfo);
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoForm = new Intent(MainActivity.this,Jugar.class);
                startActivity(nuevoForm);
            }
        });

        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoForm = new Intent(MainActivity.this,Acerca.class);
                startActivity(nuevoForm);
            }
        });
    }
}
