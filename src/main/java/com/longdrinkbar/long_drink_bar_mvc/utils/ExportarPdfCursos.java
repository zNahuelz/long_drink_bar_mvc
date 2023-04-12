package com.longdrinkbar.long_drink_bar_mvc.utils;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.longdrinkbar.long_drink_bar_mvc.entity.Alumno;
import com.longdrinkbar.long_drink_bar_mvc.entity.Curso;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RGBColor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/adminPanel/cursos")
public class ExportarPdfCursos extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Curso> cursos = (List<Curso>)model.get("cursos");
        
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30, Color.white);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, Color.white);
        
        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 40, 20);

        document.open();

        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;

        celda = new PdfPCell(new Phrase("Listado de Cursos", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(46,182,125));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        PdfPTable tablaCursos = new PdfPTable(5);
        tablaCursos.setWidths(new float[] {0.8f, 2f, 2f, 2f, 1.5f});

        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(224,30,90));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCursos.addCell(celda);

        celda = new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(224,30,90));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCursos.addCell(celda);

        celda = new PdfPCell(new Phrase("Descripción", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(224,30,90));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCursos.addCell(celda);

        celda = new PdfPCell(new Phrase("Duración", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(224,30,90));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCursos.addCell(celda);

        celda = new PdfPCell(new Phrase("Costo", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(224,30,90));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaCursos.addCell(celda);

        cursos.forEach(
            curso -> {
                tablaCursos.addCell(((Integer)curso.getId()).toString());
                tablaCursos.addCell(curso.getNombre());
                tablaCursos.addCell(curso.getDescripcion());
                tablaCursos.addCell(((Short)curso.getDuracion()).toString() + " meses");
                tablaCursos.addCell("S/. " + ((Float)curso.getCosto()).toString());
            }
        );

        document.add(tablaTitulo);
        document.add(tablaCursos);
    }
    
}
