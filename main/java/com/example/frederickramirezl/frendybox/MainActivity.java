package com.example.frederickramirezl.frendybox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Checkable;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void submitOrder(View view){
       createOrderSummary();
   }

    public void createOrderSummary(){

        EditText NameField = (EditText) findViewById(R.id.Nombre);
        String nombre = NameField.getText().toString();

        String name = "Nombre: " + nombre;

        String basic = "No";
        String Inter = "No";
        String Prem = "No";

        CheckBox Basico = (CheckBox) findViewById(R.id.basico);
        boolean esBasico = Basico.isChecked();
        if(Basico.isChecked() == true){
            basic = "Si";
        }else {
            basic = "No";
        }
        CheckBox Intermedio = (CheckBox) findViewById(R.id.intermedio);
        boolean esIntermedio = Intermedio.isChecked();
        if(Intermedio.isChecked() == true){
            Inter = "Si";
        }else{
            Inter = "No";
        }
        CheckBox Premium = (CheckBox) findViewById(R.id.premium);
        boolean esPremium = Premium.isChecked();
        if(Premium.isChecked() == true){
            Prem = "Si";
        }else{
            Prem = "No";
        }

        String chequeado1 = "\n" + "Es basico? " + basic + "\n";
        String chequeado2 = "\n" + "Es intermedio? " + Inter + "\n";
        String chequeado3 = "\n" + "Es premium? " + Prem + "\n";

        String Message = (name + chequeado1 + chequeado2 + chequeado3 + "\n" +
                " Gracias por preferirnos, su mascota esta en manos expertas!");

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT, "Orden lista para: " + nombre);
        intent.putExtra(intent.EXTRA_TEXT, Message );
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);

        }

    }



    public void PremiumPack(View view){
        Intent i = new Intent(this, PlanPremium.class );
        startActivity(i);
    }
    public void IntermedioPack(View view){
        Intent i = new Intent(this, PlanIntermedio.class );
        startActivity(i);
    }

    public void BasicoPack(View view){
        Intent i = new Intent(this, PlanBasico.class );
        startActivity(i);
    }

}
