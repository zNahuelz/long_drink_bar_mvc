package com.longdrinkbar.long_drink_bar_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
@Controller
public class CursosController {
    @Autowired
    private ICursoDAO cursoDAO;

    @RequestMapping(value="/cursos")
    public String cursos(Model m){
        m.addAttribute("cursos",cursoDAO.listarCursos());
        return "cursos-publicos";
    }
}
