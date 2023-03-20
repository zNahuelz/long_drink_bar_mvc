package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
@Controller
public class CursosController {
    @Autowired
    private ICursoDAO cursoDAO;

    @RequestMapping(value="listarCursos", method = RequestMethod.GET)
    public String listarCursos(Model m){
        m.addAttribute("titulo", "Long Drink Bar - Cursos");
        m.addAttribute("subt","Cursos Disponibles");
        m.addAttribute("subt2","Tus Cursos");
        m.addAttribute("cursos",cursoDAO.listarCursos());
        return "cursos-alumno";
    }
}
