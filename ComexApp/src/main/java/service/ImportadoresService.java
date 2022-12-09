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
public class ImportadoresService {
    
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
    
    Boolean recepcionFuncion;
    
    public boolean registroDeImportador(int ID, String cuit, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosPedidos, String status){
        
        //String numero_contacto
        //  String productos_pedidos
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
                
                JOptionPane.showMessageDialog(null, "Se añadió al importado " 
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
    
    
}
