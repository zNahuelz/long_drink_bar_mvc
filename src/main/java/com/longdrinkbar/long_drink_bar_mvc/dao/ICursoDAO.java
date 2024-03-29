package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Clases;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;
import com.longdrinkbar.long_drink_bar_mvc.entity.ProfesorCurso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Turnos;

public interface ICursoDAO {
    //Listar cursos.
    public List<Curso> listarCursos();

    //Obtener curso especifico.
    public Curso obtenerCurso(int id);

    //Obtener curso a partir del nombre
    public Curso obtenerCursoNombre(String nombre);

    //Obtener listado de x cursos
    public List<Curso> cursosAlumno(List<Integer> lista);

    //Obtener listado de todos los turnos segun curso
    public List<Turnos> listarTurnos(int id_curso);

    //Obtener listado de clases segun curso
    public List<Clases> listarClases(int id_curso);

    //Obtener el profesor segun el curso
    public ProfesorCurso obtenProfesor(int id_curso);
}
