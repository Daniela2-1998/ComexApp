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
    
    int cantidadBase, cantidadActualizada;
    
    String producto;
    
    Boolean recepcionFuncion, recepcionFuncion1, modificacionEstado, eliminacionAprobada;
    
    
    
    
    
    
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
        Date ultimaActualizacion = Date.valueOf(LocalDate.now());

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
       
        
        String sql = "insert into stock values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
                pst.setDate(14, ultimaActualizacion);

                
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
    
    public boolean ingresoNuevoProductoAStockBasico(String producto, 
             String cantidad, String comprador, String vendedor){
        
        Boolean recepcion;

        String codigo = " - ";
        String detalle = " - ";
        String paisOrigen = "Argentina";
        String cuidados = " - ";
        String precioUnitario = " - ";
        String tipoProducto = " - ";
        String reserva = " - ";
        String status = "Activo";
        Date ultimaActualizacion = Date.valueOf(LocalDate.now());
        
        String sql = "insert into stock (cantidad, codigo_producto, comprador, "
                + "cuidados_requeridos, detalle, pais_origen, precio_unitario, "
                + "reserva, status, tipo_producto, vendedor, nombre_producto, "
                + "ultima_actualizacion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setString(1, cantidad);
                pst.setString(2, codigo);
                pst.setString(3, comprador);
                pst.setString(4, cuidados);
                pst.setString(5, detalle);
                pst.setString(6, paisOrigen);
                pst.setString(7, precioUnitario);
                pst.setString(8, reserva);
                pst.setString(9, status);
                pst.setString(10, tipoProducto);
                pst.setString(11, vendedor);
                pst.setString(12, producto);
                pst.setDate(13, ultimaActualizacion);

                
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
     
     
    public String obtenerProducto(int ID){
        
        String producto = null;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select nombre_producto from stock where "
                    + "id_producto = '" + ID + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                 producto = rs.getString("nombre_producto");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede obtener el producto");
        }
        
        return producto;
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
    
    public int nuevaCantidadProductosOperacionInternacional(int cantidadProducto, 
            String producto, int id){
        
        int cantidadActualizada = 0;
        
        int cantidadDeStock = obtenerCantidadDeBaseDeDatos(producto);
        
        OperacionesInternacionalesImpl opsint = new OperacionesInternacionalesImpl();       
        String tipoOperacion = opsint.tipoOperacion(id);
        
        if(tipoOperacion.equals("Importación")){
            cantidadActualizada = cantidadDeStock + cantidadProducto;
        } else if(tipoOperacion.equals("Exportación")){
            cantidadActualizada = cantidadDeStock - cantidadProducto;
        }
        
        return cantidadActualizada;
    }
     
    public int nuevaCantidadProductosOperacionNacional(int cantidadProducto, 
            String producto, int id){
        
        int cantidadActualizada = 0;
        
        int cantidadDeStock = obtenerCantidadDeBaseDeDatos(producto);
        
        OperacionNacionalParticipantesImpl opsnac = new OperacionNacionalParticipantesImpl();       
        String tipoOperacion = opsnac.tipoOperacion(id);
        
        if(tipoOperacion.equals("Compra")){
            cantidadActualizada = cantidadDeStock + cantidadProducto;
        } else if(tipoOperacion.equals("Venta")){
            cantidadActualizada = cantidadDeStock - cantidadProducto;
        }
        
        return cantidadActualizada;
    }
    
    public void asociarCantidadesAOperacionInternacional(String producto, String vendedor, 
            String codigo, int idOperacion){
        
        OperacionesInternacionalesImpl opsint = new OperacionesInternacionalesImpl();
        Boolean hayIngreso = opsint.verificarIngresoProducto();
        int cantidadProductoOp = opsint.obtenerCantidadDeProductos(idOperacion);

        int cantidadActualizada = nuevaCantidadProductosOperacionInternacional(
                cantidadProductoOp, producto, idOperacion);
        
        String cantidadNueva = String.valueOf(cantidadActualizada);
        
        Date ultimaActualizacion = Date.valueOf(LocalDate.now());

        if (hayIngreso.equals(true)) {

            try {
                String sql = "update stock set cantidad=? where nombre_producto = '" 
                + producto + "' and vendedor = '" + vendedor + "' and codigo_producto = '" 
                + codigo + "' and ultima_actualizacion != '" + ultimaActualizacion + "'";
             
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);

                pst.setString(1, cantidadNueva);
                pst.executeUpdate();
                actualizacionDelProducto(producto, codigo, vendedor);
                conec.close();

            } catch (SQLException e) {
                System.err.print("No se puede modificar las cantidades del stock " + e);
            }

        } else if (hayIngreso.equals(false)){
            System.out.println("No hay ingresos de operaciones internacionales");
        }
    }
    
    public void asociarCantidadesAOperacionNacional(String producto, String vendedor, 
            String codigo, int idOperacion){
        
        OperacionNacionalParticipantesImpl opsnac = new OperacionNacionalParticipantesImpl();
        Boolean hayIngreso = opsnac.verificarIngresoProducto();
        int cantidadProductoOp = opsnac.obtenerCantidadDeProductos(idOperacion);

        int cantidadActualizada = nuevaCantidadProductosOperacionInternacional(
                cantidadProductoOp, producto, idOperacion);
        
        String cantidadNueva = String.valueOf(cantidadActualizada);
        
        Date ultimaActualizacion = Date.valueOf(LocalDate.now());

        if (hayIngreso.equals(true)) {

            try {
                String sql = "update stock set cantidad=? where nombre_producto = '" 
                + producto + "' and vendedor = '" + vendedor + "' and codigo_producto = '" 
                + codigo + "' and ultima_actualizacion != '" + ultimaActualizacion + "'";
             
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);

                pst.setString(1, cantidadNueva);
                pst.executeUpdate();
                actualizacionDelProducto(producto, codigo, vendedor);
                conec.close();

            } catch (SQLException e) {
                System.err.print("No se puede modificar las cantidades del stock " + e);
            }

        } else if (hayIngreso.equals(false)){
            System.out.println("No hay ingresos de operaciones internacionales");
        }
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
    
    public void actualizacionDelProducto(String producto, String codigo, String vendedor){
        
        Date nuevaActualizacion = Date.valueOf(LocalDate.now());
        String sql = "update stock set ultima_actualizacion=? where nombre_producto = '" 
                + producto + "' and codigo_producto = '" + codigo + "' and "
                + "vendedor = '" + vendedor + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setDate(1, nuevaActualizacion);
            pst.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No podemos actualizar el producto "
                    + "solicitado");
            System.err.println("No se puede actualizar la lista del producto " + e);
        }
        
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
