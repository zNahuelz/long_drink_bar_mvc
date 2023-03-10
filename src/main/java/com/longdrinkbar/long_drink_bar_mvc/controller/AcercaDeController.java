package com.longdrinkbar.long_drink_bar_mvc.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longdrinkbar.long_drink_bar_mvc.model.Alumno;

@Controller
public class AcercaDeController {
    @RequestMapping("/acercade")
    public String tarjetas(Model m){
        List<Alumno> alumnos = new ArrayList<>();
        m.addAttribute("alumnos", alumnos);
        alumnos.add(new Alumno("Andres", "Caballero", "98521476", "https://scontent-lim1-1.xx.fbcdn.net/v/t39.30808-6/318419037_623509149778791_1578734561896625451_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=gQqr9xCXidEAX-iCSDI&_nc_ht=scontent-lim1-1.xx&oh=00_AfBov3Zx8Efno_9uf__SuvOSaspfG16H1qWF-_uXv_2OAQ&oe=63E38650"));
        alumnos.add(new Alumno("Juan", "Álvarez", "52364198", "https://scontent-lim1-1.xx.fbcdn.net/v/t39.30808-6/318171015_623509183112121_2638232037735280306_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=_NUO0jiwhoQAX-t9t8I&_nc_ht=scontent-lim1-1.xx&oh=00_AfCFYNWbjWySOVC6SJ4ISnQgOzugeRGwH-O2OJliGk7rAQ&oe=63E4025A"));
        alumnos.add(new Alumno("Marcos", "Morales", "85214763", "https://scontent-lim1-1.xx.fbcdn.net/v/t39.30808-6/317753676_623509239778782_1099993676416101444_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=15hyMqk4qEwAX-vFNC-&_nc_ht=scontent-lim1-1.xx&oh=00_AfALr8zRFLXMp8Ox92T8z3e49wFplpSvlrxmdCx_0OZT2Q&oe=63E4DD92"));
        m.addAttribute("titulo", "Nosotros");
        m.addAttribute("tituloPagina", "Sobre Nosotros");
        m.addAttribute("tituloAlumnos", "Nuestros Alumnos Destacados");
        return "acercade";
    }
}
