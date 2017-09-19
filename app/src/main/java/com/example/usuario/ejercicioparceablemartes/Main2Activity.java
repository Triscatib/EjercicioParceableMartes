package com.example.usuario.ejercicioparceablemartes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText calle;
    private EditText numero;
    private EditText cp;
    private EditText localidad;
    Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // final Button boton_salida = (Button) findViewById(R.id.btnSalir);
        final Button boton_volver = (Button) findViewById(R.id.btnVolver);
        calle= (EditText)findViewById(R.id.edtCalle);
        numero=(EditText)findViewById(R.id.editNumero);
        cp=(EditText)findViewById(R.id.edtcp);
        localidad=(EditText)findViewById(R.id.edtLocalidad);

        boton_volver.setOnClickListener(this);

        final Button boton_siguiente= (Button)findViewById(R.id.sigue);
        boton_siguiente.setOnClickListener(this);
        TextView display = (TextView) findViewById(R.id.textViewInforme);

        persona = getIntent().getParcelableExtra("persona");
        display.setText(persona.getNombre() + " " + persona.getApellido() + " " + persona.getEdad());
    }

        /*String nombre=getIntent().getStringExtra("name");
        String apellido=getIntent().getStringExtra("surname");
        Integer edad=getIntent().getIntExtra("age",0);




        display.setText(nombre+ " " + apellido + " " +  edad);*/


        private void rellenarDireccion(Intent intent){
            String call=calle.getText().toString();
            Integer num=Integer.parseInt(this.numero.getText().toString());
            Integer codigo=Integer.parseInt(this.cp.getText().toString());
            String local=localidad.getText().toString();
            Direccion d=new Direccion(call,num,codigo,local);
            //persona.setDireccion(d);
            //TextView display2 = (TextView) findViewById(R.id.textView9);
            //display2.setText("direccion: "+ d.getCalle());

            Persona p2 = new Persona(persona, d);
            intent.putExtra("persona2",p2);


        /*intent.putExtra("name", nombre);
        intent.putExtra("surname", apellido);
        intent.putExtra("age", edad);*/

        }












    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSalir:
                finish();
                break;
            case R.id.btnVolver:
                Intent intent= new Intent();

                intent.putExtra("respuesta", "esto es resp");
                setResult(RESULT_OK,intent);
                finish();
                //setResult(100,intent);
                break;
            case R.id.sigue:
                Intent i=new Intent(this, Main3Activity.class);
                rellenarDireccion(i);
                startActivityForResult(i,0);
                break;

        }
    }
}
