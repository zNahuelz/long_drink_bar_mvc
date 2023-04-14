package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
@Controller
public class CursosController {
    @Autowired
    private ICursoDAO cursoDAO;

    //Listar Cursos...
    @RequestMapping(value="/cursos")
    public String cursos(Model m){
        m.addAttribute("titulo", "Long Drink Bar - Cursos");
        m.addAttribute("subtitulo","Nuestros Cursos");
        m.addAttribute("cursos",cursoDAO.listarCursos());
        return "cursos-publicos";
    }

    @GetMapping(value="/cursos/{id}")
    ModelAndView mostrarDetalles(@PathVariable(value="id") String id, Map<String, Object> model){
        
        Curso curso = cursoDAO.obtenerCurso(Integer.parseInt(id));

        //System.out.println(curso.getNombre());

        ModelAndView mv = new ModelAndView(new RedirectView("detalles-curso-publico"));
        mv.setViewName("detalles-curso-publico");
        mv.addObject("curso", curso);
        mv.addObject("turnos", cursoDAO.listarTurnos(curso.getId()));

        return mv;
    }
}
