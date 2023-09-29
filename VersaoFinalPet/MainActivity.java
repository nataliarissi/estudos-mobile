package com.example.petpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");
    }

    public void mostrarMenu(View view) {

        // eu pego os componentes do layout
        EditText login = findViewById(R.id.editTextLogin);
        Button botaoLogin = findViewById(R.id.buttonLogar);
        EditText senha = findViewById(R.id.editTextSenha);

        List<String> listaLogin = Arrays.asList("sasuke", "sakura", "itachi","madara");

        // exemplo para exercicio
        // List<Login> listalogin2 = new ArrayList<>();
        // for(Login l: listalogin2){
        //    if(l.login.equals(login.getText().toString()) &&
        //        l.senha.equals(senha.getText().toString())){
        //
        //    }
        // }

        if(listaLogin.contains(login.getText().toString()) && senha.getText().toString().equals("123")){
            // abrindo uma nova activity
            Bundle bundle = new Bundle();
            bundle.putString("login",login.getText().toString());
            bundle.putInt("idade", 500);

            Intent intent = new Intent(this,DashboardActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }else{
            Toast.makeText(this,"Errou o usuário ou senha", Toast.LENGTH_LONG).show();
        }
    }
}