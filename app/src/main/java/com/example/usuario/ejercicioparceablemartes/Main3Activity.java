package com.example.usuario.ejercicioparceablemartes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        persona = getIntent().getParcelableExtra("persona2");
        TextView textView= (TextView)findViewById(R.id.textView7);
        textView.setText("Nombre: "+ persona.getNombre()+ " calle: "+ persona.getDireccion().getCalle());
        //TextView display2 = (TextView) findViewById(R.id.textView10);
        //display2.setText("direccion: "+ persona.getDireccion().getCalle());

    }

    @Override
    public void onClick(View v) {

    }
}
