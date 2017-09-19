package com.example.usuario.ejercicioparceablemartes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.ejercicioparceablemartes.Main2Activity;
import com.example.usuario.ejercicioparceablemartes.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText name;
    private EditText surname;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.edtNom);
        surname=(EditText)findViewById(R.id.edtApe);
        age=(EditText)findViewById(R.id.edtEdad);
        final Button boton_siguiente= (Button)findViewById(R.id.siguiente);
        boton_siguiente.setOnClickListener(this);





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this.getApplicationContext(),data.getStringExtra("respuesta"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, Main2Activity.class);
        rellenarDatos(intent);
        startActivityForResult(intent,0);

    }

    private void rellenarDatos(Intent intent){
        String nombre=name.getText().toString();
        String apellido=surname.getText().toString();
        Integer edad=Integer.parseInt(this.age.getText().toString());

        Persona p=new Persona(nombre,apellido,edad);
        intent.putExtra("persona",p);
        /*intent.putExtra("name", nombre);
        intent.putExtra("surname", apellido);
        intent.putExtra("age", edad);*/

    }

}
