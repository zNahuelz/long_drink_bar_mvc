package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RegisterController {

    //@RequestMapping("/register")
    //public String register(Model m){
    //    return "register";
    //}
    //GET.
    @GetMapping("/register")
    public String register(Model m){
        m.addAttribute("titulo","REGISTRO DE USUARIOS");
        return "register";
    }
    //POST
    
    @PostMapping("/register")
    public String regExitoso(Model m, 
    @RequestParam(name="dni") String dni, 
    @RequestParam(name="nombre") String nombre,
    @RequestParam(name="apellido") String apellido,
    @RequestParam(name="email") String email,
    @RequestParam(name="passw") String passw
    ){
        m.addAttribute("titulo","REGISTRO EXITOSO!");
        m.addAttribute("dni",dni);
        m.addAttribute("nombre",nombre);
        m.addAttribute("apellido",apellido);
        m.addAttribute("email",email);
        m.addAttribute("passw",passw);
        return "registro-exitoso";
    }
}
