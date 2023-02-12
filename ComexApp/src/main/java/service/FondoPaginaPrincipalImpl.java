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
public class FondoPaginaPrincipalImpl{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    String fondoElegido;
    
    public void guardarFondo(String usuario){
        
        UsuariosImpl usuariosImpl = new UsuariosImpl();
        
        String fondo = "Defecto";
        int ID = usuariosImpl.obtenerIDUsuario(usuario);
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("insert into fondo_pantalla values (?, ?, ?)");
            
            pst.setInt(1, ID);
            pst.setString(2, fondo);
            pst.setString(3, usuario);
            
            pst.executeUpdate();
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se puede guardar fondo " + e);
        }
        
    }
    
    public String recuperarFondoElegido(String usuario){
        
        String fondoElegido = null;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select fondo from fondo_pantalla "
                    + "where usuario = '" + usuario + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                fondoElegido = rs.getString("fondo");
            }
            conec.close();
        }catch(SQLException e){
            System.err.println("No se puede recuperar el fondo elegido " + e);
        }
        
        return fondoElegido;
    }
    
    
    public void cambiarAFondoDefecto(String usuario){
     
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update fondo_pantalla set fondo=? "
                    + "where usuario ='" + usuario + "'");
            pst.setString(1, "Defecto");
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No es posible cambiar a fondo defecto " + e);
        }
    }
    
    public void cambiarAFondo(String usuario){
     
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update fondo_pantalla set fondo=? "
                    + "where usuario ='" + usuario + "'");
            pst.setString(1, "Fondo");
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No es posible cambiar a fondo " + e);
        }
    }
    
    public void cambiarAFondo3(String usuario){
     
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update fondo_pantalla set fondo=? "
                    + "where usuario ='" + usuario + "'");
            pst.setString(1, "Fondo 3");
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No es posible cambiar a fondo3 " + e);
        }
    }
    
    
    public void cambiarAFondo4(String usuario){
     
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("update fondo_pantalla set fondo=? "
                    + "where usuario ='" + usuario + "'");
            pst.setString(1, "Fondo 4");
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No es posible cambiar a fondo4 " + e);
        }
    }
    

    public void eliminarFondo(String usuario, int id){
       
        String sql = "delete from fondo_pantalla where usuario = '" + usuario + "' "
               + "and id_fondo = '" + id + "'";
       
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);

           pst.executeUpdate();
           conec.close();
          
       }catch(SQLException e){
           System.err.println("No se pudo eliminar el registro solicitado " + e);
           JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro "
                   + "solicitado");
       }
    }
}




