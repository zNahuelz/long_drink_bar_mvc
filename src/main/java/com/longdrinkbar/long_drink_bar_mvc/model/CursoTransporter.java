package com.longdrinkbar.long_drink_bar_mvc.model;

import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;

public class CursoTransporter {
    private static boolean disponible = false;
    private static Curso curso;
    
    public static boolean checkDisponible(){
        return disponible;
    }

    public static void setCurso(Curso cur){
        CursoTransporter.curso = cur;
        disponible = true;
    }

    public static Curso getCurso(){
        disponible = false;
        return curso;
    }
}
