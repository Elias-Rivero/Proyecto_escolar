
package es.ies;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 *
 * @author Jorge
 */
public class GenerarPDF {

// Se crea el documento
    Document documento = new Document();
    
    /**
     *Genera un documento pdf con 20 lineas.
     */
    public void abrir() {
// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
        try {
            FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");

// Se asocia el documento al OutputStream y se indica que el espaciado entre
// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

// Se abre el documento.
            documento.open();
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
