package com.example.android.personas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by android on 04/04/2017.
 */

public class Datos {


    public static ArrayList<Persona> traerPersonas(Context contexto) {

        //Declarar variables
        SQLiteDatabase db;
        String sql, nombre, apellido, edad, pasatiempo, foto;
        ArrayList<Persona> personas=new ArrayList<>();

        //Abrir la base de datos de lectura
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null, 1);
        db=aux.getReadableDatabase();

        //Cursor
        sql="Select nombre, apellido, edad, pasatiempo, foto from Personas";
        Cursor c =db.rawQuery(sql,null);

        //Recorrido del cursor
        if (c.moveToFirst()){
            do {
                nombre=c.getString(0);
                apellido=c.getString(1);
                edad=c.getString(2);
                pasatiempo=c.getString(3);
                foto=c.getString(4);

                Persona p=new Persona(nombre,apellido,edad,pasatiempo,foto);
                personas.add(p);
            }while (c.moveToNext());
        }
        //Cerrar conexión
        db.close();

        //Retornar Personas
        return personas;

    }

    public static Persona buscarPersona(Context contexto, String nomb) {

        //Declarar variables
        SQLiteDatabase db;
        String sql, nombre, apellido, edad, pasatiempo, foto;
        Persona p=null;

        //Abrir la base de datos de lectura
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas",null, 1);
        db=aux.getReadableDatabase();

        //Cursor
        sql="Select nombre, apellido, edad, pasatiempo, foto from Personas where nombre='"+nomb+"'";
        Cursor c =db.rawQuery(sql,null);

        //Recorrido del cursor
        if (c.moveToFirst()){

                nombre=c.getString(0);
                apellido=c.getString(1);
                edad=c.getString(2);
                pasatiempo=c.getString(3);
                foto=c.getString(4);

                p=new Persona(nombre,apellido,edad,pasatiempo,foto);


        }
        //Cerrar conexión
        db.close();

        //Retornar Personas
        return p;

    }


}