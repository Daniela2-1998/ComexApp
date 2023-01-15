package service;

import Daniela.ComexApp.Entity.Usuarios;
import Daniela.ComexApp.Frames.InicioSesion;
import Daniela.ComexApp.Frames.PaginaPrincipal;
import Daniela.ComexApp.Repository.UsuariosRepository;


import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Daniela
 */
public class InicioSesionService implements InicioSesionImp{

    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    int resultado;
    
    // datos usuarios
    Usuarios usuarios = new Usuarios();
    UsuariosService usuariosService = new UsuariosService();
    UsuariosRepository usuariosRepository;
    InicioSesion inicioses = new InicioSesion();
    
    boolean validezInicio;
    
    
    public static String usuario = "", contraseña = "", 
            nombre = "", apellido = "", rolCorrespondiente = "";
   
    
    // campo usuarios para creación, modificación, etc.
    JTextField textUsuario = new JTextField();
    JTextField textContraseña = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textApellido = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textTelefono = new JTextField();
    JComboBox  cmbRol = new JComboBox();
    
    
    JLabel jLabelMensaje = new JLabel();
   
    String contraseñaRecuperada;
    String usuarioRecuperado;
    
    
    
    //                              METODOS
    
    // métodos sesion
  public boolean inicioDeSesion(JTextField textUsuario, JPasswordField textContraseña){
      InicioSesion usuariosServ = new InicioSesion();
      
      Boolean resultado;
      
      usuario = textUsuario.getText().trim();
      contraseña = textContraseña.getText().trim();
        
      if(usuario.isBlank() && contraseña.isBlank()){
          JOptionPane.showMessageDialog(null, "Los campos estan vacios");
          if(usuario.isBlank()){
              JOptionPane.showMessageDialog(null, "Debes ingresar un usuario");
          }
          if(contraseña.isBlank()){
              JOptionPane.showMessageDialog(null, "Debes ingresar una contraseña");
          }
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
        
      } else {
          JOptionPane.showMessageDialog(null, "Debes ingresar un usuario y contraseña");
      } 
      return validezInicio;
   }

   public void cambioContraseña(String contraseñaAnterior, String contraseñaNueva,
           String confirmacion, String usuario){
       
       Boolean coincidencia; 
       int alternativaMensaje;
       
       if(contraseñaNueva.equals(confirmacion)){
           coincidencia = true;
       } else {
           JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no coinciden");
           coincidencia = false;
       }
       
       if(contraseñaAnterior.equals(contraseñaNueva)){
           coincidencia = false;
           JOptionPane.showMessageDialog(null, "La contraseña nueva es identica a la anterior");
       }
       
       if(coincidencia = true){
       
           String sql = "update usuarios set contraseña=? where contraseña = '" + 
                   contraseñaAnterior + "' and usuario = '" + usuario + "'";
                   
           try{
            
               conec = cn.Conexion();
               pst = conec.prepareStatement(sql);
               
               
                alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar la contraseña?");

            if (alternativaMensaje == 0) {

                pst.setString(1, contraseñaNueva); 
                pst.executeUpdate();
                
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }
      
           }catch(SQLException e){
               System.err.println("Erro al realizar cambio de contraseña " + e);
               JOptionPane.showMessageDialog(null, "No es posible realizar el cambio de contraseña");
           }
       } else{
           JOptionPane.showMessageDialog(null, "No es posible realizar el cambio de contraseña");
       }
       
   }
  
  
  
  
   // métodos obtención datos
   public String obtenerRolUsuario(String usuario, String contraseña){
       
       String rol = "";
       String rolCorrespondiente = null;
       
       String sql = "select rol from usuarios where usuario = '" + usuario 
               + "' and contraseña = '" + contraseña + "'";
       
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           if(rs.next()){
               rol = rs.getString("rol");
               
               if(rol.equals("Administrador")){
                   rolCorrespondiente = "Administrador";
               } else if (rol.equals("Importador")){
                   rolCorrespondiente = "Importador";
               } else if (rol.equals("Exportador")){
                   rolCorrespondiente = "Exportador";
               } else if (rol.equals("Agente")){
                   rolCorrespondiente = "Agente";
               } else if (rol.equals("Logistica")){
                   rolCorrespondiente = "Logistica";
               } else if (rol.equals("Marketing")){
                   rolCorrespondiente = "Marketing";
               } else {
                   JOptionPane.showMessageDialog(null, "El rol ingresado no es correcto");
             }
           }else {
               JOptionPane.showMessageDialog(null, "No es posible recuperar el rol");
           }

       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se puede obtener el rol "
                   + "correspondiente a " + usuario + "", "Error de obtención de rol", 0);
           System.err.println("No se puede obtener el rol correspondiente " + e);
       }
       return rolCorrespondiente;
   }
 

   public String recuperoContraseña (String usuario, String nombre, String apellido){
        
       int avanzar = 0;
       
       String sql = "select contraseña from usuarios where usuario = '" + usuario +
               "' and nombre = '" + nombre + "' and apellido = '" + apellido + "'";
       
       if(usuario.equals("")){
           avanzar++;
       }
       
       if(nombre.equals("")){
           avanzar++;
       }
       
       if(avanzar == 0){
           try{
               conec = cn.Conexion();
               pst = conec.prepareStatement(sql);
               rs = pst.executeQuery();
               
               if(rs.next()){
                   String contraseña = rs.getString("contraseña");
               }
               conec.close();
               
           }catch(SQLException e){
               System.err.println("No se puede recuperar la contraseña " + e);
               JOptionPane.showMessageDialog(null, "No es posible recuperar la "
                       + "contraseña de " + usuario);
           }
       }else {
           JOptionPane.showMessageDialog(null, "Usuario o nombre no encontrado");
       }
       return contraseñaRecuperada;
   }
   
   public Usuarios agregarUsuario(Integer id, String usuario, String contraseña, String nombre, 
           String apellido, String rol, String mail, String telefono, String status){
       
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
      
       String sql = "insert into usuarios values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
         
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
               pst.setString(9, status);
               
               pst.executeUpdate();
               conec.close();
               
               JOptionPane.showMessageDialog(null, "Creación de usuario éxitosa");
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "No es posible registrar al usuario");
               System.err.println("No es posible registrar al usuario " + e);
           }
       }else{
           JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos");
       }
       
       return usuarios;
   }

   
   
   
   
   
   
   
    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        InicioSesionService.usuario = usuario;
    }

    public static String getContraseña() {
        return contraseña;
    }

    public static void setContraseña(String contraseña) {
        InicioSesionService.contraseña = contraseña;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        InicioSesionService.apellido = apellido;
    }

    public static String getRolCorrespondiente() {
        return rolCorrespondiente;
    }

    public static void setRolCorrespondiente(String rolCorrespondiente) {
        InicioSesionService.rolCorrespondiente = rolCorrespondiente;
    }


   
  

}
