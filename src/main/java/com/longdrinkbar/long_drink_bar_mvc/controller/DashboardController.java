package com.longdrinkbar.long_drink_bar_mvc.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
@Controller
public class DashboardController {
    @Autowired
    private ICursoDAO cursoDAO;

    @RequestMapping(value="dashboard/home", method = RequestMethod.GET)
    public String listarCursos(Model m){
        m.addAttribute("titulo", "Long Drink Bar - Cursos");
        m.addAttribute("subt","Cursos Disponibles");
        m.addAttribute("subt2","Tus Cursos");
        //REVISAR.
        List<Integer> test = new ArrayList<Integer>();
        test.add(2);
        test.add(1);
        m.addAttribute("tusCursos",cursoDAO.cursosAlumno(test));
        m.addAttribute("cursos",cursoDAO.listarCursos());
        return "dashboard-cursos";
    }

    // @RequestMapping("/dashboard")
    // public String dashboard(Model m){
    //     return "dashboard";
    // }
}
