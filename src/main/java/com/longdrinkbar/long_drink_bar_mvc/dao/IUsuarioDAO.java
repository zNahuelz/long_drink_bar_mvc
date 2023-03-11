package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

//import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxRegistro;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;
//import com.longdrinkbar.long_drink_bar_mvc.entity.UsuarioAlumno;

public interface IUsuarioDAO {
    //Metodos.

    //Listar.
    public List<Usuario> listarUsuarios();
    //Registrar usuario.
    public void registrar(AuxRegistro aux);
    //Editar usuario.
    public Usuario editarUsr(int id);
    //Eliminar usuario. -> Deberia marcar estado a 0.
    public void eliminarUsr(int id);
    //Buscar usuario por email & password -->> hacer coincidir con requerimentos. (RODRIGO)
    public Usuario buscarUsuario(String email);
}
