package service;


/**
 *
 * @author Daniela
 */
public interface OperacionInternacionalParticipantesService {

    public void ingresarConexionesOpInt(int numeroOpInt, String codigo);
    
    public void agregarIDContenedor(int idContenedor, int idOperacion);
    
    public void agregarIDProducto(int idProducto, int idOperacion);
    
    public void agregarIDDespachante(int idDespachante, int idOperacion);
    
    public void agregarIDImportador(int idImportador, int idOperacion);
    
    public void agregarIDExportador(int idExportador, int idOperacion);
}
