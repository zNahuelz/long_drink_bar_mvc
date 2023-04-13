package com.longdrinkbar.long_drink_bar_mvc.entity;

import java.util.Date;

public class AuxInscripcion {
    private Curso id_curso;

    private Alumno id_alumno;

    private Date fecha_inscripcion;
    private Date fecha_inicio;
    private Date fecha_final;
    private Byte en_curso;



    
    public AuxInscripcion(Curso id_curso, Alumno id_alumno, Date fecha_inscripcion, Date fecha_inicio, Date fecha_final,
            Byte en_curso) {
        this.id_curso = id_curso;
        this.id_alumno = id_alumno;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.en_curso = en_curso;
    }

    public AuxInscripcion() {
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

    
}
