package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class ProfesorDAOImp implements IProfesorDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Profesor> listarProfesor() {

        return em.createQuery("from Profesor").getResultList();
    }

    @Override
    @Transactional
    public Profesor buscarProfesor(int id) {
        try{
            Profesor p = em.find(Profesor.class,id);
            if (p != null){
                return p;
            }
            else{
                return null;
            }
        }
        catch(Exception ex){
            return null;
        }
    }
    
}
