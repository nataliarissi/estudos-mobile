package com.example.petpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class dashboard_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //pegar dados enviados pela activity pai
        String login = (String) getIntent().getSerializableExtra("login");
        Integer idade = (Integer) getIntent().getSerializableExtra("idade");

        TextView olaLogin = findViewById(R.id.textViewOlaLogin);
        olaLogin.setText("Olá " + login);
        Toast.makeText(this, "Olá " + login,Toast.LENGTH_LONG).show();
    }
}