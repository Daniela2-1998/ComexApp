package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class ReportesEstadisticasVentaLocalImpl {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    
    
    
    public int cantidadDeOperacionesDeVentaTotales(){
        
        String sql = "select count(tipo_operacion) from ventalocal where tipo_operacion ='Venta'";
       
        int cantidadTotalVentas = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cantidadTotalVentas = rs.getInt(1);
            }
            conec.close();
            System.out.println("Ventas totales : "+ cantidadTotalVentas);
        }catch(SQLException e){
            System.err.println(e);
        }
        return cantidadTotalVentas;
    }
    

    public String compradorMasRepetido(){

       String compradorMasRepetido = null;
       
       String sql = "select comprador, COUNT(comprador) as maximo from ventalocal "
               + "where tipo_operacion = 'Venta'"
               + "group by comprador order by comprador desc";
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               compradorMasRepetido = rs.getString(1);
           }
           System.out.println("Mayor cantidad de ventas a: " + compradorMasRepetido);
           
       }catch(SQLException e){
           System.err.println(e);
       }
       return compradorMasRepetido;    
    }
    
    
    public String productoMasVendido(){

       String productoMasRepetido = null;
       
       String sql = "select productos_pedidos, COUNT(productos_pedidos) as maximo from ventalocal "
               + "where tipo_operacion = 'Venta'"
               + "group by productos_pedidos order by productos_pedidos desc limit 3";
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               productoMasRepetido = rs.getString(1);
           }
           System.out.println("Producto más vendido: " + productoMasRepetido);
           
       }catch(SQLException e){
           System.err.println(e);
       }
       return productoMasRepetido;    
    }
    
    
    
    public void productosMasExportados(JTextField textProducto1, JTextField textProducto2, 
            JTextField textProducto3, JTextField textProducto4, JTextField textProducto5){

        /*as maximo */
       
       String sql = "select producto, COUNT(productos_pedidos) as maximo from operaciones "
               + "where tipo_operacion = 'Exportación'"
               + "group by productos_pedidos order by productos_pedidos desc limit 5"; 

       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           if(rs.next()){
               String [] productos = new String[5];

               productos[1] = String.valueOf(rs.getObject(1));
               productos[2] = String.valueOf(rs.getObject(2));      
               productos[3] = String.valueOf(rs.getObject(3));  
               productos[4] = String.valueOf(rs.getObject(4));  
               productos[5] = String.valueOf(rs.getObject(5));  
                       
               textProducto1.setText(productos[1]);
               textProducto2.setText(productos[2]);
               textProducto3.setText(productos[3]);
               textProducto4.setText(productos[4]);
               textProducto5.setText(productos[5]); 
               
               System.out.println(productos[1] + productos[3]);
            } else {
               JOptionPane.showMessageDialog(null, "No es posible recuperar productos");
           }
           
           
       }catch(SQLException e){
           System.err.println("Lista productos: " + e);
       }   
    }
}
