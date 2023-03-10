package com.longdrinkbar.long_drink_bar_mvc.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name="inscripcion")
public class Inscripcion implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_inscripcion")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_curso")
    public Curso id_curso;
    @ManyToOne
    @JoinColumn(name="id_alumno")
    public Alumno id_alumno;
    public Date fecha_inscripcion;
    public Date fecha_inicio;
    public Date fecha_final;
    public Byte en_curso;

    
    public Inscripcion(Curso id_curso, Alumno id_alumno, Date fecha_inscripcion, Date fecha_inicio, Date fecha_final,
            Byte en_curso) {
        this.id_curso = id_curso;
        this.id_alumno = id_alumno;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.en_curso = en_curso;
    }

    public Inscripcion(int id, Curso id_curso, Alumno id_alumno, Date fecha_inscripcion, Date fecha_inicio,
            Date fecha_final, Byte en_curso) {
        this.id = id;
        this.id_curso = id_curso;
        this.id_alumno = id_alumno;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.en_curso = en_curso;
    }

    public Inscripcion(){

    }

    public Curso getId_curso() {
        return id_curso;
    }
    public void setId_curso(Curso id_curso) {
        this.id_curso = id_curso;
    }
    public Alumno getId_alumno() {
        return id_alumno;
    }
    public void setId_alumno(Alumno id_alumno) {
        this.id_alumno = id_alumno;
    }
    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }
    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
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
    public Byte getEn_curso() {
        return en_curso;
    }
    public void setEn_curso(Byte en_curso) {
        this.en_curso = en_curso;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
