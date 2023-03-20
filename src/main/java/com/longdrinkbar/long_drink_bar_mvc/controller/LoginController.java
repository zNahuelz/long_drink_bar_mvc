package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

//import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @GetMapping(value="/login")
    public String login(Model m){
        return "login";
    }

    @PostMapping(value="/login")
    public String logExitoso(Model m, 
    @RequestParam(name="username") String nombreUsuario,
    @RequestParam(name="passw") String contra){
        Usuario user = usuarioDAO.buscarUsuario(nombreUsuario, contra);
        if (user == null){
            return "login-no-exitoso";
        }
        else{
            String retorno = "";
            if (user.getPermisos() == 0){
                retorno = "adminPanel";
            }
            else if (user.getPermisos() == 1){
                retorno = "cursos-alumno"; //dashboard. 
            }
            else if (user.getPermisos() == 2){
                retorno = "profesorPanel";
            }
            else{
                retorno = "redirect:/";
            }
            return retorno;
        }
    }
}
