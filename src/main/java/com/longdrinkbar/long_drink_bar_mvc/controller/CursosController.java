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
import com.longdrinkbar.long_drink_bar_mvc.dao.IProfesorDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;
import com.longdrinkbar.long_drink_bar_mvc.entity.ProfesorCurso;
@Controller
public class CursosController {
    @Autowired
    private ICursoDAO cursoDAO;

    @Autowired
    private IProfesorDAO profesorDAO;

    //Listar Cursos...
    @GetMapping(value={"/cursos", "/curso"})
    public String cursos(Model m){
        m.addAttribute("titulo", "Cursos");
        m.addAttribute("subtitulo","Nuestros Cursos");
        m.addAttribute("cursos",cursoDAO.listarCursos());
        return "cursos-publicos";
    }

    
    @GetMapping(value="/cursos/{id}")
    ModelAndView mostrarDetalles(@PathVariable(value="id") String id, Map<String, Object> model){
        
        Curso curso = cursoDAO.obtenerCurso(Integer.parseInt(id));
        ProfesorCurso profC= cursoDAO.obtenProfesor(curso.getId());
        Profesor prof = profesorDAO.buscarProfesor(profC.getId_profesor().getId());

        //System.out.println(curso.getNombre());

        ModelAndView mv = new ModelAndView(new RedirectView("detalles-curso-publico"));
        mv.setViewName("detalles-curso-publico");
        mv.addObject("curso", curso);
        mv.addObject("turnos", cursoDAO.listarTurnos(curso.getId()));
        mv.addObject("clases", cursoDAO.listarClases(curso.getId()));
        mv.addObject("profesor", prof);

        return mv;
    }
}
