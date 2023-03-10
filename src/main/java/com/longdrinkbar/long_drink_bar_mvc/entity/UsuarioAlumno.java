package com.longdrinkbar.long_drink_bar_mvc.entity;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name="usuario_alumno")
public class UsuarioAlumno implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_inscripcion")
    private int id;
    
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario id_usuario;
    @OneToOne
    @JoinColumn(name="id_alumno")
    private Alumno id_alumno;

    
    public UsuarioAlumno(Usuario id_usuario, Alumno id_alumno) {
        this.id_usuario = id_usuario;
        this.id_alumno = id_alumno;
    }

    public UsuarioAlumno(int id, Usuario id_usuario, Alumno id_alumno) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
