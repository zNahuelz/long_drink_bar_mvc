package com.longdrinkbar.long_drink_bar_mvc.entity;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name="usuario_alumno")
public class UsuarioAlumno implements Serializable{
    @Id
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario id_usuario;
    @Id
    @OneToOne
    @JoinColumn(name="id_alumno")
    private Alumno id_alumno;

    
    public UsuarioAlumno(Usuario id_usuario, Alumno id_alumno) {
        this.id_usuario = id_usuario;
        this.id_alumno = id_alumno;
    }

    public UsuarioAlumno(){

    }

    public Usuario getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Alumno getId_alumno() {
        return id_alumno;
    }
    public void setId_alumno(Alumno id_alumno) {
        this.id_alumno = id_alumno;
    }

    
}
