package com.longdrinkbar.long_drink_bar_mvc.model;

public class Usuario {
    private String username;
    private String password;
    private short prioridad;
    private char activo;
    private String email;
    
    public Usuario() {
    }

    public Usuario(String username, String password, short prioridad, char activo) {
        this.username = username;
        this.password = password;
        this.prioridad = prioridad;
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

    public short getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(short prioridad) {
        this.prioridad = prioridad;
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
