package com.longdrinkbar.long_drink_bar_mvc.dao;

import org.springframework.stereotype.Repository;

import com.longdrinkbar.long_drink_bar_mvc.entity.UsuarioAlumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioAlumnoDAOImp implements IUsuarioAlumnoDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public UsuarioAlumno buscarNombre(int id_usr) {
        try{
            return em.createQuery("select i from usuario_alumno i where id_usuario = "+id_usr,UsuarioAlumno.class).getSingleResult();
        }
        catch(Exception ex){
            return null;
        }
    }
}
