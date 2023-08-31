package com.example.petpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarMenu(View view) {

        // eu pego os componentes do layout
        EditText login = findViewById(R.id.editTextLogin);
        Button botaoLogin = findViewById(R.id.buttonLogar);
        EditText senha = findViewById(R.id.editTextSenha);

        if(login.getText().toString().equals("itachi")
                && senha.getText().toString().equals("6601")){
            // abrindo uma nova activity
            Intent intent = new Intent(this,DashboardActivity.class);
            Toast.makeText(this,"Sucesso", Toast.LENGTH_LONG).show();
            startActivity(intent);

        }else{
            Toast.makeText(this,"Usuário ou senha inválido(s)", Toast.LENGTH_LONG).show();
        }

    }
}