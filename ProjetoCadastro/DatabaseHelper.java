package com.example.app2_exer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BancoAPS.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Entidade";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_IDADE = "idade";
    public static final String COLUMN_EMAIL = "email";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOME + " TEXT, " +
                    COLUMN_IDADE + " INTEGER, " +
                    COLUMN_EMAIL + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Entidade> listar(){
        ArrayList<Entidade> lista = new ArrayList<>();
        String sql = "select * from Entidade";
        Cursor cursor = getReadableDatabase()
                .rawQuery(sql,null);
        cursor.moveToFirst();

        for(int i=0; i < cursor.getCount(); i++ ){
            Entidade entidade = new Entidade();
            entidade.setId(cursor.getInt(0));
            entidade.setNome(cursor.getString(1));
            entidade.setIdade(cursor.getInt(2));
            entidade.setEmail(cursor.getString(3));
            cursor.moveToNext();
            lista.add(entidade);
        }
        cursor.close();

        return lista;
    }
}
