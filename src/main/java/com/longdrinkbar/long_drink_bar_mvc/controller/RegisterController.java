package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxRegistro;
import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioDAO;
@Controller
public class RegisterController {
    @Autowired
    private IUsuarioDAO usrDAO;

    //GET
    @GetMapping("/register")
    public String register(Model m){
        m.addAttribute("titulo","REGISTRO");
        return "register";
    }
    //POST
    
    @PostMapping("/register")
    public String guardarRegistro(Model m,
    @RequestParam(name="nombre") String nombre,
    @RequestParam(name="contrasena") String contrasena,
    @RequestParam(name="ap_paterno") String ap_paterno,
    @RequestParam(name="ap_materno") String ap_materno,
    @RequestParam(name="dni") String dni,
    @RequestParam(name="email") String email
    ){
        m.addAttribute("titulo","REGISTRO EXITOSO!");
        AuxRegistro clase = new AuxRegistro(nombre, contrasena, ap_materno, ap_paterno, dni, email, (byte)1);
        String username = clase.generarUsername();
        usrDAO.registrar(clase);
        m.addAttribute("mostrarDatos",clase);
        m.addAttribute("username", username);
        return "registro-exitoso";
    }
}
