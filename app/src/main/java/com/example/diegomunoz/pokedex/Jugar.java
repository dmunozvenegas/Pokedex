package com.example.diegomunoz.pokedex;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by diegomunoz on 26-01-16.
 */
public class Jugar extends AppCompatActivity {

    private String[] nombre_pokemon = {"bolbasaur","ivysaur","venusaur","charmander","charmeleon","charizard","squirtle","wartortle","blastoise",
                                        "caterpie","metapod","butterfree","weedle","kakuna","beedrill","pidgey","pidgeotto","pidgeot","rattata",
                                        "raticate","spearow","fearow","ekans","arbok","pikachu","raichu","sandshrew","sandslash"};
    private String[] sombra_pokemon = {"s_bolbasaur","s_ivysaur","s_venusaur","s_charmander","s_charmeleon","s_charizard","s_squirtle","s_wartortle",
                                        "s_blastoise","s_caterpie","s_metapod","s_butterfree","s_weedle","s_kakuna","s_beedrill","s_pidgey",
                                        "s_pidgeotto","s_pidgeot","s_rattata","s_raticate","s_spearow","s_fearow","s_ekans","s_arbok","s_pikachu",
                                        "s_raichu","s_sandshrew","s_sandslash"};
    private int intentos = 3;
    private Button aceptar;
    private ImageView imagen_pokemon;
    private EditText usuario_pokemon;
    private TextView mensaje_intentos;
    private TextView mensaje_cuenta;
    private int numero_generado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        aceptar = (Button)findViewById(R.id.btnAceptar);
        imagen_pokemon = (ImageView)findViewById(R.id.ivPokemon);
        mensaje_intentos = (TextView)findViewById(R.id.lblIntentos);
        mensaje_cuenta = (TextView)findViewById(R.id.lblCuenta);
        usuario_pokemon = (EditText)findViewById(R.id.etPokemon);


        numero_generado = generarAleatorio();
        establecer_sombra(numero_generado);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = usuario_pokemon.getText().toString().toLowerCase();
                if (nombre.equals(nombre_pokemon[numero_generado])) {
                    establecer_pokemon(numero_generado);
                    esperar();
                }else{
                    Toast.makeText(getApplicationContext(), "No es el Pokemon !!",Toast.LENGTH_SHORT).show();
                    intentos = intentos - 1;
                    mensaje_intentos.setText("Tienes " + intentos + " intentos.");
                }

                if (intentos == 0) {
                    finish();
                }
            }
        });
    }


    //Timer-Contador de espera
    public void esperar() {
        new CountDownTimer(5000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                mensaje_cuenta.setText("Generando en " + (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                numero_generado = generarAleatorio();
                establecer_sombra(numero_generado);
                mensaje_cuenta.setText("");
                usuario_pokemon.setText("");
            }
        }.start();
    }

    private  void establecer_pokemon (int numero) {
        int resId = getResources().getIdentifier(nombre_pokemon[numero], "drawable", getPackageName());
        imagen_pokemon.setImageResource(resId);
    }

    private  void establecer_sombra (int numero) {
        int resId = getResources().getIdentifier(sombra_pokemon[numero], "drawable", getPackageName());
        imagen_pokemon.setImageResource(resId);
    }

    private int generarAleatorio() {
        return (int)(Math.random()*nombre_pokemon.length);
    }
}
