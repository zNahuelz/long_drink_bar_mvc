package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxRegistro;
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
    public void registrar(AuxRegistro aux) {
        Alumno alum = new Alumno(aux.getNombre(),aux.getAp_materno(),aux.getAp_paterno(),aux.getEmail(),aux.getDni());
        Usuario usr = new Usuario(aux.generarUsername(),aux.getContrasena(),aux.getPermisos());
        UsuarioAlumno usrAlum = new UsuarioAlumno(usr,alum);
        em.persist(alum);
        em.persist(usr);
        em.persist(usrAlum);

        //Usar PERSIST.
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

    // METODO PARA EL LOGIN --->> Debe rehacerse.
    @Transactional
    @Override
    public Usuario buscarUsuario(String username, String pass) {
        try{
            return em.createQuery("select u from Usuario u where nombre_usuario = '"+username+"' AND contrasena = '"+pass+"'", Usuario.class).getSingleResult();
        }
        catch(Exception ex){
            return null;
        }
    }
    
}
