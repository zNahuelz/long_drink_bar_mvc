package com.longdrinkbar.long_drink_bar_mvc.model;

public class Alumno {
    private String nombre;
    private String apellido;
    private String dni;
    private String foto;
    
    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String dni, String foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
}
