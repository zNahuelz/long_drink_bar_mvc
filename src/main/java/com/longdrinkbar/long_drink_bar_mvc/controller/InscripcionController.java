package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IInscripcionDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxInscripcion;

import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Turnos;
import com.longdrinkbar.long_drink_bar_mvc.model.AlumnoTransporter;
import com.longdrinkbar.long_drink_bar_mvc.model.CursoTransporter;

@Controller
public class InscripcionController {

    @Autowired
    private IInscripcionDAO inscripcionDAO;
    @Autowired
    private ICursoDAO cursoDAO;

    
    @GetMapping(value="/inscripcion")
    public String mostrarCursos(Model m){
        Curso cur = new Curso();
        if (CursoTransporter.checkDisponible()){
              cur = CursoTransporter.getCurso();
        }

        m.addAttribute("cursos", cursoDAO.listarCursos());
        m.addAttribute("turnos", cursoDAO.listarTurnos(cur.getId()));

        return "inscripcion";
    }

    @PostMapping(value="/inscripcion")
    public ModelAndView inscripcion(Model m,
    @RequestParam(name="turno") String turno,
    @RequestParam(name="fecha_inicio") String inicio) throws ParseException{
        if (turno == "" || inicio == ""){
            ModelAndView error = new ModelAndView(new RedirectView("inscripcion-erronea"));
            return error;
        }
        else{
            Alumno alumno = new Alumno();
            Curso cur = new Curso();

            if (AlumnoTransporter.checkDisponible()){
                alumno = AlumnoTransporter.getAlumno();
                cur = CursoTransporter.getCurso();
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
    
    @GetMapping(value="/inscripcion/turnos")
    public String mostrarTurnos(Model m){
        m.addAttribute("cursos", cursoDAO.listarCursos());
        return "inscripcion";
    }

    @PostMapping(value="/inscripcion/turnos")
    public String recibirCursos(Model m, @RequestParam(name="curso") String curso){
        if (curso == ""){
            return "inscripcion-erronea";
        }
        else{
            Curso cur = cursoDAO.obtenerCursoNombre(curso);
            CursoTransporter.setCurso(cur);
            

            return "redirect:/inscripcion";
        }
    }
}
