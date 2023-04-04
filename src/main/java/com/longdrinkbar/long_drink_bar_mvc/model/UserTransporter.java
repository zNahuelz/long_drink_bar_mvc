package com.longdrinkbar.long_drink_bar_mvc.model;

import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

public class UserTransporter {
    private static boolean disponible = false;
    private static Usuario usuario;
    
    public static boolean checkDisponible(){
        return disponible;
    }

    public static void setUsuario(Usuario usr){
        UserTransporter.usuario = usr;
        disponible = true;
    }

    public static Usuario getUsuario(){
        disponible = false;
        return usuario;
    }
}
