package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Turnos;

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

    //Obtener datos de curso especifico.
    @Override
    @Transactional
    public Curso obtenerCurso(int id) {
        try{
            return em.createQuery("select i from curso i where id_curso = "+id, Curso.class).getSingleResult();
        }
        catch (Exception ex){
            return null;
        }
        
    }

    //Obtener solo listado de ciertos cursos. 
    @Override
    @Transactional(readOnly = true)
    public List<Curso> cursosAlumno(List<Integer> lista) {
        try{
            Session session = em.unwrap(Session.class);
            MultiIdentifierLoadAccess<Curso> multiLoadAccess = session.byMultipleIds(Curso.class);
            List<Curso> retorno = multiLoadAccess.multiLoad(lista);
            return retorno; 
        }
        catch(Exception ex){
            return null;
        }
    }

    @Override
    public Curso obtenerCursoNombre(String nombre) {
        try{
            return em.createQuery("select i from Curso i where id = "+nombre, Curso.class).getSingleResult();
        }
        catch(Exception ex){
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Turnos> listarTurnos() {
        try{
            return em.createQuery("from Turnos").getResultList();
        }
        catch(Exception ex){
            return null;
        }
    }
}
