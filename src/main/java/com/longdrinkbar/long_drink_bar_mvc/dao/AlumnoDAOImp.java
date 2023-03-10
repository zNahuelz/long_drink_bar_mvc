package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AlumnoDAOImp implements IAlumnoDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Alumno buscarAlumno(Long id) {
        return em.find(Alumno.class, id);
    }

    @Override
    @Transactional
    public void eliminarAlumno(Long id) {
        em.remove(buscarAlumno(id));        
    }

    @Override
    @Transactional
    public void guardar(Alumno alumno) {
        if(alumno.getId() != 0 && alumno.getId() > 0){
            em.merge(alumno);
        }else{
            em.persist(alumno);
        }
        
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Alumno> listarAlumnos() {
        return em.createQuery("from Alumno").getResultList();
    }
    
}
