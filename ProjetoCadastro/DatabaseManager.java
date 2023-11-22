package com.example.app2_exer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c) {
        context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long inserirEntidade(Entidade entidade) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COLUMN_NOME, entidade.getNome());
        contentValue.put(DatabaseHelper.COLUMN_IDADE, entidade.getIdade());
        contentValue.put(DatabaseHelper.COLUMN_EMAIL, entidade.getEmail());
        return database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor obterTodasEntidades() {
        String[] columns = new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NOME, DatabaseHelper.COLUMN_IDADE, DatabaseHelper.COLUMN_EMAIL};
        return database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
    }
}
