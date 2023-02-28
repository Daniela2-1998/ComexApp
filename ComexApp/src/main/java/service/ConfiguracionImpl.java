package service;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class ConfiguracionImpl{
  
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textAdminPrin = new JTextField();
    JTextField textAdminSec = new JTextField();
    JTextField textAdminRep = new JTextField();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    public boolean aplicarConfiguracion(String empresa, String adminPrincipal, 
            String adminSecundario, String adminExtra){
        
        Boolean recepcion;
        int ID = 1;
        
        String sql = "insert into configuracion values (?, ?, ?, ?, ?)";
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, adminPrincipal);
                pst.setString(3, adminExtra);
                pst.setString(4, adminSecundario);
                pst.setString(5, empresa);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se guardó la configuración "
                        + "que estableciste para ComexApp.");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No pudimos guardar tu configuración.");
                System.err.println("No es posible guardar la configuración " + e);
                return recepcion = false;
            }
    }
    
     public void modificarConfiguracion(String empresaMod, String adminPrincipalMod, 
            String adminSecundarioMod, String adminExtraMod){
        
        int alternativaMensaje;

        String sql = "update configuracion set admin_princ=?, admin_rep=?, admin_sec=?, "
                + "empresa=?";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, adminPrincipalMod);
                pst.setString(2, adminExtraMod);
                pst.setString(3, adminSecundarioMod);
                pst.setString(4, empresaMod);
                
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
    
    public void verSiHayConfiguracion(JTextField textAdminPrin, JTextField textAdminSec,
            JTextField textAdminRep, JTextField textEmpresa){

        String sql = "select admin_princ, admin_rep, admin_sec, empresa from configuracion";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya has establecido una "
                        + "configuración, no puedes crear otra, modificala", 
                        "Configuración existente", 0);
                
                textEmpresa.setText(rs.getString("empresa"));
                textAdminPrin.setText(rs.getString("admin_princ"));
                textAdminSec.setText(rs.getString("admin_sec"));
                textAdminRep.setText(rs.getString("admin_rep"));
            } else {
                JOptionPane.showMessageDialog(null, "No tienes una configuración establecida.", "Sin configuración", 0);
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
        
    }
     
    
}
