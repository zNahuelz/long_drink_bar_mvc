package com.longdrinkbar.long_drink_bar_mvc.utils;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/adminPanel/alumnos")
public class ExportarPdfAlumno extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Alumno> alumnos = (List<Alumno>)model.get("alumnos");
        
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30, Color.white);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, Color.white);
        
        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 40, 20);

        document.open();

        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;

        celda = new PdfPCell(new Phrase("Listado de Alumnos", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(5, 10, 230));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        PdfPTable tablaAlumnos = new PdfPTable(6);
        tablaAlumnos.setWidths(new float[] {0.8f, 2f, 2f, 2f, 1.5f, 1f});

        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 48, 108));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaAlumnos.addCell(celda);

        celda = new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 48, 108));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaAlumnos.addCell(celda);

        celda = new PdfPCell(new Phrase("Apellido Paterno", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 48, 108));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaAlumnos.addCell(celda);

        celda = new PdfPCell(new Phrase("Apellido Materno", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 48, 108));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaAlumnos.addCell(celda);

        celda = new PdfPCell(new Phrase("Email", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 48, 108));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaAlumnos.addCell(celda);

        celda = new PdfPCell(new Phrase("DNI", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(255, 48, 108));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaAlumnos.addCell(celda);

        alumnos.forEach(
            alumno -> {
                tablaAlumnos.addCell(((Integer)alumno.getId()).toString());
                tablaAlumnos.addCell(alumno.getNombre());
                tablaAlumnos.addCell(alumno.getApPaterno());
                tablaAlumnos.addCell(alumno.getApMaterno());
                tablaAlumnos.addCell(alumno.getEmail());
                tablaAlumnos.addCell(alumno.getDni());
            }
        );

        document.add(tablaTitulo);
        document.add(tablaAlumnos);
    }
    
}
