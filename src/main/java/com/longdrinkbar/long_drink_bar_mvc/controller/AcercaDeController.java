package com.longdrinkbar.long_drink_bar_mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longdrinkbar.long_drink_bar_mvc.model.Profesor;
@Controller
public class AcercaDeController {
    @RequestMapping("/acercade")
    public String acercade(Model m){
        Profesor profe = new Profesor();
        m.addAttribute("profesor", profe);

        return "acercade";
    }
}
