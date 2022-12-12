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
public class ExportadoresService {
    
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextField textPais = new JTextField();
    JTextField textCUIT = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textNumero = new JTextField();
    JTextArea textProductos = new JTextArea();
    JComboBox cmbStatus = new JComboBox();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    public boolean registroDeExportador(int ID, String cuit, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosPedidos, String status){
        
        Boolean recepcion;
        int avanzar = 0;

       if(cuit.equals("")){
           textCUIT.setBackground(Color.red);
           avanzar++;
       }
       if(empleado.equals("")){
           textEmpleado.setBackground(Color.red);
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
       if(pais.equals("")){
           textPais.setBackground(Color.red);
           avanzar++;
       }
       if(productosPedidos.equals("")){
           textProductos.setBackground(Color.red);
           avanzar++;
       }
        
        String sql = "insert into exportadores values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, cuit);
                pst.setString(3, empleado);
                pst.setString(4, empresa);
                pst.setString(5, mail);
                pst.setString(6, numeroContacto);
                pst.setString(7, pais);
                pst.setString(8, productosPedidos);
                pst.setString(9, status);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió al exportador " 
                        + empleado + " de la empresa " + empresa);
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un exportador");
                System.err.println("No es posible crear exportadores" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
     public void modificarDatosExportador(String cuitMod, String empleado,
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosPedidosMod, String statusMod){
        
        int alternativaMensaje;

        String sql = "update exportadores set cuit=?, empleado=?, empresa=?, "
                + "mail=?, numero_contacto=?, pais=?, productos_pedidos=?, status=? where "
                + "empleado = '" + empleado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, cuitMod);
                pst.setString(2, empleadoMod);
                pst.setString(3, empresaMod);
                pst.setString(4, mailMod);
                pst.setString(5, numeroContactoMod);
                pst.setString(6, paisMod);
                pst.setString(7, productosPedidosMod);
                pst.setString(8, statusMod);
                
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
    
     
     public void obtenerDatosDelExportador(JTextField textExportadorBuscado, 
            JTextField textID, JTextField textCUIT, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextArea textProductos, JComboBox cmbStatus){
        
         String exportadorABuscar = textExportadorBuscado.getText().trim();
        
        String sql = "select * from exportadores where empleado = '" + exportadorABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_exportador"));
                textCUIT.setText(rs.getString("cuit"));
                textEmpleado.setText(rs.getString("empleado"));
                textEmpresa.setText(rs.getString("empresa"));
                textMail.setText(rs.getString("mail"));
                textNumero.setText(rs.getString("numero_contacto"));
                textPais.setText(rs.getString("pais"));
                textProductos.setText(rs.getString("productos_pedidos"));
                cmbStatus.setSelectedItem("status");
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del exportador solicitado");
                System.err.println("No es posible conseguir los datos del exportador "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del exportador solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "exportador solicitado");
        }
        
    }
     
     public boolean eliminarExportador(String empleado, int id){
       
        String sql = "delete from exportadores where empleado = '" + empleado + "' "
               + "and id_exportador = '" + id + "'";
       
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
