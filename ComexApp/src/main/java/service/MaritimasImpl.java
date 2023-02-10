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
public class MaritimasImpl implements MaritimasService{
   
    
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextArea textTipoTransporte = new JTextArea();
    JTextField textID = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textNumero = new JTextField();
    JTextArea textRequisitosAviso = new JTextArea();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    public boolean registroDeMaritima(int ID, String mail, String empleado, 
            String empresa, String numeroContacto, String requisitosAviso, 
            String tipoTransporte){
        
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
       if(requisitosAviso.equals("")){
           textRequisitosAviso.setBackground(Color.red);
           avanzar++;
       }
       if(tipoTransporte.equals("")){
           textTipoTransporte.setBackground(Color.red);
           avanzar++;
       }
        
        String sql = "insert into maritimas values (?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, mail);
                pst.setString(3, empleado);
                pst.setString(4, empresa);
                pst.setString(5, numeroContacto);
                pst.setString(6, requisitosAviso);
                pst.setString(7, tipoTransporte);

                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el contacto  " 
                        + empleado + " de la empresa " + empresa);
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un "
                        + "contacto de la marítima " + empresa);
                System.err.println("No es posible crear el contacto de la marítima" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
     public void modificarMaritima(String mailMod, String empleado,
            String empleadoMod, String empresaMod, String numeroContactoMod,
            String requisitosAvisoMod, String tipoTransporteMod){
        
        int alternativaMensaje;

        String sql = "update maritimas set mail=?, empleado=?, empresa=?, "
                + "numero_contacto=?, requisitosAviso=?, tipoTranspote=? where "
                + "empleado = '" + empleado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, mailMod);
                pst.setString(2, empleadoMod);
                pst.setString(3, empresaMod);
                pst.setString(4, numeroContactoMod);
                pst.setString(5, requisitosAvisoMod);
                pst.setString(6, tipoTransporteMod);
                
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
    
    
      public void obtenerDatosDeLaMaritima(JTextField textMaritimaBuscada, 
            JTextField textID, JTextField textMail, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textNumero, JTextArea textRequisitosAviso, 
            JTextArea textTipoTransporte){
        
         String maritimaABuscar = textMaritimaBuscada.getText().trim();
        
        String sql = "select * from maritimas where empleado = '" + maritimaABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_maritima"));
                textMail.setText(rs.getString("mail"));
                textEmpleado.setText(rs.getString("empleado"));
                textEmpresa.setText(rs.getString("empresa"));
                textNumero.setText(rs.getString("numero_contacto"));
                textRequisitosAviso.setText(rs.getString("requisitos_aviso"));
                textTipoTransporte.setText(rs.getString("tipo_transporte"));
    
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos de la marítima solicitada");
                System.err.println("No es posible conseguir los datos de la maritima "
                        + "solicitada");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos de la maritima solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos de la "
                    + "marítima solicitada");
        }
        
    }
     
     public boolean eliminarMaritima(String empleado, int id){
       
        String sql = "delete from maritimas where empleado = '" + empleado + "' "
               + "and id_maritima = '" + id + "'";
       
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
