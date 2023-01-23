package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Daniela
 */
public class InformesPersonalizadosImpl {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
   
    String numeroNota;
    
    
    public void crearInformePersonalizado(int id, String usuario, String nombre, 
            String titulo1, String parrafo1){

        String parrafo2 = "";
        String parrafo3 = "";
        String parrafo4 = "";
        String parrafo5 = "";
        
        String titulo2 = "";
        String titulo3 = "";
        String titulo4 = "";
        String titulo5 = "";
        
        String sql = "insert into informes_personalizados values (?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setString(3, parrafo1);
            pst.setString(4, parrafo2);
            pst.setString(5, parrafo3);
            pst.setString(6, parrafo4);
            pst.setString(7, parrafo5);
            pst.setString(8, titulo1);
            pst.setString(9, titulo2);
            pst.setString(10, titulo3);
            pst.setString(11, titulo4);
            pst.setString(12, titulo5);
            pst.setString(13, usuario);
            
            pst.executeUpdate();
            conec.close();
            JOptionPane.showMessageDialog(null, "Se creó exitosamente el modelo de informe");
            
        }catch(SQLException e){
            System.err.println("Error al crear nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible crear el informe");
        }
        
    }
    
    public void modificarInforme(int id, String nombre, String titulo1, String titulo2, 
            String titulo3, String titulo4, String titulo5, String parrafo1, 
            String parrafo2, String parrafo3, String parrafo4, String parrafo5){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set nombre=?, titulo1=?, "
                + "titulo2=?, titulo3=?, titulo4=?, titulo5=?, parrafo1=?, "
                + "parrafo2=?, parrafo3=?, parrafo4=?, parrafo5=? where nombre = '" 
                + nombre + "' and id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, nombre);
                pst.setString(2, titulo1);
                pst.setString(3, titulo2);
                pst.setString(4, titulo3);
                pst.setString(5, titulo4);
                pst.setString(6, titulo5);
                pst.setString(7, parrafo1);
                pst.setString(8, parrafo2);
                pst.setString(9, parrafo3);
                pst.setString(10, parrafo4);
                pst.setString(11, parrafo5);
                
                
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para"
                    + "modificar datos" + e);
        }
    }
    
    
    public Boolean recuperarID(String usuario, JTextField textNumero){

        Boolean idRecuperado = null;
        
        String sql = "select id_informe_pers from informes_personalizados where "
                + "usuario = '" + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){ 
                textNumero.setText(rs.getString("id_informe_pers")); 
                idRecuperado = true;
            } else{
                idRecuperado = false;
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar el N° " + e);
        }
        return idRecuperado;
    }
    
    
    public void agregarTitulo2 (int id, String titulo2){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set titulo2=? "
                + "where nombre id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar titulo2?");

            if (alternativaMensaje == 0) {

                pst.setString(1, titulo2);
  
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para"
                    + "modificar datos" + e);
        }
    }
    
     public void agregarParrafo2 (int id, String parrafo2){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set parrafo2=? "
                + "where nombre id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar titulo2?");

            if (alternativaMensaje == 0) {

                pst.setString(1, parrafo2);
  
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para"
                    + "modificar datos" + e);
        }
    }
    
    
}
