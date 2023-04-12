package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.AuxInscripcion;
import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;

public interface IInscripcionDAO {
    //Metodos ~

    public List<Inscripcion> listarInscripcion();

    public List<Inscripcion> obtenerInscripcion(int id_alum);
    
    public void guardarInscripcion(AuxInscripcion aux);
}
