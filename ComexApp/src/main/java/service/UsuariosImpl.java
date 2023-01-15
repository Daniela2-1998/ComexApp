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
  
 public int obtenerIDUsuario (String usuario, String nombre);
 
 public String obtenerNombre(String usuario);
  
 public String obtenerApellido(String usuario);
 
 public String obtenerNombreCompleto(String usuario);
  
  public void obtenerDatosDelUsuario(String UsuarioBuscado, 
            JTextField textID, JTextField textUsuario, JTextField textContraseña, 
            JTextField textNombre, JTextField textApellido, JTextField textMail, 
            JTextField textTelefono, JComboBox cmbRol, JComboBox cmbStatus);
  
  public boolean eliminarUsuario(String usuario, int id);
  
}

