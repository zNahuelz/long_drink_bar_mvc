package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class InscripcionDAOImp implements IInscripcionDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Inscripcion> listarInscripcion() {
        return em.createQuery("from Inscripcion").getResultList();
    }

    @Override
    @Transactional(readOnly = true) //readOnly = true
    public List<Inscripcion> obtenerInscripcion(int id_alum) {
        try{
            return em.createQuery("from Inscripcion where id_alumno ="+id_alum,Inscripcion.class).getResultList();
        }
        catch(Exception ex){
            return null;
        }
    }
    
}
