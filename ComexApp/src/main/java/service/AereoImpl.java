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
public class AereoImpl implements AereoService{
   
    
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextField textID = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textNumero = new JTextField();
    JTextArea textRequisitos = new JTextArea();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    String mail;
    
    public boolean registroAereo(int ID, String mail, String empleado, 
            String empresa, String numeroContacto, String requisitos){
        
        Boolean recepcion;
        int avanzar = 0;

       if(empleado.equals("")){
           textEmpleado.setBackground(Color.red);
           avanzar++;
       }
       if(empresa.equals("")){
           textEmpresa.setBackground(Color.red);
           avanzar++;
       }
       if(mail.equals("")){
           textMail.setBackground(Color.red);
           avanzar++;
       }
       if(numeroContacto.equals("")){
           textNumero.setBackground(Color.red);
           avanzar++;
       }
       if(requisitos.equals("")){
           textRequisitos.setBackground(Color.red);
           avanzar++;
       }
        
        String sql = "insert into aereo values (?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, empresa);
                pst.setString(3, mail);
                pst.setString(4, empleado);
                pst.setString(5, numeroContacto);
                pst.setString(6, requisitos);


                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el contacto  " 
                        + empleado + " de la aerolínea" + empresa);
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un "
                        + "contacto de la aerolínea " + empresa);
                System.err.println("No es posible crear el contacto de la aerolínea" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
     public void modificarAereo(String empleado,int IDMod, String mailMod, String empleadoMod, 
            String empresaMod, String numeroContactoMod, String requisitosMod){
        
        int alternativaMensaje;

        String sql = "update aereo set aerolinea=?, empleado=?, numero_contacto=?, "
                + "requisitos=?, mail=? where empleado = '" + empleado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, empresaMod);
                pst.setString(2, empleadoMod);
                pst.setString(3, numeroContactoMod);
                pst.setString(4, requisitosMod);
                pst.setString(5, mailMod);
                
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
    
    
    public void obtenerDatosDeAereo(JTextField textAereoBuscado, 
            JTextField textID, JTextField textMail, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textNumero, JTextArea textRequisitos){
        
         String aereoABuscar = textAereoBuscado.getText().trim();
        
        String sql = "select * from aereo where empleado = '" + aereoABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_aereo"));
                textEmpresa.setText(rs.getString("aerolinea"));
                textMail.setText(rs.getString("mail"));
                textEmpleado.setText(rs.getString("empleado"));
                textNumero.setText(rs.getString("numero_contacto"));
                textRequisitos.setText(rs.getString("requisitos"));
    
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos de la aerolínea solicitada");
                System.err.println("No es posible conseguir los datos de la aerolínea "
                        + "solicitada");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos de la aerolínea solicitada" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos de la "
                    + "aerolínea solicitada");
        }
        
    }
     
    public String obtenerMailDeAereo(String nombre){
       
        String sql = "select mail from aereo where empleado = '" + nombre + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                mail = rs.getString("mail");
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos de la aerolínea solicitada");
                System.err.println("No es posible conseguir los datos de la aerolínea "
                        + "solicitada");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos de la aerolínea solicitada" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos de la "
                    + "aerolínea solicitada");
        }
        return mail;
    }
    
    
    public boolean eliminarAereo(String empleado, int id){
       
        String sql = "delete from aereo where empleado = '" + empleado + "' "
               + "and id_aereo= '" + id + "'";
       
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
