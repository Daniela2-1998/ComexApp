package service;

/**
 *
 * @author Daniela
 */
public interface FondoPaginaPrincipalService {
    
    public void guardarFondo(String usuario);
    
    public String recuperarFondoElegido(String usuario);
    
    public void cambiarAFondoDefecto(String usuario);
    
    public void cambiarAFondo(String usuario);
    
    public void cambiarAFondo3(String usuario);
    
    public void cambiarAFondo4(String usuario);
    
    public void eliminarFondo(String usuario, int id);
}
