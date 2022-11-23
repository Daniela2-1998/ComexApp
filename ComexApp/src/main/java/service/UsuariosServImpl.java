package service;

import Daniela.ComexApp.Entity.Usuarios;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface UsuariosServImpl {
    
    public boolean inicioDeSesion(JTextField textUsuario, JPasswordField textContraseña);
    
    public Usuarios agregarUsuario(Integer id, String usuario, String contraseña, 
            String nombre, String apellido, String rol, String mail, String telefono);
    
}
