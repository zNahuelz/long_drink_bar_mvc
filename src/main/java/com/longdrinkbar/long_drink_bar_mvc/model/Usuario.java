package com.longdrinkbar.long_drink_bar_mvc.model;

public class Usuario {
    private String username;
    private String password;
    private short permiso; //Nivel de permiso del usuario. 0-1-/2?
    private char activo;
    private String email;
    
    public Usuario() {
    }

    public Usuario(String username, String password, short permiso, char activo) {
        this.username = username;
        this.password = password;
        this.permiso = permiso;
        this.activo = activo;
    }
    //AUX -> EVC1
    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getPermiso() {
        return permiso;
    }

    public void setPermiso(short permiso) {
        this.permiso = permiso;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
}
