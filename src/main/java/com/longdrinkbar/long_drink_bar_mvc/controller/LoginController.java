package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.longdrinkbar.long_drink_bar_mvc.dao.IAlumnoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioAlumnoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;
import com.longdrinkbar.long_drink_bar_mvc.entity.UsuarioAlumno;
import com.longdrinkbar.long_drink_bar_mvc.model.AlumnoTransporter;
import com.longdrinkbar.long_drink_bar_mvc.model.UserTransporter;

//import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Autowired
    private IUsuarioAlumnoDAO usuarioAlumnoDAO;

    @Autowired
    private IAlumnoDAO alumnoDAO;


    @GetMapping(value="/login")
    public String login(Model m){
        return "login";
    }

    @PostMapping(value="/login")
    public ModelAndView logExitoso(Model m, 
    @RequestParam(name="username") String nombreUsuario,
    @RequestParam(name="passw") String contra){
        Usuario user = usuarioDAO.buscarUsuario(nombreUsuario, contra);
        if (user == null){
            ModelAndView error = new ModelAndView(new RedirectView("login-no-exitoso"));
            return error;
        }
        else{
            String retorno = "";
            if (user.getPermisos() == 0){
                retorno = "adminPanel"; //OK
            }
            else if (user.getPermisos() == 1){
                retorno = "/dashboard/home"; //Ok
                UsuarioAlumno asrAl = usuarioAlumnoDAO.buscarNombre(user.getId());
                Alumno al = alumnoDAO.buscarAlumno(asrAl.getId_alumno().getId());
                AlumnoTransporter.setAlumno(al);
            }
            else if (user.getPermisos() == 2){
                retorno = "profesorPanel"; //OK
            }
            else{
                retorno = "/"; //Ok
            }
            //Asignar modelo, vista y usuario logeado.
            ModelAndView mav = new ModelAndView(new RedirectView(retorno));
            mav.addObject("obtenerUsuario",user);
            UserTransporter.setUsuario(user);
            return mav;
        }
    }

    @GetMapping(value="/login-no-exitoso")
    public String loginFallido(Model m){
        return "login-no-exitoso";
    }
}
