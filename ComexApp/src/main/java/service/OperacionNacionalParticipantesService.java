package service;

/**
 *
 * @author Daniela
 */
interface OperacionNacionalParticipantesService {
    
    public void ingresarConexionesOpNac(int numeroOpNac, String comprador, 
            String vendedor, String status);
    
    public void agregarIDProducto(int idProducto, int idOperacion);
    
    public boolean verificarIngresoProducto();
    
    public int obtenerCantidadDeProductos(int id);
    
    public String tipoOperacion(int id);
    
    public void recuperarStockQueSeActualizaHoy();
    
    public boolean eliminarConexion(int id);
}
