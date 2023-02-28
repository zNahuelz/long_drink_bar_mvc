package com.longdrinkbar.long_drink_bar_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class LoginNoExitosoController {
    
    @GetMapping(value="/LoginNoExitoso")
    public String loginNoExit(Model m){
        m.addAttribute("titulo","Error! - Login fallido");
        return "LoginNoExitoso";
    }
}