package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

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
    public void registrar(Usuario usr) {
        if(usr.getId()!=null && usr.getId()>0){
            em.merge(usr);
        }
        else{
            em.persist(usr);
        }
        
    }

    //METODO PARA ACTUALIZAR
    @Override
    @Transactional
    public Usuario editarUsr(Long id) {
        return em.find(Usuario.class,id);
    }

    //METODO PARA ELIMINAR
    @Override
    @Transactional
    public void eliminarUsr(Long id) {
        em.remove(editarUsr(id));
    }
    
}
