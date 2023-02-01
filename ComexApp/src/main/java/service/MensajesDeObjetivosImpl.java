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
    JTextField textFechaRegistro = new JTextField();
    JTextField textTitulo = new JTextField();
    JTextField textObjetivoAsociado = new JTextField();
    JTextArea textContenido = new JTextArea();
    JComboBox cmbNivelVisibilidad = new JComboBox();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    public boolean crearMensaje(int ID, String contenido, String objetivoAsociado, 
            String titulo, String usuario, String visibilidad, Date fechaPublicacion){
        
        Boolean recepcion;
        int avanzar = 0;

       if(contenido.equals("")){
           textContenido.setBackground(Color.red);
           avanzar++;
       }
       if(titulo.equals("")){
           textTitulo.setBackground(Color.red);
           avanzar++;
       }
       if(objetivoAsociado.equals("")){
           textObjetivoAsociado.setBackground(Color.red);
           avanzar++;
       }

        String sql = "insert into mensajes_objetivos values (?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, contenido);
                pst.setString(3, objetivoAsociado);
                pst.setString(4, titulo);
                pst.setString(5, usuario);
                pst.setString(6, visibilidad);
                pst.setDate(7, fechaPublicacion);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Mensaje creado");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear el mensaje");
                System.err.println("No es posible crear el mensaje" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
     
  
    
    
    public void obtenerMensajeBuscado(String busquedaMensaje, JLabel jLabelFechaMensaje, 
            JLabel jLabelObjetivoAsociado, JLabel jLabelTituloMensaje, 
            JTextArea textMensaje, JLabel jLabelUsuario){ 
            
        String sql = "select fecha_publicacion, objetivo_asociado, titulo, contenido, "
                + "usuario_emisor from mensajes_objetivos where objetivo_asociado = '" 
                + busquedaMensaje + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                jLabelFechaMensaje.setText(rs.getString("fecha_publicacion")); 
                jLabelObjetivoAsociado.setText(rs.getString("objetivo_asociado"));
                jLabelTituloMensaje.setText(rs.getString("titulo"));
                textMensaje.setText(rs.getString("contenido"));
                jLabelUsuario.setText(rs.getString("usuario"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No es posible recuperar el mensaje");
                System.err.println("No es posible conseguir el mensaje");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener el mensaje" + e);
            JOptionPane.showMessageDialog(null, "No se puede conseguir el mensaje");
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
