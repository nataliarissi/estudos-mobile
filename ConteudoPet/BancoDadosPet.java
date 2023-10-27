package com.example.petpdm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BancoDadosPet
        extends SQLiteOpenHelper {

    public BancoDadosPet(Context context) {
        super(context, "PET_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql ="create table pet (" +  "ID INTEGER PRIMARY KEY ," +
            "NOME TEXT NOT NULL," + "PESO REAL NOT NULL," + "RACA TEXT NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        sql = "INSERT INTO pet (NOME,PESO,RACA)" + " VALUES('pet1',5,'raca a')";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void adicionarPet(Pet pet){
        String sql = "INSERT INTO pet (NOME,PESO,RACA)" + " VALUES('" + pet.nome + "'," +
                    pet.peso + "," + "'"+ pet.raca +"')";
        Log.i("pet","sql insert pet: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public ArrayList<Pet> listarPets(){
        ArrayList<Pet> lista = new ArrayList<>();
        String sql = "select * from pet";
        // busca os dados e retorna no cursor = 'tabela'
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();

        for(int n=0; n < cursor.getCount(); n++ ){
            Pet pet = new Pet();
            pet.nome = cursor.getString(1);
            pet.peso = cursor.getDouble(2);
            pet.raca = cursor.getString(3);
            cursor.moveToNext();
            lista.add(pet);
        }
        cursor.close();

        return lista;
    }

    public ArrayList<Pet> buscarPorNome(String nome){
        ArrayList<Pet> lista = new ArrayList<>();
        String sql = "select * from pet where nome = '" + nome + "'";
        // busca os dados e retorna no cursor = 'tabela'
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
        cursor.moveToFirst();

        for(int n=0; n < cursor.getCount(); n++ ){
            Pet pet = new Pet();
            pet.nome = cursor.getString(1);
            pet.peso = cursor.getDouble(2);
            pet.raca = cursor.getString(3);
            cursor.moveToNext();
            lista.add(pet);
        }
        cursor.close();

        return lista;
    }
}