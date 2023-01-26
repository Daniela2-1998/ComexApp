package service;

import config.Conexion;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class ArchivosPersonalesImpl {
    
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    public void subidaArchivos(int ID, FileInputStream fis, File archivo, String fecha, String nombre){

        String sql = "insert into archivos_personales values (?, ?, ?, ?)";

            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);

                pst.setInt(1, ID);
                pst.setBinaryStream(2, fis,(int) archivo.length());
                pst.setString(3, fecha);
                pst.setString(4, nombre);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Archivo almacenado");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede almacenar el archivo");
                System.err.println("No es posible almacenar" + e);
            }
    }
    
    
    
}
