package com.longdrinkbar.long_drink_bar_mvc.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    //Autoincrementar ID.
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private int id;

    private String nombre_usuario;
    private String contrasena;
    private Byte permisos;
    
    
    public Usuario(int id, String nombre_usuario, String contrasena, Byte permisos) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.permisos = permisos;
    }

    public Usuario(String nombre_usuario, String contrasena, Byte permisos){
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.permisos = permisos;
    }

    public Usuario(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Byte getPermisos() {
        return permisos;
    }
    public void setPermisos(Byte permisos) {
        this.permisos = permisos;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}

