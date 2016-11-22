package com.example.sergio.examenev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad1b extends AppCompatActivity {

    TextView nombre, provincia, sexo, conocimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1b);

        nombre = (TextView) findViewById(R.id.nombre2);
        provincia = (TextView) findViewById(R.id.provincia2);
        sexo = (TextView) findViewById(R.id.sexo2);
        conocimiento = (TextView) findViewById(R.id.conocimientos2);

        Bundle extras = getIntent().getExtras();
        nombre.setText("Nombre: " + extras.getString("nombre"));
        //FIXME arreglar spinner y descomentar
        //provincia.setText("Provincia: " + extras.getString("provincia"));
        sexo.setText("Sexo: " + extras.getString("sexo"));
        conocimiento.setText("Conocimiento: " + extras.getString("conocimientos"));

        Button ok = (Button) findViewById(R.id.btn_bien);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("resultado", "BIEN");
                setResult(RESULT_OK);
                finish();
            }
        });

        Button mal = (Button) findViewById(R.id.btn_mal);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("resultado", "MAL");
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
