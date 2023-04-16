package com.longdrinkbar.long_drink_bar_mvc.utils;

import java.awt.Color;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.longdrinkbar.long_drink_bar_mvc.controller.AlumnoController;
import com.longdrinkbar.long_drink_bar_mvc.dao.ICursoDAO;
import com.longdrinkbar.long_drink_bar_mvc.dao.IInscripcionDAO;
import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.longdrinkbar.long_drink_bar_mvc.entity.Inscripcion;
import com.longdrinkbar.long_drink_bar_mvc.model.AlumnoTransporter;
import com.longdrinkbar.long_drink_bar_mvc.model.CursoTransporter;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/detalleCurso/certificado")
public class ExportarPdfCertificado extends AbstractPdfView{

    @Autowired
    private IInscripcionDAO inscripcionDAO;

    @Autowired
    private ICursoDAO cursoDAO;

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Alumno al = AlumnoTransporter.getAlumno();
        Inscripcion ins = inscripcionDAO.buscarInscripcion(al.getId());
        Curso cur = cursoDAO.obtenerCurso(ins.getId_curso().getId());

        Font fuenteCertifica = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 40);
        Font fuenteNombre = FontFactory.getFont(FontFactory.HELVETICA, 25);


        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 40, 20);
        document.open();

        PdfPTable tablaImagen = new PdfPTable(1);
        PdfPCell celda = null;


        String direccion = System.getProperty("user.dir");
        Image imagen;
        imagen = Image.getInstance(direccion + "/src/main/resources/static/images/logo_longdrink-removebg-preview.png");
        imagen.scaleAbsoluteHeight(150);
        imagen.scaleAbsoluteWidth(250);
        celda = new PdfPCell(imagen);
        celda.setPaddingTop(50);
        celda.setBorder(0);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        tablaImagen.addCell(celda);

        PdfPTable tablaCertifica = new PdfPTable(1);
        celda = new PdfPCell(new Phrase("Certifica a: ", fuenteCertifica));
        celda.setBorder(0);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablaCertifica.addCell(celda);

        PdfPTable tablaNombre = new PdfPTable(1);
        celda = new PdfPCell(new Phrase(al.getNombre().toString() + " " + al.getApPaterno().toString() + " " + al.getApMaterno().toString(), fuenteNombre));
        celda.setBorder(0);
        celda.setBorderWidthBottom(2);
        celda.setBorderColor(new Color(158, 46, 30));
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(50);
        celda.setPaddingBottom(15);
        tablaNombre.addCell(celda);

        PdfPTable tablaCulminado = new PdfPTable(1);
        celda = new PdfPCell(new Phrase("Por haber culminado satisfactoriamente el curso de: ", fuenteNombre));
        celda.setBorder(0);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(40);
        tablaCulminado.addCell(celda);

        PdfPTable tablaCurso = new PdfPTable(1);
        celda = new PdfPCell(new Phrase(cur.getNombre().toUpperCase(), fuenteCertifica));
        celda.setBorder(0);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(40);
        tablaCurso.addCell(celda);
        
        AlumnoTransporter.setAlumno(al);
        document.add(tablaImagen);
        document.add(tablaCertifica);
        document.add(tablaNombre);
        document.add(tablaCulminado);
        document.add(tablaCurso);
    }
    
}
