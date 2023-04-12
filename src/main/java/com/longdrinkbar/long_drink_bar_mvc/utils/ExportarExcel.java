package com.longdrinkbar.long_drink_bar_mvc.utils;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Profesor;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExportarExcel {
    private XSSFWorkbook workbook; //Archivo Excel.
    private XSSFSheet sheet;  //Hoja de Trabajo.
    private List<Profesor> listaProfesor;
    private List<Curso> listaCurso;
    private List<Alumno> listaAlumno;

    /*
     * I am not responsible of this code.
     * They made me write it, against my will.
     */

    //Constructor para profesores.
    public ExportarExcel(List<Profesor> listaProfesor){
        this.listaProfesor = listaProfesor;
        workbook = new XSSFWorkbook();
    }

    //Constructor para Cursos.
    public ExportarExcel(List<Curso> listaCurso, int b){
        this.listaCurso = listaCurso;
        workbook = new XSSFWorkbook();
    }

    //Constructor para alumnos.
    public ExportarExcel(List<Alumno> listaAlumno, String a){
        this.listaAlumno = listaAlumno;
        workbook = new XSSFWorkbook();
    }

    //Metodo para escribir y cambiar tipo de celda segun dato a escribir....
    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount); //Redimensionar columnas.
        Cell cell = row.createCell(columnCount);
        //InstanceOf: Determinar tipos de datos.
        //En base a esto se define el valor de la celda -> Booleano, string, integer etc...
        if (value instanceof Integer){
            cell.setCellValue((Integer)value);
        }
        else if (value instanceof Boolean){
            cell.setCellValue((boolean)value);
        }
        else{
            cell.setCellValue((String)value);
        }
        cell.setCellStyle(style);
    }

    //Metodos para exportar DOCENTES.....
    private void EscribirHeaderDocentes(){
        sheet = workbook.createSheet("Docentes"); 
        Row row = sheet.createRow(0); 
        CellStyle style = workbook.createCellStyle(); 
        XSSFFont font = workbook.createFont(); 
        font.setBold(true); 
        font.setFontHeight(16);
        style.setFont(font);

        //Valores de la cabecera.
        createCell(row,0,"ID",style);
        createCell(row,1,"NOMBRE",style);
        createCell(row,2,"AP. PATERNO",style);
        createCell(row,3,"AP. MATERNO",style);
        createCell(row,4,"E-MAIL",style);
        createCell(row,5,"DNI",style);
    }



    private void escribirDocente(){
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle(); //Configurar fuentes y estilo de celdas.
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        //Llenado de datos.
        for (Profesor p : listaProfesor){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row,columnCount++,Integer.toString(p.getId()),style);
            createCell(row,columnCount++,p.getNombre(),style);
            createCell(row,columnCount++,p.getAp_paterno(),style);
            createCell(row,columnCount++,p.getAp_materno(),style);
            createCell(row,columnCount++,p.getEmail(),style);
            createCell(row,columnCount++,p.getDni(),style);
        }
    }

    public void exportarDocente(HttpServletResponse response) throws IOException{
        EscribirHeaderDocentes();
        escribirDocente();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

    //Metodos para exportar CURSOS......
    private void EscribirHeaderCursos(){
        sheet = workbook.createSheet("Cursos"); 
        Row row = sheet.createRow(0); 
        CellStyle style = workbook.createCellStyle(); 
        XSSFFont font = workbook.createFont(); 
        font.setBold(true); 
        font.setFontHeight(16);
        style.setFont(font);

        //Valores de la cabecera.
        createCell(row,0,"ID",style);
        createCell(row,1,"NOMBRE",style);
        createCell(row,2,"DESCRIPCIÓN",style);
        createCell(row,3,"DURACIÓN | SEMANAS",style);
        createCell(row,4,"COSTO",style);
    }

    private void escribirCursos(){
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle(); //Configurar fuentes y estilo de celdas.
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        //Llenado de datos.
        for (Curso c : listaCurso){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row,columnCount++,Integer.toString(c.getId()),style);
            createCell(row,columnCount++,c.getNombre(),style);
            createCell(row,columnCount++,c.getDescripcion(),style);
            createCell(row,columnCount++,Short.toString(c.getDuracion()),style);
            createCell(row,columnCount++,Float.toString(c.getCosto()),style);

        }
    }

    public void exportarCurso(HttpServletResponse response) throws IOException{
        EscribirHeaderCursos();
        escribirCursos();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

    //Metodos para exportar ALUMNOS.....
    private void EscribirHeaderAlumno(){
        sheet = workbook.createSheet("Alumnos"); 
        Row row = sheet.createRow(0); 
        CellStyle style = workbook.createCellStyle(); 
        XSSFFont font = workbook.createFont(); 
        font.setBold(true); 
        font.setFontHeight(16);
        style.setFont(font);

        //Valores de la cabecera.
        createCell(row,0,"ID",style);
        createCell(row,1,"NOMBRE",style);
        createCell(row,2,"AP. PATERNO",style);
        createCell(row,3,"AP. MATERNO",style);
        createCell(row,4,"EMAIL",style);
        createCell(row,5,"DNI",style);
    }

    private void escribirAlumnos(){
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle(); //Configurar fuentes y estilo de celdas.
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        //Llenado de datos.
        for (Alumno a : listaAlumno){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row,columnCount++,Integer.toString(a.getId()),style);
            createCell(row,columnCount++,a.getNombre(),style);
            createCell(row,columnCount++,a.getApPaterno(),style);
            createCell(row,columnCount++,a.getApMaterno(),style);
            createCell(row,columnCount++,a.getEmail(),style);
            createCell(row,columnCount++,a.getDni(),style);

        }
    }

    public void exportarAlumno(HttpServletResponse response) throws IOException{
        EscribirHeaderAlumno();
        escribirAlumnos();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

}
