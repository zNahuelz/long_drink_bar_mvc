package com.longdrinkbar.long_drink_bar_mvc.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="curso")
public class Curso implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int id;
    private String nombre;
    private String descripcion;
    private float costo;
    private short duracion;

    public Curso(int id, String nombre, String descripcion, float costo, short duracion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.duracion = duracion;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
