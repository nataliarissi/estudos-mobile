package com.example.petpdm;

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

        // pegar dados enviado pela activity pai
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
        startActivity(intentAbriCadastro);
    }

    public void abrirListagemPet(View view) {
        Intent intentListagem = new Intent(this, ListagemPetActivity.class);

        intentListagem.putExtra("lista_pet", (ArrayList<Pet>)this.listaPet);

        startActivity(intentListagem);
    }
}