package com.longdrinkbar.long_drink_bar_mvc.entity;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name="usuario_profesor")
public class UsuarioProfesor implements Serializable{
    @Id
    @OneToOne
    @JoinColumn(name="id_profesor")
    private Profesor id_profesor;
    @Id
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario id_usuario;

    
    public UsuarioProfesor(Profesor id_profesor, Usuario id_usuario) {
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
    
}
