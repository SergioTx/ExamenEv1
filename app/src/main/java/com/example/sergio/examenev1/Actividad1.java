package com.example.sergio.examenev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Actividad1 extends AppCompatActivity {

    private Spinner spinner;
    private TextView txt_num1, txt_num2, txt_candidatos;
    private EditText txt_nombre, txt_resultado;
    private Button evaluar;
    private CheckBox chk_php, chk_java, chk_html, chk_css;
    private RadioGroup radios;


    private int num1, num2, resultado, intentos = 3, candidatos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txt_candidatos = (TextView) findViewById(R.id.txt_candidatos);
        txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        txt_resultado = (EditText) findViewById(R.id.txt_resultado);
        chk_css = (CheckBox) findViewById(R.id.chk_css);
        chk_html = (CheckBox) findViewById(R.id.chk_html);
        chk_java = (CheckBox) findViewById(R.id.chk_java);
        chk_php = (CheckBox) findViewById(R.id.chk_php);
        radios = (RadioGroup) findViewById(R.id.radio_group);

        //cargar el spinner
        spinner = (Spinner) findViewById(R.id.spinner_provincias);
        final String[] PROVINCIAS = {"Alava", "Vizcaya", "Guipuzcoa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,PROVINCIAS);
        spinner.setAdapter(adapter);

        //suma
        num1 = ((int) (Math.random() * 100)) + 1;
        num2 = ((int) (Math.random() * 100)) + 1;
        resultado = num1 + num2;
        txt_num1 = (TextView) findViewById(R.id.txt_num1);
        txt_num2 = (TextView) findViewById(R.id.txt_num2);
        txt_num1.setText(String.valueOf(num1));
        txt_num2.setText(String.valueOf(num2));

        //evaluar
        evaluar = (Button) findViewById(R.id.btn_evaluar);

        evaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Onclick","Entra en onclick");
                if (txt_nombre.getText().toString().equals("") || txt_resultado.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Faltan datos obligatorio", Toast.LENGTH_SHORT);
                    Log.i("Onclick","CAMPOS VACIOS");
                } else {
                    //resultado mal
                    Log.i("SUMA",txt_resultado.getText().toString());
                    Log.i("SUMA",String.valueOf(resultado));
                    if (!txt_resultado.getText().toString().equals(String.valueOf(resultado))) {
                        Log.i("Onclick","ENTRA EN RESULTADO MAL");
                        Toast.makeText(getApplicationContext(), "Intentos restantes: " + --intentos, Toast.LENGTH_SHORT);
                    } else {
                        Log.i("Onclick","ENTRA EN RESULTADO BIEN");
                        intentos = 3; //resetear la variable

                        String conocimientos = "";
                        conocimientos += chk_css.isChecked() ? "css, " : "";
                        conocimientos += chk_java.isChecked() ? "java, " : "";
                        conocimientos += chk_php.isChecked() ? "php, " : "";
                        conocimientos += chk_html.isChecked() ? "html" : "";

                        String sexo = "";
                        int idRadioSelec = radios.getCheckedRadioButtonId();
                        if (idRadioSelec == R.id.radio_fem) {
                            sexo = "Femenino";
                        } else {
                            sexo = "Masculino";
                        }

                        Intent i = new Intent(Actividad1.this, Actividad1b.class);
                        i.putExtra("nombre", txt_nombre.getText().toString());
                        i.putExtra("provincia", spinner.getSelectedItem().toString());
                        i.putExtra("conocimientos", conocimientos);
                        i.putExtra("sexo", sexo);
                        startActivityForResult(i, 137);
                    }
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {

        if (requestCode == 137 && resultCode == RESULT_OK) {
            Log.i("RESULT","Entra en activityResult");
            txt_candidatos.setText("Candidatos: " + ++candidatos);
            if (candidatos >= 4) {
                evaluar.setText("SALIR");
                evaluar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
            }
        }
    }
}
