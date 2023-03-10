package com.longdrinkbar.long_drink_bar_mvc.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_especialidad")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor id_profesor;
    private String nombre;

    
    public Especialidad(int id, Profesor id_profesor, String nombre) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.nombre = nombre;
    }

    public Especialidad(){

    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Profesor getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(Profesor id_profesor) {
        this.id_profesor = id_profesor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
}
