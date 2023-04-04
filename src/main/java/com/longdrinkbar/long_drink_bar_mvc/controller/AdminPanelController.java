package com.longdrinkbar.long_drink_bar_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {
    
    @GetMapping(value="/adminPanel")
    public String adminPanel(Model m){
        return "adminPanel";
    }
}
