package com.example.android.personas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by android on 04/04/2017.
 */

public class Persona {
    private String nombre;
    private String apellido;
    private String edad;
    private String pasatiempo;
    private String foto;

    public Persona(String nombre, String apellido, String edad, String pasatiempo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pasatiempo = pasatiempo;
    }

    public Persona(String nombre, String apellido, String edad, String pasatiempo, String foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pasatiempo = pasatiempo;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public void guardar(Context contexto) {
        //Declarar variables
        SQLiteDatabase db;
        String sql;

        //Abrir conexion en modo escritura
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas", null,1);
        db=aux.getWritableDatabase();

        //Insertar Forma 1
        sql="INSERT INTO Personas values('"+this.getNombre()+"','"+this.getApellido()+"','"+this.edad+"','"+this.getPasatiempo()+"','"+this.getFoto()+"')";
        db.execSQL(sql);//Ejecutar sql


        /*
        //Insertar Forma 2
        ContentValues nuevaPersona=new ContentValues();
        nuevaPersona.put("nombre",this.getNombre());
        nuevaPersona.put("apellido",this.getApellido());
        nuevaPersona.put("edad", this.getEdad()); //utilizar String.valueof en caso de que sea entero
        nuevaPersona.put("pasatiempo", this.getPasatiempo());
        nuevaPersona.put("foto", this.getFoto());

        db.insert("Personas", null, nuevaPersona);
*/
        db.close();

    }

    public void modificar(Context contexto) {
        //Declarar variables
        SQLiteDatabase db;
        String sql;

        //Abrir conexion en modo escritura
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas", null,1);
        db=aux.getWritableDatabase();

        //Insertar Forma 1
        sql="UPDATE Personas set apellido='"+this.getApellido()+"',edad='"+this.edad+"',pasatiempo='"+this.getPasatiempo()+"',foto='"+this.getFoto()+"'where nombre like '%"+this.getNombre()+"%'";
        db.execSQL(sql);//Ejecutar sql


        db.close();

    }

    public void eliminar(Context contexto) {
        //Declarar variables
        SQLiteDatabase db;
        String sql;

        //Abrir conexion en modo escritura
        PersonasSQLiteOpenHelper aux= new PersonasSQLiteOpenHelper(contexto,"DBPersonas", null,1);
        db=aux.getWritableDatabase();

        //Insertar Forma 1
        sql="DELETE FROM Personas where nombre like '%"+this.getNombre()+"%'";
        db.execSQL(sql);//Ejecutar sql


        db.close();

    }
}
