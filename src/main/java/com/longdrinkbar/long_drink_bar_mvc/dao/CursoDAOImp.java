package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class CursoDAOImp implements ICursoDAO {

    @PersistenceContext
    private EntityManager em;

    //Listar cursos.
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Curso> listarCursos() {
        return em.createQuery("from Curso").getResultList();
    }
    
}
