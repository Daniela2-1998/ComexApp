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
public class ColorPaginaPrincipalImpl implements ColorPaginaPrincipalService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    String colorElegido;
    
    public void crearColor(String usuario){
        
        UsuariosImpl usuariosImpl = new UsuariosImpl();
        
        String color = "Defecto";
        int ID = usuariosImpl.obtenerIDUsuario(usuario);
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("insert into colores_pagina_principal values (?, ?, ?)");
            
            pst.setInt(1, ID);
            pst.setString(2, color);
            pst.setString(3, usuario);
            
            pst.executeUpdate();
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se puede crear color " + e);
        }
        
    }
    
    public String recuperarColorElegido(String usuario){
        
        String colorElegido = null;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select color from colores_pagina_principal "
                    + "where usuario = '" + usuario + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                colorElegido = rs.getString("color");
            }
            conec.close();
        }catch(SQLException e){
            System.err.println("No se puede recuperar color elegido " + e);
        }
        
        return colorElegido;
    }
    
    
    public void cambiarAColorDefecto(String usuario){
     
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update colores_pagina_principal set color=? "
                    + "where usuario ='" + usuario + "'");
            pst.setString(1, "Defecto");
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No es posible cambiar a color defecto " + e);
        }
    }
    
    public void cambiarAColorInvertido(String usuario){
     
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update colores_pagina_principal set color=? "
                    + "where usuario ='" + usuario + "'");
            pst.setString(1, "Invertido");
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No es posible cambiar a color invertido " + e);
        }
    }
    
   public void eliminarColor(String usuario, int id){
       
        String sql = "delete from colores_pagina_principal where usuario = '" + usuario + "' "
               + "and id_colores = '" + id + "'";
       
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);

           pst.executeUpdate();
           conec.close();
          
       }catch(SQLException e){
           System.err.println("No se pudo eliminar el registro solicitado " + e);
       }
    }
 
    
    
}



