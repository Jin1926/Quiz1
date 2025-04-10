package com.example.quiz1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash extends AppCompatActivity {
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        
        direccion();
    }

    private void direccion() {
        categoria = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("Categoria","0");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(splash.this, deporte.class);
                //startActivity(i);
               switch (categoria){
                   case "Deporte":
                       Intent i = new Intent(splash.this, deporte.class);
                       startActivity(i);
                       break;
                   case "Musica":
                       Intent j = new Intent(splash.this, musica.class);
                       startActivity(j);
                       break;
                   case "Cine":
                       Intent k = new Intent(splash.this, cine.class);
                       startActivity(k);
                       break;
               }
            }
        }, 2000);
    }
}