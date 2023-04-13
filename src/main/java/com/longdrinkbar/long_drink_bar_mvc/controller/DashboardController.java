package com.longdrinkbar.long_drink_bar_mvc.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IInscripcionDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;
import com.longdrinkbar.long_drink_bar_mvc.model.AlumnoTransporter;
import com.longdrinkbar.long_drink_bar_mvc.model.UserTransporter;
@Controller
public class DashboardController {
    @Autowired
    private ICursoDAO cursoDAO;

    @Autowired
    private IInscripcionDAO inscripcionDAO;


    @RequestMapping(value="dashboard/home", method = {RequestMethod.GET, RequestMethod.POST}) //Check.
    public ModelAndView listarCursos(Model m){

        //Asignar modelo y vista, asi como obtener usuario logeado (Login -> Dashboard).
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard-cursos");
        Usuario usuario = new Usuario();
        Alumno a = new Alumno();

    
        if(UserTransporter.checkDisponible() && AlumnoTransporter.checkDisponible()){
            usuario = UserTransporter.getUsuario();
            a = AlumnoTransporter.getAlumno();
        } 

        //Obtener objeto alumno para extraer nombre.
        // Alumno a = alumDAO.buscarAlumno(usuario.getId());
        
        //Llenar Array con ID's de cursos inscritos.
        List<Integer> test = new ArrayList<Integer>();
        List<Inscripcion> cursosInscritos = inscripcionDAO.obtenerInscripcion(usuario.getId());
        if(cursosInscritos.size() >0){
            for (Inscripcion i : cursosInscritos) {
                test.add(i.getId_curso().getId());
            }
        }

        //Array sin cursos inscritos.
        List<Curso> cursosAux = cursoDAO.cursosAlumno(test);
        List<Curso> cursosGenerales = cursoDAO.listarCursos();
        cursosGenerales.removeAll(cursosAux);
        

        m.addAttribute("titulo", "Long Drink Bar - Cursos");
        m.addAttribute("subt","Cursos Disponibles");
        m.addAttribute("subt2","Tus Cursos");
        m.addAttribute("tusCursos",cursoDAO.cursosAlumno(test)); //Listado de cursos inscritos.
        m.addAttribute("cursos",cursosGenerales); //Listado de cursos -> Excluye a los que ya se inscribio.
        m.addAttribute("nombreAlum",a.getNombre()+" "+a.getApPaterno()); //Nombre - Apellido.
        m.addAttribute("datosUsuario", usuario); //Objeto Usuario.
        UserTransporter.setUsuario(usuario);
        AlumnoTransporter.setAlumno(a);

        return mav;
    }

    
}
