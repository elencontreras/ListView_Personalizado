package com.example.android.personas;

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

    public void guardar(){
        Datos.guardar(this);
    }
}
