package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CursosController {
    @RequestMapping("/cursos")
    public String cursos(Model m){
        return "cursos";
    }
}
