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
import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioAlumnoDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;
import com.longdrinkbar.long_drink_bar_mvc.model.UserTransporter;
@Controller
public class DashboardController {
    @Autowired
    private ICursoDAO cursoDAO;

    @Autowired
    private IInscripcionDAO inscripcionDAO;

    @Autowired
    private IUsuarioAlumnoDAO usrAlumDAO;

    @RequestMapping(value="dashboard/home", method = {RequestMethod.GET, RequestMethod.POST}) //Check.
    public ModelAndView listarCursos(Model m){
        m.addAttribute("titulo", "Long Drink Bar - Cursos");
        m.addAttribute("subt","Cursos Disponibles");
        m.addAttribute("subt2","Tus Cursos");
        
        //Asignar modelo y vista, asi como obtener usuario logeado (Login -> Dashboard).
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard-cursos");
        Usuario usuario = new Usuario();
        if(UserTransporter.checkDisponible()){
            usuario = UserTransporter.getUsuario();
        } 
        m.addAttribute("datosUsuario", usuario);
        //m.addAttribute("nombreEstudiante", usrAlumDAO.buscarNombre(usuario.getId()));
        // List<Inscripcion> listado = inscripcionDAO.obtenerInscripcion(usuario.getId());
        // List<Integer> test = new ArrayList<Integer>();
        // for (Inscripcion i : listado) {
        //     test.add(i.getId_curso().getId());
        // }
        // cursoDAO.cursosAlumno(test);
        List<Integer> test = new ArrayList<Integer>();
        m.addAttribute("test", test);
        test.add(3);
        test.add(1);
        m.addAttribute("tusCursos",cursoDAO.cursosAlumno(test));
        m.addAttribute("cursos",cursoDAO.listarCursos()); //Listado de Cursos Generales.
        //return "dashboard-cursos";
        //mav.addObject("datosUsuario",usuario);
        return mav;
    }

}
