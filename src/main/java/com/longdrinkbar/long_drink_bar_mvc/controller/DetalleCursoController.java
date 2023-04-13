package com.longdrinkbar.long_drink_bar_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetalleCursoController {
    
    @RequestMapping(value="/detalleCurso")
    public String mostrar(Model m){
        return "/detalles-curso-publico";
    }
}
