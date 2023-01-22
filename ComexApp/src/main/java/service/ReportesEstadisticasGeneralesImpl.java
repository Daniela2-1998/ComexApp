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
public class ReportesEstadisticasGeneralesImpl {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    
    
    
    public int cantidadDeOperacionesInternacionalesRegistradas(){   
        
        String sql1 = "SELECT COUNT(*) FROM operaciones";
        int cantidadTotal = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql1);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cantidadTotal = rs.getInt(1);
            }

            System.out.println("El total de operaciones internacionales realizadas "
                    + "es de: "+ cantidadTotal);
        }catch(SQLException e){
            System.err.println(e);
        }
        return cantidadTotal;
    }
    
    
     public int cantidadDeOperacionesNacionalesRegistradas(){   
        
        String sql1 = "SELECT COUNT(*) FROM ventalocal";
        int cantidadTotal = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql1);
            rs = pst.executeQuery();
            
            while (rs.next()){
                cantidadTotal = rs.getInt(1);
            }

            System.out.println("El total de operaciones nacionales realizadas "
                    + "es de: "+ cantidadTotal);
        }catch(SQLException e){
            System.err.println(e);
        }
        return cantidadTotal;
    }
}
