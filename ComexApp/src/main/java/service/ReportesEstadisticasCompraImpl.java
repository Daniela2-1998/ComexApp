package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniela
 */
public class ReportesEstadisticasCompraImpl {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    
    
    
    public int cantidadDeOperacionesDeCompraTotales(){
        
        String sql = "select count(tipo_operacion) from ventalocal where tipo_operacion ='Compra'";
       
        int cantidadTotalImpos = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cantidadTotalImpos = rs.getInt(1);
            }

            System.out.println("Total de compras: "+ cantidadTotalImpos);
        }catch(SQLException e){
            System.err.println(e);
        }
        return cantidadTotalImpos;
    }
    
    
    public String vendedorMasRepetido(){

       String vendedorMasRepetido = null;
        
       String sql = "select vendedor, COUNT(vendedor) as maximo from ventalocal "
               + "where tipo_operacion = 'Compra'"
               + "group by vendedor order by vendedor desc limit 1";
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               vendedorMasRepetido = rs.getString(1);
           }
           System.out.println("Mayor cantidad de pedidos a: " + vendedorMasRepetido);
           
       }catch(SQLException e){
           System.err.println(e);
       }
       return vendedorMasRepetido;    
    }
    
    
    public String productoMasComprado(){

       String productoMasRepetido = null;
       
       String sql = "select productos_pedidos, COUNT(productos_pedidos) as maximo from ventalocal "
               + "where tipo_operacion = 'Compra'"
               + "group by productos_pedidos order by productos_pedidos desc limit 1";
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               productoMasRepetido = rs.getString(1);
           }
           System.out.println("Producto más comprado: " + productoMasRepetido);
           
       }catch(SQLException e){
           System.err.println(e);
       }
       return productoMasRepetido;    
    }
    
}
