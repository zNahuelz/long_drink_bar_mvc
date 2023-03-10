// package com.longdrinkbar.long_drink_bar_mvc.model;

// import java.io.Serializable;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name="usuarios")
// public class _Usuario implements Serializable{
//     //Autoincremento.
//     private static final long serialVersionUID=1L;
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String username;
//     private String password;
//     private short permiso; //Nivel de permiso del usuario. 
//     // 0 -> Admin / 1 -> Usuario / 2 -> Alumno / 3 -> Profesor.
//     private char activo;
//     private String email;
//     //Extra.
//     private String nombre;
//     private String apellidos;
    
//     public _Usuario() {
//     }

//     public _Usuario(String username, String password, short permiso, char activo) {
//         this.username = username;
//         this.password = password;
//         this.permiso = permiso;
//         this.activo = activo;
//     }
//     //AUX -> EVC1
//     public _Usuario(String username, String password, String email) {
//         this.username = username;
//         this.password = password;
//         this.email = email;
//     }


//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public short getPermiso() {
//         return permiso;
//     }

//     public void setPermiso(short permiso) {
//         this.permiso = permiso;
//     }

//     public char getActivo() {
//         return activo;
//     }

//     public void setActivo(char activo) {
//         this.activo = activo;
//     }

//     public String getEmail(){
//         return email;
//     }

//     public void setEmail(String email){
//         this.email = email;
//     }

//     public static long getSerialversionuid() {
//         return serialVersionUID;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getNombre() {
//         return nombre;
//     }

//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }

//     public String getApellidos() {
//         return apellidos;
//     }

//     public void setApellidos(String apellidos) {
//         this.apellidos = apellidos;
//     }
    
// }
