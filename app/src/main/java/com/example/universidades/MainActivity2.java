package com.example.universidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnAtras = findViewById(R.id.atras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Con los 2 destroy parece que va a colapsar la aplicacion pero la reinicia
//                onDestroy();
//                onDestroy();

                //Con el finish no hace bien la segunda llamada  ala API pero cierra la aplicación
                finish();

            }
        });
    }
}