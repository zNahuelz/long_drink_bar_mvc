package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

@Controller
public class RegisterController {
    @Autowired
    private IUsuarioDAO usrDAO;

    //GET.
    @GetMapping("/register")
    public String register(Model m){
        Usuario usr = new Usuario();
        m.addAttribute("titulo","Long Drink Bar - Registro");
        m.addAttribute("usuario",usr);
        return "register";
    }

    //POST
    @PostMapping("/register")
    public String guardarReg(Usuario usr,Model m){
        m.addAttribute("defaultP",1);
        m.addAttribute("defaultAct",1);
        usrDAO.registrar(usr);
        return "registro-exitoso";
    }

}
