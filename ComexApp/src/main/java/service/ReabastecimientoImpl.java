package service;

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
public class ReabastecimientoImpl implements ReabastecimientoService {
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    // fields
    JTextField textID = new JTextField();
    JTextField textCantidad = new JTextField();
    JTextField textPaisOrigen = new JTextField();
    JTextField textPrecioUnitario = new JTextField();
    JTextField textPrecioTotal = new JTextField();
    JTextField textTipoProducto = new JTextField();
    JTextField textProducto = new JTextField();
    JTextField textDescuento = new JTextField();
    JTextField textFechaRegistro = new JTextField();
    JTextField textFechaRecibo  = new JTextField();
    
    
    JTextField textBuscar = new JTextField();

    JTextArea textCuidados = new JTextArea();
    JTextArea textDetalle = new JTextArea();
    
    JComboBox cmbStatus = new JComboBox();
    
    int cantidadBase;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;


    
     public boolean ingresoSuministrosReabastecimiento(int ID, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, String precioTotal,
            String cantidad, String tipoProducto, String producto, 
            Date fechaRegistro, Date fechaRecibo){
        
        Boolean recepcion;
        int avanzar = 0;

        String descuento = " - ";
        String destino = " - ";
        String status = "Activo";

       if(producto.equals("")){
           textProducto.setBackground(Color.red);
           avanzar++;
       }
       if(tipoProducto.equals("")){
           textTipoProducto.setBackground(Color.red);
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
       
        
        String sql = "insert into reabastecimiento values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setString(2, cantidad);
                pst.setString(3, descuento);
                pst.setString(4, destino);
                pst.setString(5, precioTotal);
                pst.setString(6, producto);
                pst.setString(7, detalle);
                pst.setString(8, paisOrigen);
                pst.setString(9, precioUnitario);
                pst.setString(10, status);
                pst.setString(11, tipoProducto);
                pst.setString(12, cuidados);
                pst.setDate(13, fechaRecibo);
                pst.setDate(14, fechaRegistro);

                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió un nuevo producto (" + 
                        producto + ") al stock de suministros del sistema ComexApp");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede añadir un nuevo "
                        + "producto al stock de suministros del sistema");
                System.err.println("No se puede añadir un nuevo producto al sistema" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
 
     public void obtenerDatosTablas(String producto){
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select pais_origen, precio_unitario, "
                    + "precio_total, descuento, fecha_registro, fecha_ingreso "
                    + "from reabastecimiento where producto = '" + producto + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                    textPaisOrigen.setText(rs.getString("pais_origen"));
                    textPrecioUnitario.setText(rs.getString("precio_unitario"));
                    textPrecioTotal.setText(rs.getString("precio_total"));
                    textDescuento.setText(rs.getString("descuento"));
                    
                    
                    Date registro = rs.getDate("fecha_operacion");
                    textFechaRegistro.setText(String.valueOf(registro));
                    
                    Date llegada = rs.getDate("fecha_llegada");
                    textFechaRegistro.setText(String.valueOf(llegada));

            }
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede obtener la información "
                    + "relacionada con la tabla " + producto);
        }
    }
    
     public void modificarSuministros(int IDMod, String cantidadMod, String precioTotalMod, 
            String cuidadosMod, String detalleMod, String paisOrigenMod, 
            String precioUnitarioMod, String statusMod, String tipoProductoMod, 
            String descuentoMod, String destinoMod, String productoMod, String producto){
        
        int alternativaMensaje;

        String sql = "update reabastecimiento set cantidad=?, descuento=?, "
                + "destino=?, precio_total=?, producto=?, detalle=?, "
                + "pais_origen=?, precio_unitario=?, status=?, tipo_producto=?, "
                + "cuidados_requeridos=? where producto = '" + producto + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, cantidadMod);
                pst.setString(2, descuentoMod);
                pst.setString(3, destinoMod);
                pst.setString(4, precioTotalMod);
                pst.setString(5, productoMod);
                pst.setString(6, detalleMod);
                pst.setString(7, paisOrigenMod);
                pst.setString(8, precioUnitarioMod);
                pst.setString(9, statusMod);
                pst.setString(10, tipoProductoMod);
                pst.setString(11, cuidadosMod);

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

        String sql = "update reabastecimiento set fecha_ingreso=? where producto = '" 
                + producto + "' and id_pedido = '" + ID +"'";

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
     
    public void cambiarStatusCuandoIngresaProducto(){
        
        Date fechaActual = Date.valueOf(LocalDate.now());
        
        String sql = "update reabastecimiento set status=? where fecha_ingreso <= '" 
                + fechaActual + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            pst.setString(1, "Disponible");
            pst.executeUpdate();
            conec.close();
            
         }catch(SQLException e){
            System.err.println("No se puede realizar el cambio de status. " + e);
        }
        
    }
    
    
    
     public boolean eliminarSuministros(String producto, int id){
       
        String sql = "delete from reabastecimiento where producto = '" + producto + "' "
               + "and id_pedido = '" + id + "'";
       
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




