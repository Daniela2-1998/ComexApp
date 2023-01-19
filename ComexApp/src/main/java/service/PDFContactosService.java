package service;

/**
 *
 * @author Daniela
 */
public interface PDFContactosService {
    
    public void pdfTodosLosContactos(String usuario, String nombreCompleto, 
            String dia, String mes, String año);
    
    public void pdfExportadores(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
     
    public void pdfImportadores(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
     
    public void pdfDespachantes(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
    
    public void pdfMaritimasAereo(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
    
    public void pdfAgendaPersonal(String usuario, String nombreCompleto, 
             String dia, String mes, String año);
     
}
