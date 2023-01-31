package service;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class MensajesDeObjetivosImpl {
    
    // fields
    JTextField textID = new JTextField();
    JTextField textFechaLimite = new JTextField();
    JTextField textFechaRegistro = new JTextField();
    JTextField textObjetivo = new JTextField();
    JTextArea textDescripcion = new JTextArea();
    JComboBox cmbNivelImportancia = new JComboBox();
    JComboBox cmbNivelStatus = new JComboBox();
    JComboBox cmbNivelVisibilidad = new JComboBox();
    JTextField textVisibilidad = new JTextField();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    public boolean establecerObjetivo(int ID, String descripcion, String fechaLimite, 
            String fechaRegistro, String nivelImportancia, String objetivo, 
            String status, String usuario, String visibilidad){
        
        Boolean recepcion;
        int avanzar = 0;

       if(descripcion.equals("")){
           textDescripcion.setBackground(Color.red);
           avanzar++;
       }
       if(objetivo.equals("")){
           textObjetivo.setBackground(Color.red);
           avanzar++;
       }

        String sql = "insert into objetivos values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, descripcion);
                pst.setString(3, fechaLimite);
                pst.setString(4, fechaRegistro);
                pst.setString(5, nivelImportancia);
                pst.setString(6, status);
                pst.setString(7, usuario);
                pst.setString(8, visibilidad);
                pst.setString(9, objetivo);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se registró un nuevo "
                        + "objetivo en el sistema ComexApp");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear el objetivo");
                System.err.println("No es posible crear el objetivo" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
     
  
    
    
    public void obtenerObjetivos(JLabel jLabelObjetivoRec1, JLabel jLabelFechaPub1, 
            JTextArea textDetalles1, JLabel jLabelImportancia1, JLabel jLabelFechaObj1, 
            JLabel jLabelID1, String sql){ 
            
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                jLabelObjetivoRec1.setText(rs.getString("objetivo")); 
                jLabelFechaPub1.setText(rs.getString("fecha_registro"));
                textDetalles1.setText(rs.getString("descripcion"));
                jLabelImportancia1.setText(rs.getString("importancia"));
                jLabelFechaObj1.setText(rs.getString("fecha_fin"));
                jLabelID1.setText(rs.getString("id_objetivo"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No es posible recuperar objetivo");
                System.err.println("No es posible conseguir el objetivo");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener el objetivo" + e);
            JOptionPane.showMessageDialog(null, "No se puede conseguir el objetivo");
        }
        
    }
    
    
    public String recuperarNivelImportancia(int ID){
        
        String nivelImportancia = null;
        String sql = "select importancia from objetivos where id_objetivo = '" + ID + "'";
        
         try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                nivelImportancia = rs.getString("importancia");
            } else {
                JOptionPane.showMessageDialog(null, "No es posible recuperar nivel de importancia");
                System.err.println("No es posible recuperar el nivel de importancia");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener el nivel" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener el nivel");
        }
        return nivelImportancia;
    }
     
       
    public void recuperarProximos3Registros(JLabel jLabelObjetivoRec1, JLabel jLabelFechaPub1, 
            JTextArea textDetalles1, JLabel jLabelImportancia1, JLabel jLabelFechaObj1, 
            JLabel jLabelID1, String rol){
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate tresDiasDespues = LocalDate.now().plusDays(3);

        /*String sql = "select fecha_fin, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_registro, status from objetivos where "
                + "fecha_fin between '" + fechaActual + "' and '" + tresDiasDespues 
                + "' order by fecha_fin desc fetch first 3 rows only";
       */
        
        String sql = "select objetivo, fecha_registro, descripcion, importancia, "
                + "fecha_fin, id_objetivo from objetivos where fecha_fin = '" + 
                fechaActual + "' limit 1";

         try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();

            if(rs.next()){

                    jLabelObjetivoRec1.setText(rs.getString("objetivo")); 
                    jLabelFechaPub1.setText(rs.getString("fecha_registro"));
                    textDetalles1.setText(rs.getString("descripcion"));
                    jLabelImportancia1.setText(rs.getString("importancia"));
                    jLabelFechaObj1.setText(rs.getString("fecha_fin"));
                    jLabelID1.setText(rs.getString("id_objetivo"));
                } else {
                System.err.print("No pudimos obtener los datos");
            }
            
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener el objetivo" + e);
            JOptionPane.showMessageDialog(null, "No se puede conseguir el objetivo");
        }
        
        
    }
  
    public boolean eliminarObjetivo(String usuario, int id){
       
        String sql = "delete from objetivos where usuario_creador = '" + usuario + "' "
               + "and id_objetivo = '" + id + "'";
       
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
