package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class OperacionNacionalParticipantesImpl implements OperacionNacionalParticipantesService{
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean eliminacionAprobada;
    Boolean ingresoProducto;
    
    public void ingresarConexionesOpNac(int numeroOpNac, String comprador, 
            String vendedor, String status){
        
        String sql = "insert into participantes_opnac_con values (?, ?, ?, ?, ?, ?, ?)";
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, numeroOpNac);
                pst.setString(2, comprador);
                pst.setInt(3, numeroOpNac);
                pst.setInt(4, 0);
                pst.setString(5, status);
                pst.setString(6, vendedor);   
                pst.setBoolean(7, false);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se creó una asociación a "
                        + "una operación nacional");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede conectar la "
                        + "operación");
                System.err.println("No se puede añadir la asociación " + e);
            }
    }
    
    public void agregarIDProducto(int idProducto, int idOperacion){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opnac_con set id_producto=? "
           + "where numero_op_nac = '" + idOperacion + "'");
           
           pst.setInt(1, idProducto);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Asociación éxitosa", "Asociar a producto", 0);
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del producto " + e);
        }  
    }
    
    public boolean verificarIngresoProducto(){
        
        Boolean ingresoProducto = null;
        Date fechaActual = Date.valueOf(LocalDate.now());
        String sql = "select productos_pedidos from venta_local where fecha_arribo <= '" + 
                fechaActual + "'";
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                ingresoProducto = true;
            } else{
                ingresoProducto = false;
            }
            conec.close();
        }catch(SQLException e){
            System.err.println("No hay ingresos nuevos " + e);
        }
        return ingresoProducto;
    }
    
    public int obtenerCantidadDeProductos(int id){
        
        int cantidadProducto = 0;
        String sql = "select cantidad_producto from venta_local where id_ventalocal = '" + id + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                cantidadProducto = Integer.parseInt(rs.getString("cantidad_producto"));
            }
            conec.close();
        }catch(SQLException e){
            System.err.println("No se puede obtener la cantidad de productos " + e);
        }
        return cantidadProducto;
    }
    
    public String tipoOperacion(int id){
        
        String tipoOperacion = null;
        String sql = "select tipo_operacion from ventalocal where id_ventalocal = '" + id + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                tipoOperacion = rs.getString("tipo_operacion");
            }
            
        }catch(SQLException e){
            System.err.println("No se puede obtener el tipo de operacion " + e);
        }
        
        return tipoOperacion;
    }
    
    public void recuperarStockQueSeActualizaHoy(){
        
        String producto, vendedor, comprador, codigo, cantidad;
        int ID;
        
        Date fechaActual = Date.valueOf(LocalDate.now());
        String sql = "select productos_pedidos, id_ventalocal, vendedor, comprador, "
                + "cantidad_producto from ventalocal where fecha_arribo <= '" + 
                fechaActual + "'";

            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {
                    producto = rs.getString("productos_pedidos");
                    vendedor = rs.getString("vendedor");
                    comprador = rs.getString("comprador");
                    cantidad = rs.getString("cantidad_producto");
                    ID = rs.getInt("id_ventalocal");
                    
                    Date ultimaAct = Date.valueOf(LocalDate.now());

                    String sql1 = "select codigo_producto from stock where nombre_producto = '"
                            + producto + "' and vendedor = '" + vendedor + "' and "
                            + "ultima_actualizacion != '" + ultimaAct + "'";

                    PreparedStatement pst1 = conec.prepareStatement(sql1);
                    ResultSet rs1 = pst1.executeQuery();

                    if (rs1.next()) {
                        codigo = rs1.getString("codigo_producto");
                        StockImpl stockImpl = new StockImpl();
                        stockImpl.asociarCantidadesAOperacionNacional(producto, vendedor, codigo, ID);
                        stockImpl.actualizacionDelProducto(producto, codigo, vendedor);

                        Boolean valor = true;
                        String sql2 = "update participantes_opnac_con set stock_modificado = '" + valor + "'";

                        PreparedStatement pst2 = conec.prepareStatement(sql2);
                        ResultSet rs2 = pst2.executeQuery();
                        
                        conec.close();
                    } else {
                        StockImpl stockImpl = new StockImpl();
                        stockImpl.ingresoNuevoProductoAStockBasico(producto, cantidad, comprador, vendedor);
                    }

                }

            } catch (SQLException e) {
                System.err.println("No se puede recuperar el stock de hoy " + e);
            }
    }
    
    
    
    public boolean eliminarConexion(int id){
       
        String sql = "delete from participantes_opnac_con where id_operacion = '" + id + "'";
       
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

