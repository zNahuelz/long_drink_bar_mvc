package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;

public interface IAlumnoDAO {

    //Listado de Alumnos
    public List<Alumno> listarAlumnos();
    
    public void guardar(Alumno alumno);

    public Alumno buscarAlumno(Long id);

    public void eliminarAlumno(Long id);
}
