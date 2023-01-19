package service;

/**
 *
 * @author Daniela
 */
public interface PDFOperacionesService {
    
 public void pdfTodasLasOperaciones(String usuario, String nombreCompleto, 
            String dia, String mes, String año);
 
 public void pdfOperacionesInternacionales(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
 
 public void pdfOperacionesNacionales(String usuario, String nombreCompleto, 
             String dia, String mes, String año);

}
