package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxRegistro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AlumnoDAOImp implements IAlumnoDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Alumno buscarAlumno(int id) {
        return em.find(Alumno.class, id);
    }

    @Override
    @Transactional
    public void eliminarAlumno(int id) {
        em.remove(buscarAlumno(id));        
    }

    @Override
    @Transactional
    public void guardar(AuxRegistro aux) {
        Alumno alum = new Alumno(aux.getId(), aux.getNombre(),aux.getAp_materno(),aux.getAp_paterno(),aux.getEmail(),aux.getDni());

        if(alum.getId() != 0 && alum.getId() > 0){
            em.merge(alum);
        }else{
            em.persist(alum);
        }
        
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Alumno> listarAlumnos() {
        return em.createQuery("from Alumno").getResultList();
    }

    //Metodo para comprobar existencia previa de DNI y EMAIL.

    @Override
    @Transactional
    public Alumno comprobarExistencia(String dni, String email) {
        try{
            return em.createQuery("select i from Alumno i where dni ='"+dni+"' OR email='"+email+"'", Alumno.class).getSingleResult();
        }
        catch (Exception ex){
            return null;
        }
    }
    
}
