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
public class DespachantesService implements DespachantesImpl{
    
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextField textPais = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textNumero = new JTextField();
    JTextArea textProductos = new JTextArea();
    JComboBox cmbStatus = new JComboBox();
    JTextField textDespachante = new JTextField();
    
    JTextField textNombreDespachante = new JTextField();
    JTextField textIDDespachante = new JTextField();
    

    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    public boolean registroDeDespachante(int ID, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosAsociados, String status){
        
        Boolean recepcion;
        int avanzar = 0;

       if(empresa.equals("")){
           textEmpresa.setBackground(Color.red);
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
       if(productosAsociados.equals("")){
           textProductos.setBackground(Color.red);
           avanzar++;
       }
        
        String sql = "insert into despachantes values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, empleado);
                pst.setString(3, empresa);
                pst.setString(4, mail);
                pst.setString(5, numeroContacto);
                pst.setString(6, pais);
                pst.setString(7, productosAsociados);
                pst.setString(8, status);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió al despachante " 
                        + empleado + " de la empresa " + empresa + " al sistema ComexApp");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un despachante");
                System.err.println("No es posible crear despachantes" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
     
    
    public void modificarDatosDespachante(String empleado,String empleadoMod, 
            String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosAsociadosMod, String statusMod){
        
        int alternativaMensaje;

        String sql = "update despachantes set empleado=?, empresa=?, "
                + "mail=?, numero_contacto=?, pais=?, productos_asociados=?, status=? where "
                + "empleado = '" + empleado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, empleadoMod);
                pst.setString(2, empresaMod);
                pst.setString(3, mailMod);
                pst.setString(4, numeroContactoMod);
                pst.setString(5, paisMod);
                pst.setString(6, productosAsociadosMod);
                pst.setString(7, statusMod);
                
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
    
    
    
    
    public void obtenerDatosDelDespachante(JTextField textDespachanteBuscado, 
            JTextField textID, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextArea textProductos, JComboBox cmbStatus){
        
         String despachanteABuscar = textDespachanteBuscado.getText().trim();
        
        String sql = "select * from despachantes where empleado = '" + despachanteABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_despachantes")); 
                textEmpleado.setText(rs.getString("empleado"));
                textEmpresa.setText(rs.getString("empresa"));
                textMail.setText(rs.getString("mail"));
                textNumero.setText(rs.getString("numero_contacto"));
                textPais.setText(rs.getString("pais"));
                textProductos.setText(rs.getString("productos_asociados"));
                cmbStatus.setSelectedItem("status");
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del despachante solicitado");
                System.err.println("No es posible conseguir los datos del despachante "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del despachante solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "despachante solicitado");
        }
        
    }
     
       
    public void obtenerNombreOIDDelDespachante(int ID, String nombreDespachante){
        
        String sql = null;
        
        if(ID == 0 && nombreDespachante.equals("")){
            sql = "select empleado from despachantes where id_despachantes ='" + ID + "'";
        } else if (ID > 0 && !nombreDespachante.equals("")){
            sql = "select id_despachantes from despachantes where "
                    + "empleado ='" + nombreDespachante + "'";
        } else if (ID == 0 && !nombreDespachante.equals("")){
            System.err.println("Por favor ingrese algun dato para recuperar de la base");
        }

        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                if(ID == 0 && nombreDespachante.equals("")){
                    textNombreDespachante.setText(rs.getString("empleado"));
                }

                if (ID > 0 && !nombreDespachante.equals("")){
                    textIDDespachante.setText(rs.getString("id_despachantes"));
                }
            }
            
        }catch(SQLException e){
            System.err.println("No se puede obtener el nombre o id del despachante " + e);
            JOptionPane.showMessageDialog(null, "No es posible obtener el nombre o id del despachante " + e);
        }
        
    }
        
    public void obtenerDatosDeProductosDelDespachante(JTextField textDespachanteBuscado, 
            JTextField textDespachante, JTextArea textProductos1){
        
        String despachanteABuscar = textDespachanteBuscado.getText().trim();
        
        String sql = "select empleado, productos_asociados from despachantes "
                + "where empleado = '" + despachanteABuscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textDespachante.setText(rs.getString("empleado"));
                textProductos1.setText(rs.getString("productos_asociados"));
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del despachante solicitado");
                System.err.println("No es posible conseguir los datos del despachante "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del despachante solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "despachante solicitado");
        }
        
    }
       
    public boolean eliminarDespachante(String empleado, int id){
       
        String sql = "delete from despachantes where empleado = '" + empleado + "' "
               + "and id_despachantes = '" + id + "'";
       
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
