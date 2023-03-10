package com.longdrinkbar.long_drink_bar_mvc.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="profesor_curso")
public class ProfesorCurso implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor id_profesor;
    @Id
    @ManyToOne
    @JoinColumn(name="id_curso")
    private Curso id_curso;
    private Date fecha_inicio;
    private Date fecha_final;

    
    public ProfesorCurso(Profesor id_profesor, Curso id_curso, Date fecha_inicio, Date fecha_final) {
        this.id_profesor = id_profesor;
        this.id_curso = id_curso;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public ProfesorCurso(){

    }
    
    public Profesor getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(Profesor id_profesor) {
        this.id_profesor = id_profesor;
    }
    public Curso getId_curso() {
        return id_curso;
    }
    public void setId_curso(Curso id_curso) {
        this.id_curso = id_curso;
    }
    public Date getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public Date getFecha_final() {
        return fecha_final;
    }
    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    
}
