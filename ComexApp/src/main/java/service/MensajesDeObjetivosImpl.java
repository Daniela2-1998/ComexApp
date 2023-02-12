package service;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class MensajesDeObjetivosImpl implements MensajesDeObjetivosService{
    
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

        String sql = "insert into mensajes_objetivos values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            
            Time horaRegistro = Time.valueOf(LocalTime.now());
            Boolean visto = false;
            
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
                pst.setBoolean(8, visto);
                pst.setTime(9, horaRegistro);
                
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
                jLabelUsuario.setText(rs.getString("usuario_emisor"));
                
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
    

    public Boolean verificarMensajesSinVer(String usuario, String rol){ 
        
        Boolean visto = null;
        
        String sql = "select titulo, fecha_publicacion, hora_registro, visto from "
                + "mensajes_objetivos where visto = 'false'";
                
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                   String titulo = rs.getString("titulo");
                   Date fechaPublicacion = rs.getDate("fecha_publicacion");
                   Time horaPublicacion = rs.getTime("hora_registro");
                   visto = rs.getBoolean("visto");
                   
                if (visto.equals(false)) {

                    MensajesImpl mensajes = new MensajesImpl();
                    mensajes.notificacionMensajesDeObjetivosSinVer(titulo, fechaPublicacion,
                            horaPublicacion);

                } else if (visto.equals(true)) {
                    System.err.println("No hay mensajes disponibles");
                }
            } else {
                
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No hay mensajes disponibles " + e);
        }
  
        return visto;
    }
    

    
    
    public void marcarMensajesComoVisto(String titulo){
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update mensajes_objetivos set visto =? "
                    + "where titulo = '" + titulo + "'");
            
            pst.setBoolean(1, true);
            pst.executeUpdate();
            
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible marcar como visto " + e);
        }
    }

  
    
     
    public boolean eliminarMensajeDeObjetivo(String usuario, int id){
       
        String sql = "delete from mensajes_objetivos where usuario_emisor = '" + usuario + "' "
               + "and id_mensaje_objetivo = '" + id + "'";
       
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
