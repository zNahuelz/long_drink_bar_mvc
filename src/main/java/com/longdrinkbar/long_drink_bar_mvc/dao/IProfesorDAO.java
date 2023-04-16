package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;

public interface IProfesorDAO {
    
    //Listar docentes.
    public List<Profesor> listarProfesor();

    //Buscar profesor segun id
    public Profesor buscarProfesor(int id);
}
