package com.longdrinkbar.long_drink_bar_mvc.model;

public class Profesor{
    private String nombre;
    private String apellido;
    private String dni;
    private short sueldo;
    private String especialidad;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, String dni, short sueldo, String especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public short getSueldo() {
        return sueldo;
    }

    public void setSueldo(short sueldo) {
        this.sueldo = sueldo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
}
