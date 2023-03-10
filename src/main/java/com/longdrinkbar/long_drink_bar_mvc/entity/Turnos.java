package com.longdrinkbar.long_drink_bar_mvc.entity;

import java.io.Serializable;
import java.util.Date; //O cambiar por java.sql.date?

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="turnos")
public class Turnos implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_curso") //"Un curso puede tener muchos turnos."?
    private Curso id_curso;
    private String nombre;
    private Date hora_inicio;
    private Date hora_final;

    
    public Turnos(int id, Curso id_curso, String nombre, Date hora_inicio, Date hora_final) {
        this.id = id;
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public Turnos(){

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
    public Date getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public Date getHora_final() {
        return hora_final;
    }
    public void setHora_final(Date hora_final) {
        this.hora_final = hora_final;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
}
