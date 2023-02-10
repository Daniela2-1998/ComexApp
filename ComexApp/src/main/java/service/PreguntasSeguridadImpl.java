package service;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class PreguntasSeguridadImpl implements PreguntasSeguridadService{
    
     // fields
    JTextField IDPreguntas = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textPreguntaUno = new JTextField();
    JTextField textPreguntaDos = new JTextField();
    JTextField textPreguntaTres = new JTextField();
    JTextField textPreguntaExtra = new JTextField();
    
    JComboBox cmbPreguntaUno = new JComboBox();
    JComboBox cmbPreguntaDos = new JComboBox();
    JComboBox cmbPreguntaTres = new JComboBox();
    JComboBox cmbPreguntaExtra = new JComboBox();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada, preguntaUno,
            preguntaDos, preguntaTresC;
    
    
    
    
    public boolean crearPreguntasDeSeguridad(int ID, String usuario, String nombre, 
            String preguntaUno, String preguntaDos, String preguntaTres,
            String eleccionUno, String eleccionDos, String eleccionTres){
        
        Boolean recepcion;
        int avanzar = 0;

       if(preguntaUno.equals("")){
           textPreguntaUno.setBackground(Color.red);
           avanzar++;
       }
       if(preguntaDos.equals("")){
           textPreguntaDos.setBackground(Color.red);
           avanzar++;
       }
       if(preguntaTres.equals("")){
           textPreguntaTres.setBackground(Color.red);
           avanzar++;
       }
       
       if(usuario.equals("")){
           avanzar++;
       }
       
       if(nombre.equals("")){
           avanzar++;
       }
        
        String sql = "insert into preguntas_seguridad values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        String preguntaExtra = "";
        String eleccionExtra = "¿Cúal es el nombre de tu primera mascota?";
        
        if(avanzar == 0){
            
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, nombre);
                pst.setString(3, preguntaDos);
                pst.setString(4, preguntaExtra);
                pst.setString(5, preguntaTres);
                pst.setString(6, preguntaUno);
                pst.setString(7, usuario);
                pst.setString(8, eleccionDos);
                pst.setString(9, eleccionExtra);
                pst.setString(10, eleccionTres);
                pst.setString(11, eleccionUno);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Preguntas de seguridad "
                        + "del usuario " + usuario + " registradas");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se pueden registrar las "
                        + "preguntas de seguridad para " + usuario);
                System.err.println("No es posible crear preguntas de seguridad" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }

    public void modificarDatosContactoAgendaPersonal(String preguntaUnoMod, 
              String preguntaDosMod, String preguntaTresMod, String eleccionUnoMod, 
              String eleccionDosMod, String eleccionTresMod, String nombre, String usuario){
        
        int alternativaMensaje;

        String sql = "update preguntas_seguridad set pregunta_dos=?, pregunta_tres=?, "
                + "pregunta_uno=?, eleccion_dos=?, eleccion_tres=?, eleccion_uno=? "
                + "where nombre = '" + nombre + "' and usuario ='" + usuario + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, preguntaDosMod);
                pst.setString(2, preguntaTresMod);
                pst.setString(3, preguntaUnoMod);
                pst.setString(4, eleccionDosMod);
                pst.setString(5, eleccionTresMod);
                pst.setString(6, eleccionUnoMod);
                
                
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para"
                    + "modificar datos" + e);
        }
    }
    
     
    public void recuperarLasPreguntasDeSeguridadYSusRespuestas(JTextField textPreguntaUno, 
            JTextField textPreguntaDos, JTextField textPreguntaTres, 
            JComboBox cmbPreguntaUno, JComboBox cmbPreguntaDos, JComboBox cmbPreguntaTres,
            String usuario, String nombre){
        
        String sql = "select pregunta_dos, pregunta_tres, pregunta_uno, eleccion_dos, "
                + "eleccion_tres, eleccion_uno from preguntas_seguridad where "
                + "usuario = '" + usuario + "' and nombre = '" + nombre + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                textPreguntaUno.setText(rs.getString("pregunta_uno"));
                textPreguntaDos.setText(rs.getString("pregunta_dos"));
                textPreguntaTres.setText(rs.getString("pregunta_tres"));
                cmbPreguntaUno.setSelectedItem("eleccion_uno");
                cmbPreguntaDos.setSelectedItem("eleccion_dos");
                cmbPreguntaTres.setSelectedItem("eleccion_tres");
                
            } else {
                JOptionPane.showMessageDialog(null, "No hay preguntas de seguridad "
                        + "cargadas para " + usuario);
                System.err.println("No hay preguntas cargadas");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del usuario solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "usuario solicitado");
        }
    }

    public String recuperarPreguntaUno(String usuario, String nombre){
        
        String preguntaUno = null;
        
        String sql = "select eleccion_uno from preguntas_seguridad where "
                + "usuario = '" + usuario + "' and nombre = '" + nombre + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
   
                preguntaUno = rs.getString("eleccion_uno");
                
            } else {
                JOptionPane.showMessageDialog(null, "No hay preguntas de seguridad "
                        + "cargadas para " + usuario);
                System.err.println("No hay preguntas cargadas");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del usuario solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "usuario solicitado");
        }
        return preguntaUno;
    }
    
    public String recuperarPreguntaDos(String usuario, String nombre){
        
        String preguntaDos = null;
        
        String sql = "select eleccion_dos from preguntas_seguridad where "
                + "usuario = '" + usuario + "' and nombre = '" + nombre + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
   
                preguntaDos = rs.getString("eleccion_dos");
                
            } else {
                JOptionPane.showMessageDialog(null, "No hay preguntas de seguridad "
                        + "cargadas para " + usuario);
                System.err.println("No hay preguntas cargadas");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del usuario solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "usuario solicitado");
        }
        return preguntaDos;
    }
    
    
    public String recuperarPreguntaTres(String usuario, String nombre){
        
        String preguntaTres = null;
        
        String sql = "select eleccion_tres from preguntas_seguridad where "
                + "usuario = '" + usuario + "' and nombre = '" + nombre + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
   
                preguntaTres = rs.getString("eleccion_tres");
                
            } else {
                JOptionPane.showMessageDialog(null, "No hay preguntas de seguridad "
                        + "cargadas para " + usuario);
                System.err.println("No hay preguntas cargadas");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del usuario solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "usuario solicitado");
        }
        return preguntaTres;
    }
    
    
    
    
  
     
    public String recuperarContraseña(String usuario){
        
        String contraseña = null;
        String sql = "select contraseña from usuarios where usuario = '" + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                contraseña = rs.getString("contraseña");
            }
        }catch(SQLException e){
            System.err.println("No es posible recuperar contraseña " + e);
        }
        return contraseña;
    }
    
    public String recuperoEleccionUno(String usuario){
        
        String preguntaUnoC = null;
        String sql = "select pregunta_uno from preguntas_seguridad where usuario = '" 
                + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                return preguntaUnoC = rs.getString("pregunta_uno");
            }
            conec.close();
           
        }catch(SQLException e){
            System.err.println("No es posible recuperar los datos " + e);
        }

        return preguntaUnoC;
    }
    
    public String recuperoEleccionDos(String usuario){
        
        String preguntaDosC = null;
        String sql = "select pregunta_dos from preguntas_seguridad where usuario = '" 
                + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                preguntaDosC = rs.getString("pregunta_dos");

            }
            conec.close();
           
        }catch(SQLException e){
            System.err.println("No es posible recuperar los datos " + e);
        }
        return preguntaDosC;
    }
    
    public String recuperoEleccionTres(String usuario){
        
        String preguntaTresC = null;
        String sql = "select pregunta_tres from preguntas_seguridad where usuario = '" 
                + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                preguntaTresC = rs.getString("pregunta_tres");
            }
            conec.close();
           
        }catch(SQLException e){
            System.err.println("No es posible recuperar los datos " + e);
        }
        return preguntaTresC;
    }
      
    public boolean eliminarPreguntasDeSeguridad(String nombre, int id){
       
        String sql = "delete from preguntas_seguridad where nombre = '" + nombre + "' "
               + "and id_preguntas = '" + id + "'";
       
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
   
    

