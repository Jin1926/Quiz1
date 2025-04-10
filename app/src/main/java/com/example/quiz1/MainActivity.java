package com.example.quiz1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_name;
    EditText edt_age;
    Button btn_send;
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(dataUserCache,modo_private);
        editor = sharedPreferences.edit();
        Spinner spinner = findViewById(R.id.spinner_main);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Select item: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> categoria = new ArrayList<>();
        categoria.add("Deporte");
        categoria.add("Musica");
        categoria.add("Cine");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

        edt_age = findViewById(R.id.edt_age);
        edt_name = findViewById(R.id.edt_name);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!edt_age.getText().toString().isEmpty())&&(!edt_name.getText().toString().isEmpty())){
                    editor.putString("Nombre", edt_name.getText().toString());
                    editor.putString("Edad", edt_age.getText().toString());
                    editor.putString("Categoria", spinner.getSelectedItem().toString());
                    editor.commit();
                    Intent i = new Intent(MainActivity.this,splash.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this,"Favor, llenar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}