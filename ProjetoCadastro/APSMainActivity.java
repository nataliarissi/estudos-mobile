package com.example.app2_exer;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class APSMainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private SimpleCursorAdapter adapter;
    private ListView listView;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apsmain);

        databaseManager = new DatabaseManager(this);
        databaseHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.listView);

        databaseManager.open();
        Entidade entidade = new Entidade();
        entidade.setNome("Luke");
        entidade.setIdade(10);
        entidade.setEmail("luke@gmail.com");
        entidade.setNome("Itachi");
        entidade.setIdade(20);
        entidade.setEmail("itachi@gmail.com");
        entidade.setNome("Madara");
        entidade.setIdade(27);
        entidade.setEmail("madara@gmail.com");
        databaseManager.inserirEntidade(entidade);
        databaseManager.close();

        databaseManager.open();

        List<Entidade> listaentdaide = databaseHelper.listar();
        String[] vetorUsuario = new String[listaentdaide.size()];
        for(int i=0; i < vetorUsuario.length;i++){
            vetorUsuario[i] = listaentdaide.get(i).toString();
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        vetorUsuario);

        listView.setAdapter(adapter);

        databaseManager.close();
    }
}
