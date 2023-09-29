package com.example.apppetshop2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginUserActivity extends AppCompatActivity {

    public class LoginActivity extends AppCompatActivity {

        private List<Usuario> usuarios = new ArrayList<>();
        private EditText editTextNomeUsuario;
        private EditText editTextSenha;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            editTextNomeUsuario = findViewById(R.id.editTextNomeUsuario);
            editTextSenha = findViewById(R.id.editTextSenha);

            Button btnLogin = findViewById(R.id.btnLogin);
            Button btnCadastro = findViewById(R.id.btnCadastro);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fazerLogin();
                }
            });

            btnCadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cadastrarUsuario();
                }
            });
        }

        private void fazerLogin() {
            String nomeUsuario = editTextNomeUsuario.getText().toString();
            String senha = editTextSenha.getText().toString();

            boolean encontrado = false;

            for (Usuario usuario : usuarios) {
                if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                Toast.makeText(this, "Informações inválidas!", Toast.LENGTH_SHORT).show();
            }
        }

        private void cadastrarUsuario() {
            String nomeUsuario = editTextNomeUsuario.getText().toString();
            String senha = editTextSenha.getText().toString();

            if (nomeUsuario.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Necessário todos os campos preenchidos!", Toast.LENGTH_SHORT).show();
            } else {
                usuarios.add(new Usuario(nomeUsuario, senha));
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                editTextNomeUsuario.setText("");
                editTextSenha.setText("");
            }
        }
}