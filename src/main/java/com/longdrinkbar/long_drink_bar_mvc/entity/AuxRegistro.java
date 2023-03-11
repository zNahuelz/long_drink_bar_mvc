package com.longdrinkbar.long_drink_bar_mvc.entity;

public class AuxRegistro {
    private int id;
    private String nombre_usuario;
    private String contrasena;
    private String ap_paterno;
    private String ap_materno;
    private String dni;
    private String email;
    private String nombre;
    private Byte permisos = 0;

    
    public AuxRegistro(String nombre_usuario, String contrasena, String ap_paterno, String ap_materno, String dni,
            String email, String nombre, Byte permisos) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    
    public AuxRegistro(String nombre, String contrasena, String ap_materno, String ap_paterno, String dni, String email, Byte permisos) {
        this.contrasena = contrasena;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public AuxRegistro(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getAp_paterno() {
        return ap_paterno;
    }
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }
    public String getAp_materno() {
        return ap_materno;
    }
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Byte getPermisos() {
        return permisos;
    }
    public void setPermisos(Byte permisos) {
        this.permisos = permisos;
    }

    

}
