package service;

import Daniela.ComexApp.Entity.Stock;
import com.toedter.calendar.JDateChooser;
import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class OperacionesNacionalesImpl implements OperacionesNacionalesService{
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    // fields
    JTextField textID = new JTextField();
    JTextField textCUIT = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextField textEmpresa = new JTextField();
    JTextField textMail = new JTextField();
    JTextField textNumeroContacto = new JTextField();
    JTextArea textProductosPedidos = new JTextArea();
    JTextField textCantidadProducto = new JTextField();
    JTextField textComprador = new JTextField();
    JComboBox cmbTipoOperacion = new JComboBox();
   
    JTextField textPrecioTotal = new JTextField();
    JTextField textVendedor = new JTextField();
    
    JTextField textBuscar = new JTextField();
    
    JDateChooser jDateChooserRegistro = new JDateChooser();
    JDateChooser jDateChooserRecibo = new JDateChooser();
    
    JComboBox cmbStatus = new JComboBox();
    
    int cantidadBase;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada, ingresado;
    
    
    
    public boolean ingresoOperacionNacional(int ID, String CUIT, String empleado,
            String empresa, String mail, String numeroContacto, String productos,
            String cantidadProductos, String comprador, String precioTotal, 
            String vendedor, String status, String tipoOperacion, Date fechaRegistro, 
            Date fechaArribo){
        
        Boolean recepcion;
        int avanzar = 0;

       if(productos.equals("")){
           textProductosPedidos.setBackground(Color.red);
           avanzar++;
       }
       
       if(comprador.equals("")){
           textComprador.setBackground(Color.red);
           avanzar++;
       }
       
        if(vendedor.equals("")){
           textVendedor.setBackground(Color.red);
           avanzar++;
       }
        
        if(comprador.equals("")){
           textComprador.setBackground(Color.red);
           avanzar++;
       }
       
        
        String sql = "insert into ventalocal values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, CUIT);
                pst.setString(3, empleado);
                pst.setString(4, empresa);
                pst.setString(5, mail);
                pst.setString(6, numeroContacto);
                pst.setString(7, productos);
                pst.setString(8, cantidadProductos);
                pst.setString(9, comprador);
                pst.setString(10, precioTotal);
                pst.setString(11, vendedor);
                pst.setString(12, status);
                pst.setString(13, tipoOperacion);
                pst.setDate(14, fechaRegistro);
                pst.setDate(15, fechaArribo);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió una nueva operación "
                        + "nacional correspondiente al/a los producto/s '" + productos
                        + "'\n\n de la empresa " + vendedor + " que llegaría el día " 
                        + fechaArribo + "");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede añadir una nueva "
                        + "operación al sistema");
                System.err.println("No se puede añadir una nueva operación al sistema" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
    
    
     public void modificarOperacionInternacional(int IDMod, String CUITMod, 
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod, 
            String productosMod, String cantidadProductosMod, String compradorMod, 
            String precioTotalMod, String vendedorMod, String status, String tipoOperacion, 
            String producto){
        
        int alternativaMensaje;

        String sql = "update ventalocal set id_ventalocal=?, cuit=?, "
                + "empleado=?, empresa=?, mail=?, numero_contacto=?, "
                + "productos_pedidos=?, cantidad_productos=?, comprador=?, "
                + "precio_total=?, vendedor=?, status=?, tipo_operacion=?, "
                + "where productos_pedidos = '" + producto + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setInt(1, IDMod);
                pst.setString(2, CUITMod);
                pst.setString(3, empleadoMod);
                pst.setString(4, empresaMod);
                pst.setString(5, mailMod);
                pst.setString(6, numeroContactoMod);
                pst.setString(7, productosMod);
                pst.setString(8, cantidadProductosMod);
                pst.setString(9, compradorMod);
                pst.setString(10, precioTotalMod);
                pst.setString(11, vendedorMod);
                pst.setString(12, status);
                pst.setString(13, tipoOperacion);
                
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para "
                    + "modificar datos" + e);
        }
    }
    
    public void modificarFechaIngreso(int ID, String producto, Date fechaIngresoMod){
        
        int alternativaMensaje;

        String sql = "update ventalocal set fecha_arribo=? where productos_pedidos = '" 
                + producto + "' and id_ventalocal = '" + ID +"'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setDate(1, fechaIngresoMod);
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para "
                    + "modificar datos" + e);
        }
    }
     
    public boolean cambiarStatusCuandoIngresaProducto(){
        
        Date fechaActual = Date.valueOf(LocalDate.now());
            
        String sql = "update ventalocal set status=? where fecha_arribo <= '" 
                + fechaActual + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            pst.setString(1, "Completada");
            pst.executeUpdate();
            conec.close();
            return ingresado = true;
 
         }catch(SQLException e){
            System.err.println("No se puede realizar el cambio de status. " + e);
        }
        return ingresado;        
    }
     
    public void notificacionOperacionesDelDia(){ 

        Date fechaActual = Date.valueOf(LocalDate.now());
        int cantidadOperaciones = 0;
        
        String sql = "select count (productos_pedidos) from ventalocal where fecha_arribo = '" 
                + fechaActual + "'";

        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                cantidadOperaciones = rs.getInt(1);
                
                   
                if (cantidadOperaciones > 0) {

                    MensajesImpl mensajes = new MensajesImpl();
                    mensajes.notificacionOperacionesNacionalesDelDia(cantidadOperaciones);

                } else if (cantidadOperaciones <= 0) {
                    System.err.println("No hay operaciones nacionales en el día de hoy.");
                }
            } else {
                
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se puede obtener la cantidad disponible " + e);
        }
    }

    public boolean eliminarOperacion (String producto, int id){
       
        String sql = "delete from ventalocal where productos_pedidos = '" + producto + "' "
               + "and id_ventalocal = '" + id + "'";
       
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
