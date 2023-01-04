package service;

import Daniela.ComexApp.Entity.Usuarios;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface InicioSesionImp {
    
    public boolean inicioDeSesion(JTextField textUsuario, JPasswordField textContraseña);
    
    public void cambioContraseña(String contraseñaAnterior, String contraseñaNueva,
           String confirmacion, String usuario);
    
    public String obtenerRolUsuario(String usuario, String contraseña);
    
    public Usuarios agregarUsuario(Integer id, String usuario, String contraseña, 
            String nombre, String apellido, String rol, String mail, String telefono, String status);
    
}
