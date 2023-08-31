package com.example.bancofrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class FrutasMainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_frutas_main);

            EditText editTextNomeFruta = findViewById(R.id.editTextNomeFruta);
            EditText editTextPreco = findViewById(R.id.editTextPreco);
            Button botaoSalvar = findViewById(R.id.botaoSalvar);

            botaoSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nomeFruta = editTextNomeFruta.getText().toString();
                    String preco = editTextPreco.getText().toString();

                    if (nomeFruta.isEmpty() || preco.isEmpty()) {
                        Toast.makeText(FrutasMainActivity.this, "Preencha os dados das frutas", Toast.LENGTH_SHORT).show();
                    } else {
                        float valorPreco = Float.parseFloat(preco);
                        if (valorPreco <= 0) {
                            Toast.makeText(FrutasMainActivity.this, "Preço inválido", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(FrutasMainActivity.this, "Cadastrado realizado com sucesso", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }