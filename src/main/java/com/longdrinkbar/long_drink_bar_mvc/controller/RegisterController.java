package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Usuario;
import com.longdrinkbar.long_drink_bar_mvc.entity.UsuarioAlumno;
@Controller
public class RegisterController {

    //@RequestMapping("/register")
    //public String register(Model m){
    //    return "register";
    //}
    //GET.
    @GetMapping("/register")
    public String register(Model m){
        Usuario usr = new Usuario();
        UsuarioAlumno usrAlum = new UsuarioAlumno();
        Alumno alum = new Alumno();
        m.addAttribute("titulo","Long Drink Bar - Registro");
        m.addAttribute("usuario",usr);
        m.addAttribute("usuarioAlumno",usrAlum);
        m.addAttribute("alumno",alum);
        return "register";
    }
    //POST
    
    @PostMapping("/register")
    public String guardarRegistro(Model m, Usuario usr, UsuarioAlumno usrAlum, Alumno alum
    ){
        m.addAttribute("titulo","REGISTRO EXITOSO!");
        m.addAttribute("v1", 1);
        //usrDAO.registrar(usr, usrAlum, alum);
        m.addAttribute("mostrarDatos",alum); //usr
        m.addAttribute("email",alum.getEmail());
        return "registro-exitoso";
    }
}
