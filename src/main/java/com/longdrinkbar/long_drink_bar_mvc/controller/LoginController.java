package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;




@Controller
public class LoginController {
    @Autowired
    private IUsuarioDAO usrDAO;

    @GetMapping(value="/login")
    public String login(Model m){
        return "login";
    }

    @PostMapping(value="/login")
    public String logExitoso(Model m, 
    @RequestParam(name="email") String correo,
    @RequestParam(name="password") String contra){
        Usuario buscar = usrDAO.buscarUsuario(correo);
        if(buscar == null){
            return "redirect:LoginNoExitoso";
        }
        else{
            return "redirect:cursos";
        }
    }
}
