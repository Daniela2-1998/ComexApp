package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class OperacionInternacionalParticipantesImpl implements OperacionInternacionalParticipantesService{
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void ingresarConexionesOpInt(int numeroOpInt, String codigo){
        
        ContenedoresImpl contenedoresImpl = new ContenedoresImpl();
        int cod = contenedoresImpl.obtenerIDConCodigoDelContenedor(codigo);
        
        String sql = "insert into participantes_opint values (?, ?, ?, ?, ?, ?, ?, ?)";
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, numeroOpInt);
                pst.setInt(2, cod);
                pst.setInt(3, 0);
                pst.setInt(4, 0);
                pst.setInt(5, 0);
                pst.setInt(6, 0);
                pst.setInt(7, numeroOpInt);
                pst.setString(8, "En uso");                
                
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
    
    public void agregarIDContenedor(int idContenedor, int idOperacion){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_contenedor=? "
                   + "where numero_opint = '" + idOperacion + "'");
           
           pst.setInt(1, idContenedor);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Asociación éxitosa", "Asociar a contenedor", 0);
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del contenedor " + e);
        }  
    }
    
    public void agregarIDProducto(int idProducto, int idOperacion){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_producto=? "
           + "where numero_opint = '" + idOperacion + "'");
           
           pst.setInt(1, idProducto);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Asociación éxitosa", "Asociar a producto", 0);
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del producto " + e);
        }  
    }
    
    public void agregarIDDespachante(int idDespachante, int idOperacion){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_despachante=? "
           + "where numero_opint = '" + idOperacion + "'");
           
           pst.setInt(1, idDespachante);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Asociación éxitosa", "Asociar a despachante", 0);
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del despachante " + e);
        }  
    }
    
    public void agregarIDImportador(int idImportador, int idOperacion){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_importador=? "
           + "where numero_opint = '" + idOperacion + "'");
           
           pst.setInt(1, idImportador);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Asociación éxitosa", "Asociar a importador", 0);
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del importador " + e);
        }  
    }
    
    public void agregarIDExportador(int idExportador, int idOperacion){
        
        try{
           conec = cn.Conexion();
           pst = conec.prepareStatement("update participantes_opint set id_exportador=? "
           + "where numero_opint = '" + idOperacion + "'");
           
           pst.setInt(1, idExportador);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Asociación éxitosa", "Asociar a exportador", 0);
           conec.close();
        }catch(SQLException e){
            System.err.println("No es posible agregar el ID del exportador " + e);
        }  
    }
}

