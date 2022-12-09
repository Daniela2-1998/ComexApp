package service;

/**
 *
 * @author Daniela
 */
public interface ImportadoresImpl {
    
    public boolean registroDeImportador(int ID, String cuit, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosPedidos, String status);
}
