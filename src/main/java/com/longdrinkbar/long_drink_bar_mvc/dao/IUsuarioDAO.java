package com.longdrinkbar.long_drink_bar_mvc.dao;

import java.util.List;

import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

public interface IUsuarioDAO {
    //Metodos.

    //Listar.
    public List<Usuario> listarUsuarios();

    //Registrar usuario.
    public void registrar(Usuario usr);

    //Buscar por usr:
    public List<Usuario> buscarUsr(String dni);
}
