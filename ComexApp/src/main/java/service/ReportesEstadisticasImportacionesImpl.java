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
public class ReportesEstadisticasImportacionesImpl implements ReportesEstadisticasImportacionesService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    
    
    
    public int cantidadDeOperacionesDeImportacionTotales(){
        
        String sql = "select count(tipo_operacion) from operaciones where tipo_operacion ='Importación'";
       
        int cantidadTotalImpos = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cantidadTotalImpos = rs.getInt(1);
            }

            System.out.println("El total de registros es : "+ cantidadTotalImpos);
        }catch(SQLException e){
            System.err.println(e);
        }
        return cantidadTotalImpos;
    }
    
    
    public String vendedorMasRepetido(){

       String vendedorMasRepetido = null;
        
       String sql = "select vendedor, COUNT(vendedor) as maximo from operaciones "
               + "where tipo_operacion = 'Importación'"
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
    
    
    public String productoMasImportado(){

       String productoMasRepetido = null;
       
       String sql = "select producto, COUNT(producto) as maximo from operaciones "
               + "where tipo_operacion = 'Importación'"
               + "group by producto order by producto desc limit 2";
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               productoMasRepetido = rs.getString(1);
           }
           System.out.println("Producto más importado: " + productoMasRepetido);
           
       }catch(SQLException e){
           System.err.println(e);
       }
       return productoMasRepetido;    
    }
    
}
