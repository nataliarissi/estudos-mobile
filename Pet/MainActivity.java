package com.example.petpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarMenu(View view) {

        EditText login = findViewById(R.id.editTextLogin);
        EditText senha = findViewById(R.id.editTextSenha);
        Button botaodeLogin = findViewById(R.id.botaoLogar);

        List<String> listaLogin = Arrays.asList("Madara" , "maria", "joazinho", "melancia");

       if(listaLogin.contains(login.getText().toString())
       && senha.getText().toString().equals("123")){
          Bundle bundle = new Bundle();
          bundle.putString("login", login.getText().toString());
          bundle.putInt("Idade ", 500);

           Intent intent = new Intent(this,dashboard_activity.class);
           intent.putExtras(bundle);
           startActivity(intent);

        }else{
            Toast.makeText(this, "Errou usuário ou senha", Toast.LENGTH_LONG).show();
        }

        }
    }
