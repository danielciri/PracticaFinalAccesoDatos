package com.bolsadeideas.springboot.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bolsadeideas.springboot.app.models.entity.Vehiculo;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("verVehiculo")
public class VehiculoPdfView extends AbstractPdfView{

	/**
	 * Metodo encargado de darle formato a nuestro pdf y escribir sobre el 
	 */
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			Vehiculo vehiculo = (Vehiculo) model.get("vehiculo");
			PdfPTable tabla = new PdfPTable(1);
			tabla.addCell("Datos del vehiculo");
			tabla.addCell(vehiculo.getMarca());
			tabla.addCell(vehiculo.getModelo());
			tabla.addCell(vehiculo.getTipo());
			tabla.addCell(vehiculo.getTipoCambio());
			tabla.addCell(String.valueOf(vehiculo.getNumPlazas()));
			tabla.addCell(String.valueOf(vehiculo.getNumeroOferta()));
			tabla.addCell(String.valueOf(vehiculo.getAnyo_vehiculo()));
			
			PdfPTable tabla2 = new PdfPTable(1);
			tabla2.addCell("Datos de la agencia");
			tabla2.addCell(vehiculo.getCodAgencia().getNombre());
			tabla2.addCell(vehiculo.getCodAgencia().getCodPostal().getNombre());
			tabla2.addCell(String.valueOf(vehiculo.getCodAgencia().getNumeTelefono()));
			document.add(tabla);
			document.add(tabla2);
			
			
			
		
		
	}

}
