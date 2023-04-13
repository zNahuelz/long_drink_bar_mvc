package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longdrinkbar.long_drink_bar_mvc.dao.IInscripcionDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;

@Controller
public class IngresosController {
    
    @Autowired
    private IInscripcionDAO inscripcionDAO;
    //GET
    @GetMapping(value="/adminPanel/ingresos")
    public String Ingresos(Model m){
        m.addAttribute("titulo","Administración - Ingresos");
        return "ingresos";
    }

    //POST
    @PostMapping(value="/adminPanel/ingresos")
    public String calcularIngresos(Model m, @RequestParam(name="fecha") String fecha){
        try {
            Date fechaSQL = new SimpleDateFormat("yyyy-MM-dd").parse(fecha); //Formatear fecha.
            List<Inscripcion> listaT = inscripcionDAO.listarInscripcion(); //Obtener listado inscripciones.
            List<Float> dineros = new ArrayList<Float>(); 
            Calendar fechaIngresada = Calendar.getInstance(); 
            fechaIngresada.setTime(fechaSQL); //Setear fecha en calendario.
            Calendar fechaComparar = Calendar.getInstance();
            for (Inscripcion i : listaT) {
                fechaComparar.setTime(i.getFecha_inicio()); 
                //Se añaden los montos de cada curso dependiendo si hay alumnos cursando en el mes/año ingresados.
                if(fechaIngresada.get(Calendar.YEAR) == fechaComparar.get(Calendar.YEAR)){
                    if(fechaIngresada.get(Calendar.MONTH) == fechaComparar.get(Calendar.MONTH)){
                        dineros.add(i.getId_curso().getCosto());
                    }
                }
                
            }

            float montoTotal = 0;
            //Sumar contenido a array.
            for(float f : dineros){
                montoTotal+=f;
            }

            //Mensajes: Correcto, error y falta de alumnos en el mes ingresado.
            m.addAttribute("mensaje", "El ingreso aproximado para el mes seleccionado es de: S./ " + Float.toString(montoTotal));
            if(montoTotal <= -0){
                m.addAttribute("mensaje","");
                m.addAttribute("advertencia","Oops! No se registran ingresos en el mes seleccionado! - Intente con otro mes.");
            }

        } catch (ParseException e) {
            m.addAttribute("mensaje", "");
            m.addAttribute("advertencia","Error! Debe seleccionar una fecha.");
        }
        
        return "calculo-ingresos";
    }
}
