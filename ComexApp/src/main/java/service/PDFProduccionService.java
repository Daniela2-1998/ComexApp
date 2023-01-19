package service;

/**
 *
 * @author Daniela
 */
public interface PDFProduccionService {
    
   public void pdfTodoDeProduccion(String usuario, String nombreCompleto, 
            String dia, String mes, String año);
   
   public void pdfStock(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
   
   public void pdfSuministros(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
     
}
