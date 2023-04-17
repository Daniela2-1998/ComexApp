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
public class CompradoresVendedoresNacionalesImpl implements CompradoresVendedoresNacionalesService{
    
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textPais = new JTextField();
    JTextArea textProductos = new JTextArea();
    
    JComboBox cmbStatus1 = new JComboBox();
    JComboBox cmbOperacion1 = new JComboBox();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, eliminacionAprobada, existeComprador, existeVendedor;
    
    public boolean registroCompradorVendedor(String nombre, String empresa, 
            String pais, String mail, String telefono, String productos, 
            String status, String operacion){
        
        Boolean recepcion;
        int avanzar = 0;

       if(nombre.equals("")){
           textNombre.setBackground(Color.red);
           avanzar++;
       }
       if(empresa.equals("")){
           textEmpresa.setBackground(Color.red);
           avanzar++;
       }

       if(pais.equals("")){
           textPais.setBackground(Color.red);
           avanzar++;
       }
       
       if(productos.equals("")){
           textProductos.setBackground(Color.red);
           avanzar++;
       }
        
        String sql = "insert into participantes_nacionales (empresa, mail, nombre, "
                + "numero_contacto, pais, productos_asociados, status, tipo_operacion, "
                + "stock_modificado) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);

                pst.setString(1, empresa);
                pst.setString(2, mail);
                pst.setString(3, nombre);
                pst.setString(4, telefono);
                pst.setString(5, pais);
                pst.setString(6, productos);
                pst.setString(7, status);
                pst.setString(8, operacion);
                pst.setBoolean(9, false);

                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el contacto  " 
                        + nombre + ", " + operacion + " de " + empresa);
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un "
                        + "contacto nacional de  " + empresa);
                System.err.println("No es posible crear el contacto " + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
    public void modificarDatos(String buscado, String nombre, String empresa, 
            String pais, String mail, String telefono, String productos, 
            String status, String operacion){
        
        int alternativaMensaje;

        String sql = "update participantes_nacionales set nombre=?, empresa=?, "
                + "pais=?, mail=?, numero_contacto=?, productos=?, status=?, "
                + "tipo_operacion=? where nombre = '" + buscado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, 
                    "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, nombre);
                pst.setString(2, empresa);
                pst.setString(3, pais);
                pst.setString(4, mail);
                pst.setString(5, telefono);
                pst.setString(6, productos);
                pst.setString(7, status);
                pst.setString(8, operacion);
                
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
    
    
    public void obtenerDatosCompradorVendedor(String buscado, JTextField textNombre2, 
            JTextField textEmpresa1, JTextField textMail1, JTextField textTel1, 
            JTextField textPais1, JTextArea textProductos1, JComboBox cmbStatus1, 
            JComboBox cmbOperacion1){
        
        String sql = "select * from participantes_nacionales where nombre = '" + buscado + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textNombre2.setText(buscado);
                textEmpresa1.setText(rs.getString("empresa"));
                textMail1.setText(rs.getString("mail"));
                textTel1.setText(rs.getString("numero_contacto"));
                textPais1.setText(rs.getString("pais"));
                textProductos1.setText(rs.getString("productos_asociados"));
                
                String status = rs.getString("status");
                String operacion = rs.getString("tipo_operacion");
                
                if(status.equals("Activo")){
                    cmbStatus1.setSelectedItem(1);
                } else {
                    cmbStatus1.setSelectedItem(2);
                }
                
                if(operacion.equals("Comprador")){
                    cmbOperacion1.setSelectedIndex(0);
                } else if (operacion.equals("Vendedor")){
                    cmbOperacion1.setSelectedIndex(1);
                }
    
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del socio nacional");
                System.err.println("No es posible conseguir los datos del socio nacional "
                        + "solicitada");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del socio nacional " + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos solicitados");
        }
        
    }
     
    public boolean existeComprador(String nombre){
    
        String sql = "select nombre, tipo_operacion from participantes_nacionales "
                + "where nombre = '" + nombre + " and tipo_operacion = 'Comprador'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                System.out.println("Comprador encontrado");
                return existeComprador = true;
            } else {
                JOptionPane.showMessageDialog(null, "El comprador solicitado "
                        + "no existe", "Comprador", 0);
                return existeComprador = false;
            }
        }catch(SQLException e){
            System.err.println("No se puede recuperar al comprador solicitado " + e);
        }
        return existeComprador;
    }
    
    public boolean existeVendedor(String nombre){

        String sql = "select nombre, tipo_operacion from participantes_nacionales "
                + "where nombre = '" + nombre + " and tipo_operacion = 'Vendedor'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                System.out.println("Vendedor encontrado");
                return existeVendedor = true;
            } else {
                JOptionPane.showMessageDialog(null, "El vendedor solicitado "
                        + "no existe", "Vendedor", 0);
                return existeVendedor = false;
            }
        }catch(SQLException e){
            System.err.println("No se puede recuperar al vendedor solicitado " + e);
        }
        return existeVendedor;
    }
    
    public boolean eliminar(String nombre, int id){
       
        String sql = "delete from participantes_nacionales where nombre = '" 
                + nombre + "' and id_part_nac = '" + id + "'";
       
       int alternativaMensaje;
       Boolean aprobado;
       
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           
           
           alternativaMensaje = JOptionPane.showConfirmDialog(null, 
                   "Estás por eliminar un registro, ¿está seguro de que quieres hacerlo?");
           
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
