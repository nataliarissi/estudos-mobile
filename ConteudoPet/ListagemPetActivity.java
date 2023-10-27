package com.example.petpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ListagemPetActivity extends AppCompatActivity {

    List<Pet> listaPet;
    BancoDadosPet bancoDadosPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle("Listagem PET");
        bancoDadosPet = new BancoDadosPet(this);

        listaPet = bancoDadosPet.listarPets();

        String[] nomesPet = new String[listaPet.size()];
        for(int i=0; i < listaPet.size(); i++){
            nomesPet[i] = "Nome: " + listaPet.get(i).nome
                    + " - Peso:" + listaPet.get(i).peso
                    + " - Raça: " + listaPet.get(i).raca;
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomesPet);

        ListView listaview = findViewById(R.id.listview);
        listaview.setAdapter(adapter);
    }
}