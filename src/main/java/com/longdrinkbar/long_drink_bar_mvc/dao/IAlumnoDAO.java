package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxRegistro;

public interface IAlumnoDAO {

    //Listado de Alumnos
    public List<Alumno> listarAlumnos();
    
    public void guardar(AuxRegistro aux);

    public Alumno buscarAlumno(int id);

    public void eliminarAlumno(int id);

    public Alumno comprobarExistencia(String dni, String email);
}
