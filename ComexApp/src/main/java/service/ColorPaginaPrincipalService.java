package service;

/**
 *
 * @author Daniela
 */
public interface ColorPaginaPrincipalService {
    
    public void crearColor(String usuario);
    
    public String recuperarColorElegido(String usuario);
    
    public void cambiarAColorDefecto(String usuario);
    
    public void cambiarAColorInvertido(String usuario);
    
    public void eliminarColor(String usuario, int id);
}
