package service;

import Daniela.ComexApp.Controller.UsuariosController;
import Daniela.ComexApp.Entity.Usuarios;
import Daniela.ComexApp.Repository.UsuariosRepository;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import org.springframework.stereotype.Service;

/**
 *
 * @author Daniela
 */
@Service
public class UsuariosImpl implements UsuariosService{
    
    // campo usuarios para creación, modificación, etc.
    JTextField textID = new JTextField();
    JTextField textUsuario = new JTextField();
    JTextField textContraseña = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textApellido = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textTelefono = new JTextField();
    JComboBox  cmbRol = new JComboBox();
    JComboBox cmbStatus = new JComboBox();
    
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    int resultado;
    
    Boolean eliminacionAprobada;
    
    String nombreCompleto;
    String nombre;
    String apellido;
    int ID;
    
    //                              METODOS   
    
    // métodos modificar todos los datos
    public void modificarTodosLosDatosDeUsuarios(int idMod, String usuario, String usuarioMod, 
            String contraseñaMod, String nombreMod, String apellidoMod, 
            String rolMod, String mailMod, String telefonoMod, String statusMod){
        
     int alternativaMensaje;
     String sql = "update usuarios set apellido=?, contraseña=?, mail=?, "
             + "nombre=?, rol=?, telefono=?, usuario=?, status=? where "
             + "usuario = '" + usuario + "'";
     
     try{
         conec = cn.Conexion();
         pst = conec.prepareStatement(sql);
         
        alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");
            
        if(alternativaMensaje == 0){
          
            pst.setString(1, apellidoMod);
            pst.setString(2, contraseñaMod);
            pst.setString(3, mailMod);
            pst.setString(4, nombreMod);
            pst.setString(5, rolMod);
            pst.setString(6, telefonoMod);
            pst.setString(7, usuarioMod);
            pst.setString(8, statusMod);

            pst.executeUpdate();
            conec.close();
          
        } else {
         conec.close();
         JOptionPane.showMessageDialog(null, "No se modificaron los datos");
        }
        
     }catch(SQLException e){
         System.err.println("No se pudo conectar con la base de datos para"
                 + "modificar datos" + e);
     }
    }

    // métodos modificar todos los datos (menú rápido de administracíón)
     public void modificarAlgunosDatosDeUsuarios(String usuario, String nombreMod, 
             String apellidoMod, String mailMod, String telefonoMod){
        
     int alternativaMensaje;
     String sql = "update usuarios set apellido=?, mail=?, nombre=?, "
             + "telefono=? where usuario = '" + usuario + "'";
     
     try{
         conec = cn.Conexion();
         pst = conec.prepareStatement(sql);
         
        alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");
            
        if(alternativaMensaje == 0){
          
            pst.setString(1, apellidoMod);
            pst.setString(2, mailMod);
            pst.setString(3, nombreMod);
            pst.setString(4, telefonoMod);


            pst.executeUpdate();
            conec.close();
          
        } else {
         conec.close();
         JOptionPane.showMessageDialog(null, "No se modificaron los datos");
        }
        
     }catch(SQLException e){
         System.err.println("No se pudo conectar con la base de datos para"
                 + "modificar datos" + e);
     }
    }
     
    public int obtenerIDUsuario (String usuario, String nombre){
        
        String sql = "select id_usuarios from usuarios where usuario = '" + usuario +
                "' and nombre = '" + nombre + "'";
          
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                ID = rs.getInt("id_usuarios") ; 
            }
           
        }catch(SQLException e){
            System.err.println("No es posible recuperar el ID" + e);
            JOptionPane.showMessageDialog(null, "No es posible obtener el ID del usuario ");
        }
        return ID;
        
    }
     
    public String obtenerNombre(String usuario){
        
        String sql = "select nombre from usuarios where usuario = '" + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
               nombre = rs.getString("nombre") ; 
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar nombre" + e);
            JOptionPane.showMessageDialog(null, "No es posible obtener nombre del usuario ");
        }
        return nombre;
    }    
    
       public String obtenerApellido(String usuario){
        
        String sql = "select apellido from usuarios where usuario = '" + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                apellido = rs.getString("apellido") ; 
            }
           
        }catch(SQLException e){
            System.err.println("No es posible recuperar el apellido" + e);
            JOptionPane.showMessageDialog(null, "No es posible obtener apellido del usuario ");
        }
        return nombre;
    }    
    
     
    public String obtenerNombreCompleto(String usuario){
        
        String sql = "select nombre, apellido from usuarios where usuario = '" + usuario + "'";
         
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String nombre = rs.getString("nombre") ;
                String apellido = rs.getString("apellido"); 
                nombreCompleto = nombre + " " + apellido;
            }
           
        }catch(SQLException e){
            System.err.println("No es posible recuperar nombre y apellido " + e);
            JOptionPane.showMessageDialog(null, "No es posible obtener nombre completo del usuario ");
        }
        return nombreCompleto;
    }
    
    
    
    // método obtención datos del usuario
    public void obtenerDatosDelUsuario(String usuarioBuscado, 
            JTextField textID, JTextField textUsuario, JTextField textContraseña, 
            JTextField textNombre, JTextField textApellido, JTextField textMail, 
            JTextField textTelefono, JComboBox cmbRol, JComboBox cmbStatus){
        
        
        String sql = "select * from usuarios where usuario = '" + usuarioBuscado + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_usuarios"));
                textUsuario.setText(rs.getString("usuario"));
                textContraseña.setText(rs.getString("contraseña"));
                textNombre.setText(rs.getString("nombre"));
                textApellido.setText(rs.getString("apellido"));
                textMail.setText(rs.getString("mail"));
                textTelefono.setText(rs.getString("telefono"));
                cmbRol.setSelectedItem("rol");
                cmbStatus.setSelectedItem("status");
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del usuario solicitado");
                System.err.println("No es posible conseguir los datos del usuario "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del usuario solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "usuario solicitado");
        }
    }

    // método eliminar usuario
    public boolean eliminarUsuario(String usuario, int id) {
        
       String sql = "delete from usuarios where usuario = '" + usuario + "' "
               + "and id_usuarios = '" + id + "'";
       
       int alternativaMensaje;
       Boolean aprobado;
       
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           
           
           alternativaMensaje = JOptionPane.showConfirmDialog(null, "Estás por eliminar un registro, "
                    + "¿está seguro de que quieres hacerlo?");
           
           if(alternativaMensaje == 0){
               pst.executeUpdate();
               aprobado = true;
               JOptionPane.showMessageDialog(null, "Eliminación de registro "
                    + "éxitosa");
               conec.close();
               return aprobado;
           } else {
               conec.close();
               aprobado = false;
               JOptionPane.showMessageDialog(null, "No se ha eliminado el registro");
               return aprobado;
           }
       }catch(SQLException e){
           System.err.println("No se pudo eliminar el registro solicitado " + e);
           JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro "
                   + "solicitado");
       }
       return eliminacionAprobada;
    }

   

}
