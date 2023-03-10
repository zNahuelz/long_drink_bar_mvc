package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;

@Controller
public class LoginController {
    @GetMapping(value="/login")
    public String login(Model m){
        return "login";
    }

    @PostMapping(value="/login")
    public String logExitoso(Model m, 
    @RequestParam(name="email") String correo,
    @RequestParam(name="password") String contra){
        // Usuario user = new Usuario();
        // user.setEmail(correo);
        // user.setPassword(contra);
        // m.addAttribute("usuario", user);
        // m.addAttribute("titulo","Cursos de nuestra institución");
        return "cursos-login";
    }
}
