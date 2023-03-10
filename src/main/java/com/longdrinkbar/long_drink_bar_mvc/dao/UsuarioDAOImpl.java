package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;
import com.longdrinkbar.long_drink_bar_mvc.entity.UsuarioAlumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO{

    @PersistenceContext
    private EntityManager em;

    //Metodo listar usuarios.
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Usuario> listarUsuarios() {
        return em.createQuery("from Usuario").getResultList();
    }

    //Registro de usuarios.
    @Override
    @Transactional
    public void registrar(Usuario usr, Alumno alum, UsuarioAlumno usrAlum) {
        if(usr.getId()!=0 && usr.getId()>0){
            em.merge(usr);
            em.merge(alum);
            em.merge(usrAlum);
        }
        else{
            em.persist(usr);
            em.persist(alum);
            em.persist(usrAlum);
        }
        
    }

    //METODO PARA ACTUALIZAR
    @Override
    @Transactional
    public Usuario editarUsr(int id) {
        return em.find(Usuario.class,id);
    }

    //METODO PARA ELIMINAR
    @Override
    @Transactional
    public void eliminarUsr(int id) {
        em.remove(editarUsr(id));
    }

    // METODO PARA EL LOGIN
    @Transactional
    @Override
    public Usuario buscarUsuario(String email) {
        try{
            return em.createQuery("select u from Usuario u where email = '"+email+"'", Usuario.class).getSingleResult();
        }
        catch(Exception ex){
            return null;
        }
    }
    
}
