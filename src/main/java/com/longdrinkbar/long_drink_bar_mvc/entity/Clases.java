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
@Table(name= "clases")
public class Clases implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_clase")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_curso")
    private Curso id_curso;
    private String nombre;
    private String guia;

    
    public Clases(int id, Curso id_curso, String nombre, String guia) {
        this.id = id;
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.guia = guia;
    }

    public Clases(){

    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Curso getId_curso() {
        return id_curso;
    }
    public void setId_curso(Curso id_curso) {
        this.id_curso = id_curso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGuia() {
        return guia;
    }
    public void setGuia(String guia) {
        this.guia = guia;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
