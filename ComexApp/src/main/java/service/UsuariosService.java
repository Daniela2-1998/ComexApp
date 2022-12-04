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
public class UsuariosService /*implements UsuariosImpl*/{
    
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
    

    public void modificarTodosLosDatosDeUsuarios(int idMod, String usuarioMod, 
            String contraseñaMod, String nombreMod, String apellidoMod, 
            String rolMod, String mailMod, String telefonoMod, String statusMod){
        
     int alternativaMensaje;
     String sql = "update usuarios set id_usuarios=?, usuario=?, nombre=?, "
             + "apellido=?, rol=?, mail=?, telefono=?, status=?";
     
     try{
         conec = cn.Conexion();
         pst = conec.prepareStatement(sql);
         
        alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");
            
        if(alternativaMensaje == 0){
         
            pst.setInt(1, idMod);
            pst.setString(2, apellidoMod);
            pst.setString(3, contraseñaMod);
            pst.setString(4, mailMod);
            pst.setString(5, nombreMod);
            pst.setString(6, rolMod);
            pst.setString(7, telefonoMod);
            pst.setString(8, usuarioMod);
            pst.setString(9, statusMod);

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

    public void obtenerDatosDelUsuario(String usuario){
        
        String sql = "select * from usuarios where usuario = '" + usuario + "'";
        
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
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del usuario solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "usuario solicitado");
        }
    }

   

}
