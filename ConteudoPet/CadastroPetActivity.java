package com.example.petpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CadastroPetActivity extends AppCompatActivity {

    List<Pet> listaPet;
    String[] racas = {"Shitzu","Pastor Alemão","Poodle","Pug","yorkshire","srd","Outros"};
    BancoDadosPet bancoDadosPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle(R.string.cad_pet);
        bancoDadosPet = new BancoDadosPet(this);

        listaPet = (List<Pet>) getIntent().
        getSerializableExtra("lista_pet");

        Spinner spinner = findViewById(R.id.spinnerRaca);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, racas);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

    }

    public void salvarPet(View view){

        EditText nome = findViewById(R.id.editTextNomeDog);
        EditText peso = findViewById(R.id.editTextPesoDog);
        Spinner spinner = findViewById(R.id.spinnerRaca);

        String nomeString = nome.getText().toString();
        String pesoString = peso.getText().toString();
        String raca = (String) spinner.getSelectedItem();

        if(nomeString.equals("") || pesoString.equals("")){
            Toast.makeText(this,"digite algum valor", Toast.LENGTH_LONG).show();
            return;
        }
        if(nomeString.length() <= 2){
            Toast.makeText(this,"necessário mais de 3 char para nome", Toast.LENGTH_LONG).show();
            return;
        }

        Pet pet = new Pet();
        pet.nome = nomeString;
        pet.peso = Double.parseDouble(pesoString);
        pet.raca = raca;

        //listaPet.add(pet);
        bancoDadosPet.adicionarPet(pet);
        Toast.makeText(this,"sucesso no cadastro do pet", Toast.LENGTH_LONG).show();
        nome.setText("");
        peso.setText("");


        for(Pet cachorro : listaPet) {
            Log.d("PET", cachorro.nome);
            Log.d("PET", cachorro.peso + "");
            Log.d("PET", "---------------");
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista_pet", (Serializable) listaPet);
        Intent retorno = new Intent();
        retorno.putExtras(bundle);
        setResult(2,retorno);
        finish(); // active fechada
    }
}