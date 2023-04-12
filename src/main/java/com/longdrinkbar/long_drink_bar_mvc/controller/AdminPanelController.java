package com.longdrinkbar.long_drink_bar_mvc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.longdrinkbar.long_drink_bar_mvc.dao.IAlumnoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IProfesorDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;
import com.longdrinkbar.long_drink_bar_mvc.utils.ExportarExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AdminPanelController {
    
    @Autowired
    private ICursoDAO cursoDAO;

    @Autowired
    private IAlumnoDAO alumnoDAO;

    @Autowired
    private IProfesorDAO profesorDAO;
    
    @GetMapping(value="/adminPanel")
    public String adminPanel(Model m){
        m.addAttribute("titulo", "Long Drink Bar - Administración");
        m.addAttribute("cursos",cursoDAO.listarCursos());
        m.addAttribute("alumnos",alumnoDAO.listarAlumnos());
        m.addAttribute("profesores",profesorDAO.listarProfesor());
        return "adminPanel";
    }

    //Exportar Docentes a CSV.
    @GetMapping(value="/exp/docentes/csv")
    public void expDocentesCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); //Definir formato de fecha.
		String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=docentes_" + currentDateTime + ".csv";
        response.setHeader(headerKey,headerValue);

        List<Profesor> listaDocente = profesorDAO.listarProfesor();
        ICsvBeanWriter escribir = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String [] csvHeader = {"ID","NOMBRE","AP_PATERNO","AP_MATERNO","EMAIL","DNI"};
        String[] nameMapping = {"id","nombre","ap_Paterno","ap_Materno","email","dni"};

        escribir.writeHeader(csvHeader);

        for(Profesor p : listaDocente){
			escribir.write(p,nameMapping); //Llenar archivo!
		}
		escribir.close();
    }

    //Exportar Cursos a CSV.

    @GetMapping(value="/exp/cursos/csv")
    public void expCursosCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); //Definir formato de fecha.
		String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=cursos_" + currentDateTime + ".csv";
        response.setHeader(headerKey,headerValue);

        List<Curso> listadoCursos = cursoDAO.listarCursos();
        ICsvBeanWriter escribir = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String [] csvHeader = {"ID","NOMBRE","DESCRIPCION","COSTO","DURACIÓN"};
        String[] nameMapping = {"id","nombre","descripcion","costo","duracion"};

        escribir.writeHeader(csvHeader);

        for(Curso c : listadoCursos){
            escribir.write(c,nameMapping);
        }
        escribir.close();
    }

    //Exportar Alumnos a CSV.
    @GetMapping(value="/exp/alum/csv")
    public void expAlumnosCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); //Definir formato de fecha.
		String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=alumnos_" + currentDateTime + ".csv";
        response.setHeader(headerKey,headerValue);

        List<Alumno> listadoAlum = alumnoDAO.listarAlumnos();
        ICsvBeanWriter escribir = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String [] csvHeader = {"ID","NOMBRE","AP_PATERNO","AP_MATERNO","E-MAIL","DNI"};
        String[] nameMapping = {"id","nombre","apPaterno","apMaterno","email","dni"};

        escribir.writeHeader(csvHeader);

        for(Alumno a : listadoAlum){
            escribir.write(a,nameMapping);
        }
        escribir.close();
    }

    //Exportar Docentes a Excel.

    @GetMapping(value="/exp/docentes/excel")
    public void expDocentesEXCEL(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); //Definir formato de fecha.
		String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=docentes_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey,headerValue);

        List<Profesor> listarProfesores = profesorDAO.listarProfesor();
        ExportarExcel excelExporter = new ExportarExcel(listarProfesores);
        excelExporter.exportarDocente(response);

    }

    //Exportar Cursos a Excel

    @GetMapping(value="/exp/cursos/excel")
    public void expCursosEXCEL(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); //Definir formato de fecha.
		String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=cursos_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey,headerValue);

        List<Curso> listarCursos = cursoDAO.listarCursos();
        ExportarExcel excelExporter = new ExportarExcel(listarCursos, 0);
        excelExporter.exportarCurso(response);

    }

    //Exportar Alumnos a Excel.

    @GetMapping(value="/exp/alum/excel")
    public void expAlumnosEXCEL(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); //Definir formato de fecha.
		String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=alumnos_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey,headerValue);

        List<Alumno> listarAlumnos = alumnoDAO.listarAlumnos();
        ExportarExcel excelExporter = new ExportarExcel(listarAlumnos,"");
        excelExporter.exportarAlumno(response);

    }



}
