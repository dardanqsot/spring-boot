package com.darwin.springboot.app.view.pdf;

import com.darwin.springboot.app.models.entity.Cliente;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("ver")
public class ClientePdfView extends AbstractPdfView {

	@Autowired
    private MessageSource messageSource;

	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Cliente> clientes = (ArrayList) model.get("clientes");

		
		MessageSourceAccessor mensajes =  getMessageSourceAccessor();

		PdfPCell cell = null;

		PdfPTable tabla = new PdfPTable(4);

		tabla.setWidths(new float [] {1, 1, 1, 3.5f});
		tabla.addCell("id");
		tabla.addCell("nombre");
		tabla.addCell("apellido");
		tabla.addCell("email");
		
		for(Cliente item: clientes) {
			cell = new PdfPCell(new Phrase(item.getId().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell.setBackgroundColor(new Color(184,218,255));
			tabla.addCell(cell);
			tabla.addCell(item.getNombre());
			tabla.addCell(item.getApellido());
			tabla.addCell(item.getEmail());
		}

	    document.add(tabla);
		
	}

}
