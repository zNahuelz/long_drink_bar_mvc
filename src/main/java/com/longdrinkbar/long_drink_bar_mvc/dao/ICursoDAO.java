package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;

public interface ICursoDAO {
    //Listar cursos.
    public List<Curso> listarCursos();

    //Obtener curso especifico.
    public Curso obtenerCurso(int id);

    //Obtener listado de x cursos
    public List<Curso> cursosAlumno(List<Integer> lista);


}
