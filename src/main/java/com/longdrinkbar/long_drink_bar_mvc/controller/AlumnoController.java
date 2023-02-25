package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.longdrinkbar.long_drink_bar_mvc.dao.IAlumnoDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;

@Controller
public class AlumnoController {
    
    @Autowired
    private IAlumnoDAO alumnoDAO;

    @RequestMapping(value="/listarAlumno")
    public String listarAlumno(Model model){
        model.addAttribute("titulo", "Listar Alumnos");
        model.addAttribute("alumno", alumnoDAO.listarAlumnos());
        model.addAttribute("btn", "Crear Alumno");
        return "listarAlumno";
    }

    @GetMapping(value="/formAlumno")
    public String crearAlumno(Model model){
        Alumno alumno = new Alumno();
        model.addAttribute("titulo", "Formulario del Alumno");
        model.addAttribute("alumno", alumno);
        model.addAttribute("nom","Crear Alumno");
        return "formAlumno";
    }

    @PostMapping(value="/formAlumno")
    public String guardar(@Validated Alumno alumno, BindingResult result, Model model,
    @RequestParam("file") MultipartFile foto){ 
        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario Alumno");
            return "formAlumno";
        }
        if(!foto.isEmpty()){
            Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try{
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath+"//"+foto.getOriginalFilename());
                Files.write(rutaCompleta,bytes);
                alumno.setFoto(foto.getOriginalFilename());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        alumnoDAO.guardar(alumno);
        return "redirect:listarAlumno";
    }

    @GetMapping(value="/formAlumno/{id}")
    public String editarAlumno(@PathVariable(value="id") Long id, Map<String, Object> model){
        Alumno al = null;

        if (id > 0){
            al = alumnoDAO.buscarAlumno(id);
        }
        else{
            return "redirect:/listarAlumno";
        }

        model.put("titulo", "Editar Alumno");
        model.put("alumno", al);
        model.put("nom", "Editar Alumno");
        return "formAlumno";
    }

    @GetMapping(value="/eliminarAlumno/{id}")
    public String eliminarAlumno(@PathVariable(value="id") Long id){
        if (id > 0){
            alumnoDAO.eliminarAlumno(id);
        }
        return "redirect:/listarAlumno";
    }


    @GetMapping(value="/verAlumno/{id}")
    public String verAlumno(@PathVariable(value="id") Long id, Map<String, Object> model){
        Alumno alumno = alumnoDAO.buscarAlumno(id);
        if (alumno == null){
            return "redirect:/listarAlumno";
        }
        model.put("alumno", alumno);
        model.put("titulo", "Detalle del Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
        return "verAlumno";
    }
}
