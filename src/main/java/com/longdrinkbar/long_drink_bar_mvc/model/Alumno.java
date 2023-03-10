<<<<<<< Updated upstream:src/main/java/com/longdrinkbar/long_drink_bar_mvc/model/Alumno.java
package com.longdrinkbar.long_drink_bar_mvc.model;

public class Alumno {
=======
package com.longdrinkbar.long_drink_bar_mvc.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_alumno")
    private int id;
>>>>>>> Stashed changes:src/main/java/com/longdrinkbar/long_drink_bar_mvc/entity/Alumno.java
    private String nombre;
    @Column(name = "ap_materno")
    private String apMaterno;
    @Column(name = "ap_paterno")
    private String apPaterno;
    private String email;
    private String dni;
    
    public Alumno() {
    }

    public Alumno(String nombre, String apMaterno, String apPaterno, String email, String dni) {
        this.nombre = nombre;
        this.apMaterno = apMaterno;
        this.apPaterno = apPaterno;
        this.email = email;
        this.dni = dni;
    }

<<<<<<< Updated upstream:src/main/java/com/longdrinkbar/long_drink_bar_mvc/model/Alumno.java
=======
    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
>>>>>>> Stashed changes:src/main/java/com/longdrinkbar/long_drink_bar_mvc/entity/Alumno.java
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

<<<<<<< Updated upstream:src/main/java/com/longdrinkbar/long_drink_bar_mvc/model/Alumno.java
    
=======
    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
>>>>>>> Stashed changes:src/main/java/com/longdrinkbar/long_drink_bar_mvc/entity/Alumno.java
}
