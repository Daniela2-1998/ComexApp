package service;

import Daniela.ComexApp.Entity.Usuarios;
import Daniela.ComexApp.Frames.InicioSesion;
import Daniela.ComexApp.Frames.PaginaPrincipal;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Daniela
 */
public class UsuariosServicio implements UsuariosServImpl{

    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    int resultado;
    
    // datos usuarios
    Usuarios usuarios = new Usuarios();
    InicioSesion inicioses = new InicioSesion();
    boolean validezInicio;
    
    // campo usuarios para creación, modificación, etc.
    JTextField textUsuario = new JTextField();
    JTextField textContraseña = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textApellido = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textTelefono = new JTextField();
    JComboBox  cmbRol = new JComboBox();
    
    
    JLabel jLabelMensaje = new JLabel();
   
    //UsuariosServ usuariosServ = new UsuariosServ();
    
    
    
    //   METODOS
  public boolean inicioDeSesion(JTextField textUsuario, JPasswordField textContraseña){
      UsuariosServicio usuariosServ = new UsuariosServicio();
      
      Boolean resultado;
      String usuario, contraseña;
      
      usuario = textUsuario.getText().trim();
      contraseña = textContraseña.getText().trim();
        
      if(usuario.isBlank() && contraseña.isBlank()){
          JOptionPane.showMessageDialog(null, "Los campos estan vacios");
      } 
      
      String sql = "select usuario, contraseña from usuarios where usuario = '" 
                + usuario + "' and contraseña = '" + contraseña + "'";

      if(!usuario.equals("") && !contraseña.equals("")){  
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
              resultado = true;
              return resultado;
            } else{
              resultado = false;
              return resultado;
            }

        }catch(SQLException e){
            System.err.println("No se pudo iniciar sesión " + e);
            JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión");
        }
        
      } 
      return validezInicio;
   }

  
 
  
   public Usuarios agregarUsuario(Integer id, String usuario, String contraseña, String nombre, 
           String apellido, String rol, String mail, String telefono){
       
       int avanzar = 0;
       
       if(usuario.equals("")){
           textUsuario.setBackground(Color.red);
           avanzar++;
       }
       if(contraseña.equals("")){
           textContraseña.setBackground(Color.red);
           avanzar++;
       }
       if(nombre.equals("")){
           textNombre.setBackground(Color.red);
           avanzar++;
       }
       if(apellido.equals("")){
           textApellido.setBackground(Color.red);
           avanzar++;
       }
       if(mail.equals("")){
           textMail.setBackground(Color.red);
           avanzar++;
       }
       if(telefono.equals("")){
           textTelefono.setBackground(Color.red);
           avanzar++;
       }
      
       String sql = "insert into usuarios values (?, ?, ?, ?, ?, ?, ?, ?)";
         
       if(avanzar == 0){
           try{
               conec = cn.Conexion();
               pst = conec.prepareStatement(sql);
               
               pst.setInt(1, id);
               pst.setString(2, apellido);
               pst.setString(3, contraseña);
               pst.setString(4, mail);
               pst.setString(5, nombre);
               pst.setString(6, rol);
               pst.setString(7, telefono);
               pst.setString(8, usuario);
               
               
               pst.executeUpdate();
               conec.close();
               
               usuarios.setId(id);
               usuarios.setUsuario(usuario);
               usuarios.setContraseña(contraseña);
               usuarios.setNombre(nombre);
               usuarios.setApellido(apellido);
               usuarios.setMail(mail);
               usuarios.setTelefono(telefono);
               usuarios.setRol(rol);
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "No es posible registrar al usuario");
               System.err.println("No es posible registrar al usuario " + e);
           }
       }else{
           JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos");
       }
       
       return usuarios;
   }

   
   
   
 /*  // VER
   public Usuarios listarUsuario(Usuarios usuario){
       String sql = "insert into usuarios (usuario, contraseña, nombre, apellido, "
               + "rol, mail, telefono) values (?, ?, ?, ?, ?, ?, ?)";
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           
           pst.setString(1, usuario.getUsuario());
           pst.setString(2, usuario.getContraseña());
           pst.setString(3, usuario.getNombre());
           pst.setString(4, usuario.getApellido());
           pst.setString(5, usuario.getRol());
           pst.setString(6, usuario.getMail());
           pst.setString(7, usuario.getTelefono());
           
           pst.executeUpdate();
           conec.close();
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error al listar usuario");
           System.err.println("Error al listar usuario");
       }
       return usuario;
   }
   
  */

   
   
    public boolean isValidezInicio() {
        return validezInicio;
    }

    public void setValidezInicio(boolean validezInicio) {
        this.validezInicio = validezInicio;
    }
   


}
