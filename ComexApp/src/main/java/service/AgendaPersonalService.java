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
public class AgendaPersonalService {
    
     // fields
    JTextField textEmpresa = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextField textPais = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textNumero = new JTextField();
    JTextArea textProductos = new JTextArea();
    JComboBox cmbStatus = new JComboBox();
    JTextField textDespachante = new JTextField();
    JTextField textCargo = new JTextField();
     
    JTextField textBuscar= new JTextField();
    JTextField textID = new JTextField();
    

    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    
    
    public boolean registroContactoAgendaPersonal(int ID, String nombre, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosAsociados, String status, String usuario, String cargo){
        
        Boolean recepcion;
        int avanzar = 0;

       if(empresa.equals("")){
           textEmpresa.setBackground(Color.red);
           avanzar++;
       }
       if(nombre.equals("")){
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
       if(productosAsociados.equals("")){
           textProductos.setBackground(Color.red);
           avanzar++;
       }
       if(cargo.equals("")){
           textCargo.setBackground(Color.red);
           avanzar++;
       }
       
       if(usuario.equals("")){
           avanzar++;
       }
        
        String sql = "insert into agenda_personal values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, empresa);
                pst.setString(3, mail);
                pst.setString(4, nombre);
                pst.setString(5, numeroContacto);
                pst.setString(6, pais);
                pst.setString(7, productosAsociados);
                pst.setString(8, status);
                pst.setString(9, usuario);
                pst.setString(10, cargo);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el " + cargo + " "
                        + nombre + " de " + empresa + " al sistema ComexApp");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un nuevo contacto");
                System.err.println("No es posible crear contactos" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
     
      public void modificarDatosContactoAgendaPersonal(int IDMod, String nombreMod, 
            String empresaMod, String mailMod, String numeroContactoMod, String paisMod,
            String productosAsociadosMod, String statusMod, String cargoMod, 
            String nombre, String usuario){
        
        int alternativaMensaje;

        String sql = "update agenda_personal set empresa=?, mail=?, nombre=?, "
                + "numero_contacto=?, pais=?, productos=?, status=?, cargo=? "
                + "where nombre = '" + nombre + "' and usuario_registrador ='" + usuario + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, empresaMod);
                pst.setString(2, mailMod);
                pst.setString(3, nombreMod);
                pst.setString(4, numeroContactoMod);
                pst.setString(5, paisMod);
                pst.setString(6, productosAsociadosMod);
                pst.setString(7, statusMod);
                pst.setString(8, cargoMod);
                
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
    
      public void obtenerDatosDelContactoPersonal(JTextField textBuscar, 
            JTextField textID, JTextField textEmpleado, JTextField textEmpresa, 
            JTextField textMail, JTextField textNumero, JTextField textPais, 
            JTextArea textProductos, JComboBox cmbStatus, JComboBox cmbCargo){
        
         String contactoABuscar = textBuscar.getText().trim();
        
        String sql = "select * from agenda_personal where nombre = '" + contactoABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_agenda"));
                textEmpresa.setText(rs.getString("empresa"));
                textMail.setText(rs.getString("mail"));
                textEmpleado.setText(rs.getString("nombre"));
                textNumero.setText(rs.getString("numero_contacto")); 
                textPais.setText(rs.getString("pais"));
                textProductos.setText(rs.getString("productos"));
                cmbStatus.setSelectedItem("status");
                cmbCargo.setSelectedItem(rs.getString("cargo"));
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del contacto solicitado");
                System.err.println("No es posible conseguir los datos del contacto "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del contacto solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "contacto solicitado");
        }
        
    }
     
     public boolean eliminarContactoPersonal(String nombre, int id){
       
        String sql = "delete from agenda_personal where nombre = '" + nombre + "' "
               + "and id_agenda = '" + id + "'";
       
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
