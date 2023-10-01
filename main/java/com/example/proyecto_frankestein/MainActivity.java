package com.example.proyecto_frankestein;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    private Button btn17, btn19, btn20;
    private RadioButton rb1;
    private RadioButton rb2;
    int contador;
    private ProgressBar pb1;
    private CheckBox cb1, cb2;
    private RatingBar rbar1;
    private ToggleButton tg1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        btn17 = (Button) findViewById(R.id.btn17);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        pb1 = (ProgressBar) findViewById(R.id.pb1);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 =(CheckBox) findViewById(R.id.cb2);
        btn19 = (Button)findViewById(R.id.btn19);
        btn20 = (Button) findViewById(R.id.btn20);
        rbar1 = (RatingBar) findViewById(R.id.rbar1);
        tg1 = (ToggleButton) findViewById(R.id.tg1);
        capturarRUT();
        comprobrarRB1();
        comprobrarRB2();
        prog();
        cambiaEstado();
    }
    private void capturarRUT(){
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "El RUT esta vacio!!", Toast.LENGTH_LONG).show();
                }else{
                    int id = Integer.parseInt(edt1.getText().toString());
                    Toast.makeText(MainActivity.this, "El RUT es: "+id, Toast.LENGTH_LONG).show();
                }
            }

        });
    }
    public void comprobrarRB1(){
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb1.getText().toString();
                Toast.makeText(MainActivity.this, "RadioButton seleccionado es: "+tipo, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void comprobrarRB2(){
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb2.getText().toString();
                Toast.makeText(MainActivity.this, "RadioButton seleccionado es: "+tipo, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void mostrarToast(View v){
        Toast.makeText(MainActivity.this, "Nuevo Creado", Toast.LENGTH_LONG).show();

    }
    public void mostrarAlertDialog(View v){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle("Ok");
        b.setMessage("Esto es un AlertDialog");
        b.show();
    }
    public void prog(){
        final Timer t = new Timer();
        TimerTask tt = new TimerTask(){
            @Override
            public void run(){
                contador++;
                pb1.setProgress(contador);
                if (contador==100)
                    t.cancel();
            }
        };
        t.schedule(tt,0,100);

    }
    public void comprobarCheckbox(View v){
        String comprobarCB1 = "";
        String comprobarCB2 = "";
        String etiqueta = "";
        if(cb1.isChecked()==true)
            comprobarCB1 = cb1.getText().toString();
        if(cb2.isChecked()==true)
            comprobarCB2 = cb2.getText().toString();
        if (comprobarCB1=="" && comprobarCB2=="")
        {
            Toast.makeText(MainActivity.this,"Usted no a seleccionado ninguna opcion!!", Toast.LENGTH_LONG ).show();
        }else{
            etiqueta = (comprobarCB1+" "+comprobarCB2);
           Toast.makeText(MainActivity.this, "Las opciones seleccionados son: "+etiqueta, Toast.LENGTH_LONG).show();
        }
    }
    public void siguiente (View v){
        Intent sig = new  Intent(this,MainActivity2.class);
        startActivity(sig);
    }
    public void CuantasEstrellas (View v){
        Toast.makeText(MainActivity.this, "UJsted a otorgado: "+rbar1.getRating()+"estrellas!!!", Toast.LENGTH_LONG).show();
    }
    public void cambiaEstado(){
        tg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tg1.isChecked()){
                    edt1.setEnabled(true);
                    btn17.setEnabled(true);
                }else {
                    edt1.setEnabled(false);
                    btn17.setEnabled(false);
                }
            }
        });
    }
}