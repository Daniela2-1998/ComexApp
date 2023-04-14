package service;

import Daniela.ComexApp.Frames.VerUsuario;
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
public class ImportadoresImpl implements ImportadoresService{
    
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
    
    public boolean registroDeImportador(int ID, String cuit, String empleado, 
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
        
        String sql = "insert into importadores values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
                
                JOptionPane.showMessageDialog(null, "Se añadió al importador " 
                        + empleado + " de la empresa " + empresa);
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un importador");
                System.err.println("No es posible crear importadores" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
    public void modificarDatosImportador(String cuitMod, String empleado,
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosPedidosMod, String statusMod){
        
        int alternativaMensaje;

        String sql = "update importadores set cuit=?, empleado=?, empresa=?, "
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
    
    public void obtenerDatosDelImportador(JTextField textImportadorBuscado, 
            JTextField textID, JTextField textCUIT, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextArea textProductos, JComboBox cmbStatus){
        
         String importadorABuscar = textImportadorBuscado.getText().trim();
        
        String sql = "select * from importadores where empleado = '" + importadorABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_importador"));
                textCUIT.setText(rs.getString("cuit"));
                textEmpleado.setText(rs.getString("empleado"));
                textEmpresa.setText(rs.getString("empresa"));
                textMail.setText(rs.getString("mail"));
                textNumero.setText(rs.getString("numero_contacto"));
                textPais.setText(rs.getString("pais"));
                textProductos.setText(rs.getString("productos_pedidos"));
                String status = rs.getString("status");

                VerUsuario verUsuario = new VerUsuario();
                int statusNivel = verUsuario.recuperarStatus(status);
                cmbStatus.setSelectedIndex(statusNivel);
                
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del importador solicitado");
                System.err.println("No es posible conseguir los datos del importador "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del importador solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "importador solicitado");
        }
        
    }
    
    public int obtenerIDImportador(String empresa, String empleado){
        
        int IDImportador = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select id_importador from importadores "
                    + "where empresa = '" + empresa + "' and empleado = '" + empleado + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                IDImportador = rs.getInt("id_importador");
            }
        }catch(SQLException e){
            System.err.println("No se puede obtener el ID del importador " + e);
        }
          return IDImportador;      
    }
    
    
    
    public boolean eliminarImportador(String empleado, int id){
       
        String sql = "delete from importadores where empleado = '" + empleado + "' "
               + "and id_importador = '" + id + "'";
       
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
