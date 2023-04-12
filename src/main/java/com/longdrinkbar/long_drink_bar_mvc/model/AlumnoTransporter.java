package com.longdrinkbar.long_drink_bar_mvc.model;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;

public class AlumnoTransporter {
    private static boolean disponible = false;
    private static Alumno alumno;
    
    public static boolean checkDisponible(){
        return disponible;
    }

    public static void setAlumno(Alumno alm){
        AlumnoTransporter.alumno = alm;
        disponible = true;
    }

    public static Alumno getAlumno(){
        disponible = false;
        return alumno;
    }
}
