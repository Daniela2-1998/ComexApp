package service;

import Daniela.ComexApp.Entity.Usuarios;
import java.util.List;
import java.util.Optional;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface UsuariosImpl{

  public void modificarTodosLosDatosDeUsuarios(int idMod, String usuario, String usuarioMod, 
            String contraseñaMod, String nombreMod, String apellidoMod, 
            String rolMod, String mailMod, String telefonoMod, String statusMod);
  
  public void modificarAlgunosDatosDeUsuarios(String usuario, String nombreMod, 
             String apellidoMod, String mailMod, String telefonoMod);
  
  public void obtenerDatosDelUsuario(JTextField textUsuarioBuscado, 
            JTextField textID, JTextField textUsuario, JTextField textContraseña, 
            JTextField textNombre, JTextField textApellido, JTextField textMail, 
            JTextField textTelefono, JComboBox cmbRol, JComboBox cmbStatus);
  
  public boolean eliminarUsuario(String usuario, int id);
  
}

