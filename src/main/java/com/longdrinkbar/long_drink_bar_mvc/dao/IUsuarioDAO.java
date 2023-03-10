package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

public interface IUsuarioDAO {
    //Metodos.

    //Listar.
    public List<Usuario> listarUsuarios();
    //Registrar usuario.
    public void registrar(Usuario usr);
    //Editar usuario.
    public Usuario editarUsr(Long id);
    //Eliminar usuario. -> Deberia marcar estado a 0.
    public void eliminarUsr(Long id);
    //Buscar usuario por email & password
    public Usuario buscarUsuario(String email);
}
