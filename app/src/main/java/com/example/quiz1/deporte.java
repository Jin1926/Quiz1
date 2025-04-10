package com.example.quiz1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class deporte extends AppCompatActivity {
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    Button btn_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deporte);
        btn_out = findViewById(R.id.btn_out);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(dataUserCache,modo_private);
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("Nombre");
                editor.remove("Edad");
                editor.remove("Categoria");
                editor.commit();
                Intent i = new Intent(deporte.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}