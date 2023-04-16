package com.longdrinkbar.long_drink_bar_mvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longdrinkbar.long_drink_bar_mvc.dao.IProfesorDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;

@Controller
public class HomeController {

    @Autowired
    IProfesorDAO profesorDAO;

    @RequestMapping("/")
    public String home(Model m){
        List<Profesor> profesores = profesorDAO.listarProfesor();

        m.addAttribute("profesores", profesores);
        return "home";
    }
}
