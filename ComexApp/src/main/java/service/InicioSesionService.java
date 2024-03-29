package service;

import Daniela.ComexApp.Entity.Usuarios;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface InicioSesionService {
    
    public boolean inicioDeSesion(JTextField textUsuario, JPasswordField textContraseña);
    
    public void cambioContraseña(String contraseñaAnterior, String contraseñaNueva,
           String confirmacion, String usuario);
    
    public String obtenerRolUsuario(String usuario, String contraseña);
    
    public String recuperoContraseña (String usuario, String nombre, String apellido);
 
    public Usuarios agregarUsuario(Integer id, String usuario, String contraseña, 
            String nombre, String apellido, String rol, String mail, String telefono, String status);
    
    public boolean verificarQueNoExistaUsuario(String usuario);
    
    public boolean verificarQueExistaUsuarioAdmin(String usuario);
    
}
