package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IInscripcionDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxInscripcion;

import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.model.AlumnoTransporter;

@Controller
public class InscripcionController {

    @Autowired
    private IInscripcionDAO inscripcionDAO;
    @Autowired
    private ICursoDAO cursoDAO;

    
    @GetMapping(value="/inscripcion")
    public String mostratInscripcion(Model m){
        m.addAttribute("cursos", cursoDAO.listarCursos());
        m.addAttribute("turnos", cursoDAO.listarTurnos());
        return "inscripcion";
    }

    @PostMapping(value="/inscripcion")
    public ModelAndView inscripcion(Model m,
    @RequestParam(name="curso") String curso,
    @RequestParam(name="turno") String turno,
    @RequestParam(name="fecha_inicio") String inicio) throws ParseException{
        if (curso == "" || turno == "" || inicio == ""){
            ModelAndView error = new ModelAndView(new RedirectView("inscripcion-erronea"));
            return error;
        }
        else{
            Alumno alumno = new Alumno();
            Curso cur = cursoDAO.obtenerCursoNombre(curso);

            System.out.println(inicio);
            if (AlumnoTransporter.checkDisponible()){
                alumno = AlumnoTransporter.getAlumno();
            }
            

            Calendar calendario = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaInscripcion = Date.from(Instant.now());
            Date fechaInicio = formato.parse(inicio);
            calendario.setTime(fechaInicio);
            calendario.add(Calendar.MONTH, ((int)cur.getDuracion()));

            AuxInscripcion ins = new AuxInscripcion(cur, alumno, fechaInscripcion, fechaInicio, calendario.getTime(), Byte.parseByte("1"));

            inscripcionDAO.guardarInscripcion(ins);
            AlumnoTransporter.setAlumno(alumno);
            ModelAndView regreso = new ModelAndView(new RedirectView("/dashboard/home"));
            return regreso;
        }
    }
    
}
