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
public class StockImpl implements StockService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    // fields
    JTextField textID = new JTextField();
    JTextField textCantidad = new JTextField();
    JTextField textCodigo = new JTextField();
    JTextField textComprador = new JTextField();
    JTextField textPaisOrigen = new JTextField();
    JTextField textPrecioUnitario = new JTextField();
    JTextField textReserva = new JTextField();
    JTextField textTipoProducto = new JTextField();
    JTextField textVendedor = new JTextField();
    JTextField textProducto = new JTextField();
    
    JTextArea textCuidados = new JTextArea();
    JTextArea textDetalle = new JTextArea();
    
    JComboBox cmbStatus = new JComboBox();
    
    int cantidadBase;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    
    
    
    
    public boolean ingresoNuevoProductoAStock(int ID,  String codigo, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, 
            String tipoProducto, String producto){
        
        Boolean recepcion;
        int avanzar = 0;

        String cantidad = "1";
        String comprador = " - ";
        String reserva = " - ";
        String status = "Activo";
        String vendedor = " - ";
       

       if(producto.equals("")){
           textProducto.setBackground(Color.red);
           avanzar++;
       }
       if(tipoProducto.equals("")){
           textTipoProducto.setBackground(Color.red);
           avanzar++;
       }
       if(codigo.equals("")){
           textCodigo.setBackground(Color.red);
           avanzar++;
       }
       if(detalle.equals("")){
           textDetalle.setBackground(Color.red);
           avanzar++;
       }
       if(cuidados.equals("")){
           textCuidados.setBackground(Color.red);
           avanzar++;
       }
       
        if(paisOrigen.equals("")){
           textPaisOrigen.setBackground(Color.red);
           avanzar++;
       }
       
        
        String sql = "insert into stock values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, cantidad);
                pst.setString(3, codigo);
                pst.setString(4, comprador);
                pst.setString(5, cuidados);
                pst.setString(6, detalle);
                pst.setString(7, paisOrigen);
                pst.setString(8, precioUnitario);
                pst.setString(9, reserva);
                pst.setString(10, status);
                pst.setString(11, tipoProducto);
                pst.setString(12, vendedor);
                pst.setString(13, producto);

                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió un nuevo producto (" + 
                        producto + ") al stock del sistema ComexApp");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede añadir un nuevo "
                        + "producto al sistema");
                System.err.println("No se puede añadir un nuevo producto al sistema" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
    
    
    
    public int obtenerCantidadDeBaseDeDatos(String producto){
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select cantidad from stock where "
                    + "nombre_producto = '" + producto + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                 int cantidadBase = Integer.parseInt(rs.getString("cantidad"));
                 return cantidadBase;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede obtener la cantidad "
                    + "disponible del producto " + producto);
        }
        return cantidadBase;
    }
     
    
    
    public void modificarStock(int IDMod, String cantidadMod, String codigoMod, 
            String cuidadosMod, String detalleMod, String paisOrigenMod, 
            String precioUnitarioMod, String statusMod, String tipoProductoMod, 
            String productoMod, String producto){
        
        int alternativaMensaje;

        String sql = "update stock set id_producto=?, cantidad=?, codigo_producto=?, "
                + "cuidados_requeridos=?, detalle=?, pais_origen=?, precio_unitario=?, "
                + "status=?, tipo_producto=?, nombre_producto=? where "
                + "nombre_producto = '" + producto + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setInt(1, IDMod);
                pst.setString(2, cantidadMod);
                pst.setString(3, codigoMod);
                pst.setString(4, cuidadosMod);
                pst.setString(5, detalleMod);
                pst.setString(6, paisOrigenMod);
                pst.setString(7, precioUnitarioMod);
                pst.setString(8, statusMod);
                pst.setString(9, tipoProductoMod);
                pst.setString(10, productoMod);
                
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
    
    public int obtenerIDProducto(String codigo, String vendedor, String producto){
        
        int IDProducto = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select id_producto from stock where "
                    + "nombre_producto = '" + producto + "' and codigo_producto = '" + 
                    codigo + "' and vendedor = '" + vendedor + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                IDProducto = rs.getInt("id_producto");
            }
            
        }catch(SQLException e){
            System.err.print("No se puede obtener ID producto " + e);
        }
        return IDProducto;
    }
    
    
    public boolean eliminarProductoDeStock(String producto, int id){
       
        String sql = "delete from stock where producto = '" + producto + "' "
               + "and id_producto = '" + id + "'";
       
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
