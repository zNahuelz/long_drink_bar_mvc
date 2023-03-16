package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CursosController {
    @RequestMapping(value="/cursos")
    public String cursos(Model model){
        // model.addAttribute("macerados", "Macerados");
        // model.addAttribute("desh", "Deshidratados");
        // model.addAttribute("Pisco", "Cocteleria con Pisco");
        // model.addAttribute("titulo", "Cursos de nuestra institución");
        return "cursos";
    }
}
