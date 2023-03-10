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
@Table(name="usuario_profesor")
public class UsuarioProfesor implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_inscripcion")
    private int id;

    @OneToOne
    @JoinColumn(name="id_profesor")
    private Profesor id_profesor;
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario id_usuario;

    
    public UsuarioProfesor(Profesor id_profesor, Usuario id_usuario) {
        this.id_profesor = id_profesor;
        this.id_usuario = id_usuario;
    }
    

    public UsuarioProfesor(int id, Profesor id_profesor, Usuario id_usuario) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_usuario = id_usuario;
    }


    public UsuarioProfesor(){

    }
    
    public Profesor getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(Profesor id_profesor) {
        this.id_profesor = id_profesor;
    }
    public Usuario getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
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
