package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.AuxRegistro;
import com.longdrinkbar.long_drink_bar_mvc.dao.IAlumnoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IUsuarioDAO;
@Controller
public class RegisterController {
    @Autowired
    private IUsuarioDAO usrDAO;
    @Autowired
    private IAlumnoDAO alumDAO;

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
        Alumno chkExistencia = alumDAO.comprobarExistencia(dni, email);
        String mensajeError = "";
        if (chkExistencia == null){
            m.addAttribute("titulo","REGISTRO EXITOSO!");
            AuxRegistro clase = new AuxRegistro(nombre, contrasena, ap_materno, ap_paterno, dni, email, (byte)1);
            String username = clase.generarUsername();
            usrDAO.registrar(clase);
            m.addAttribute("mostrarDatos",clase);
            m.addAttribute("username", username);
            return "registro-exitoso";
        }
        else{
            if (chkExistencia.getEmail() == email){
                mensajeError += "Error! El e-mail ingresado ya se encuentra registrado. Debe ingresar un e-email distinto o recuperar sus credenciales. \n";
                m.addAttribute("error",mensajeError);
            }
            if (chkExistencia.getDni() == dni){
                mensajeError += "Error! El DNI ingresado ya se encuentra registrado. Debe ingresar un DNI distinto o recuperar sus credenciales. \n";
                m.addAttribute("error",mensajeError);
            }
            m.addAttribute("error",mensajeError);
            return "registro-no-exitoso";
        }

    }
}
