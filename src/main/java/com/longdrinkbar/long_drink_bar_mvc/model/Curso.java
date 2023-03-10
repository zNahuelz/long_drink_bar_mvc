package com.longdrinkbar.long_drink_bar_mvc.model;

public class Curso {
    private String nombre;
    private char turno;
    private float precio;
    private String descripcion;
    private String duracion;
    private String intervalo;
    
    public Curso() {
    }

    public Curso(String nombre, char turno, float precio, String descripcion, String duracion, String intervalo) {
        this.nombre = nombre;
        this.turno = turno;
        this.precio = precio;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.intervalo = intervalo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    
}
