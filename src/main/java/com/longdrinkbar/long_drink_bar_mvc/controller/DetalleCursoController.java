package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
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
import com.longdrinkbar.long_drink_bar_mvc.dao.IInscripcionDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IProfesorDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;
import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;
import com.longdrinkbar.long_drink_bar_mvc.entity.ProfesorCurso;
import com.longdrinkbar.long_drink_bar_mvc.model.AlumnoTransporter;

@Controller
public class DetalleCursoController {
    
    @Autowired
    private ICursoDAO cursoDAO;

    @Autowired
    private IProfesorDAO profesorDAO;

    @Autowired
    private IInscripcionDAO inscripcionDAO;

    @RequestMapping(value="/detalleCurso")
    public String mostrar(Model m){
        
        return "detalles-curso-alumno";
    }

    @GetMapping(value="/detalleCurso/{id}")
    ModelAndView mostrarDetalles(@PathVariable(value="id") String id, Map<String, Object> model) throws ParseException{

        Alumno al = AlumnoTransporter.getAlumno();
        Curso curso = cursoDAO.obtenerCurso(Integer.parseInt(id));
        ProfesorCurso profC= cursoDAO.obtenProfesor(curso.getId());
        Inscripcion ins = inscripcionDAO.buscarInscripcion(al.getId());
        Profesor prof = profesorDAO.buscarProfesor(profC.getId_profesor().getId());

        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        calendario.setTime(ins.getFecha_inicio());
        
        if (calendario.getTime() == Date.from(Instant.now())){
            calendario.add(Calendar.WEEK_OF_MONTH, 1);
        }

        ModelAndView mv = new ModelAndView(new RedirectView("detalles-curso-alumno"));
        mv.setViewName("detalles-curso-alumno");
        mv.addObject("curso", curso);
        mv.addObject("clases", cursoDAO.listarClases(curso.getId()));
        mv.addObject("fecha", formato.format(calendario.getTime()));
        mv.addObject("profesor", prof);
        mv.addObject("nombreAlum",al.getNombre()+" "+al.getApPaterno());
        AlumnoTransporter.setAlumno(al);
        return mv;
    }

    @GetMapping(value="/detalleCursoP/{id}")
    ModelAndView mostrarDetallesP(@PathVariable(value="id") String id, Map<String, Object> model){
        
        Alumno al = AlumnoTransporter.getAlumno();
        Curso curso = cursoDAO.obtenerCurso(Integer.parseInt(id));
        ProfesorCurso profC= cursoDAO.obtenProfesor(curso.getId());
        Profesor prof = profesorDAO.buscarProfesor(profC.getId_profesor().getId());

        //System.out.println(curso.getNombre());

        ModelAndView mv = new ModelAndView(new RedirectView("detalles-curso-alumno"));
        mv.setViewName("detalles-curso-alumno");
        mv.addObject("curso", curso);
        mv.addObject("turnos", cursoDAO.listarTurnos(curso.getId()));
        mv.addObject("clases", cursoDAO.listarClases(curso.getId()));
        mv.addObject("profesor", prof);
        mv.addObject("nombreAlum",al.getNombre()+" "+al.getApPaterno());
        AlumnoTransporter.setAlumno(al);

        return mv;
    }
}
