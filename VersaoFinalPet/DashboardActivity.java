package com.example.petpdm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    List<Pet> listaPet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("DashBoard");

        // vamos pegar os dados enviado pela activity
        String login = (String) getIntent().getSerializableExtra("login");
        Integer idade = (Integer) getIntent().getSerializableExtra("idade");


        EditText olaLogin = findViewById(R.id.editTextTextOlaLogin);
        olaLogin.setText("Olá " +  login);

        Toast.makeText(this,"Olá " + login,Toast.LENGTH_LONG).show();

        listaPet = new ArrayList<Pet>();
    }

    public void abrirCadastroPet(View view){
        Intent intentAbriCadastro = new Intent(this, CadastroPetActivity.class);

        intentAbriCadastro.putExtra("lista_pet", (ArrayList<Pet>) this.listaPet);
        //startActivity(intentAbriCadastro);
        startActivityForResult(intentAbriCadastro,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // cadastro pet E
        // retorna a lista de pet
        if(requestCode == 1 && resultCode == 2) {
            listaPet = (List<Pet>) data.getSerializableExtra("lista_pet");
        }
    }

    public void abrirListagemPet(View view) {
        Intent intentListagem = new Intent(this, ListagemPetActivity.class);

        intentListagem.putExtra("lista_pet", (ArrayList<Pet>)this.listaPet);

        startActivity(intentListagem);
    }
}