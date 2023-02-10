package service;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class OperacionInternacionalParticipantesImpl {
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void ingresarConexionesOpInt(int numeroOpInt, String codigo){
        
        ContenedoresImpl contenedoresImpl = new ContenedoresImpl();
        int cod = contenedoresImpl.obtenerIDConCodigoDelContenedor(codigo);
        
        String sql = "insert into participantes_opint values (?, ?, ?, ?, ?, ?, ?)";
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, numeroOpInt);
                pst.setInt(2, cod);
                pst.setInt(3, 0);
                pst.setInt(4, 0);
                pst.setInt(5, 0);
                pst.setInt(6, 0);
                pst.setString(7, "En uso");                
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se creó una asociación a "
                        + "una operación internacional");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede conectar la "
                        + "operación");
                System.err.println("No se puede añadir la asociación " + e);
            }
    }
    
    public void agregarIDContenedor(int idContenedor){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_contenedor=?");
           
           pst.setInt(1, idContenedor);
           pst.executeUpdate();
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del contenedor " + e);
        }  
    }
    
    public void agregarIDProducto(int idProducto){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_producto=?");
           
           pst.setInt(1, idProducto);
           pst.executeUpdate();
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del producto " + e);
        }  
    }
    
    public void agregarIDDespachante(int idDespachante){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_despachante=?");
           
           pst.setInt(1, idDespachante);
           pst.executeUpdate();
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del despachante " + e);
        }  
    }
    
    public void agregarIDImportador(int idImportador){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_importador=?");
           
           pst.setInt(1, idImportador);
           pst.executeUpdate();
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del importador " + e);
        }  
    }
    
    public void agregarIDExportador(int idExportador){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_exportador=?");
           
           pst.setInt(1, idExportador);
           pst.executeUpdate();
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del exportador " + e);
        }  
    }
}

