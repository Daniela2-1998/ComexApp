package service;

import config.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Daniela
 */
public class NotasService {
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    JTextField textBusqueda = new JTextField();
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    String numeroNota;
    
    
    public void crearNota(String usuario, String titulo, int id, String contenido, 
            String ubicacion, String colorElegido, String letraElegida){

        String status = "Activo";
       
        LocalDate fechaDate = LocalDate.now();
        String fecha = fechaDate.toString();
        
        String visibilidad = "Solo creador";
        
        String sql = "insert into notas values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, id);
            pst.setString(2, colorElegido);
            pst.setString(3, contenido);
            pst.setString(4, usuario);
            pst.setString(5, titulo);
            pst.setString(6, status);
            pst.setString(7, ubicacion);
            pst.setString(8, fecha);
            pst.setString(9, visibilidad);
            pst.setString(10, letraElegida);
            
            pst.executeUpdate();
            conec.close();
            JOptionPane.showMessageDialog(null, "Se creó exitosamente la nota");
            
        }catch(SQLException e){
            System.err.println("Error al crear nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible crear una nota");
        }
        
    }
    
    public void modificarNota(String usuario, String tituloMod, String contenidoMod, 
            String ubicacionMod, String color, String letra){
        
        int alternativaMensaje;

        String sql = "update notas set titulo=?, contenido=?, ubicacion=?, color=?, "
                + "letra=? where usuario = '" + usuario + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, tituloMod);
                pst.setString(2, contenidoMod);
                pst.setString(3, ubicacionMod);
                pst.setString(4, color);
                pst.setString(5, letra);
                
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
    
    public void notaInactiva(String titulo, String ubicacion, String usuario){
        
        String sql = "update notas set status=? where usuario = '" + usuario + 
                "' and ubicacion = '" + ubicacion + "' and titulo = '" + titulo + "'";
        
        int alternativaMensaje;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
             alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, "Inactiva");
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");
             } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }
        }catch(SQLException e){
            System.err.println("No es posible dejar inactiva la nota");
            JOptionPane.showMessageDialog(null, "No es posible dejar inactiva " + titulo);
        }
    }
    
    public void modificarUbicacionNota(String ubicacion, String usuario, String titulo){
        
        String sql = "update notas set ubicacion=? where usuario = '" + usuario + 
                "' and titulo = '" + titulo + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            pst.setString(1, ubicacion);
            pst.executeQuery();
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al cambiar ubicación de la nota " + e);
        }
    }
    
    public void obtenerNota1(String usuario, JTextField textID, 
            JTextField textNombre, JTextPane textContenido){

        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 1' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){ 
                textID.setText(rs.getString("id_nota")); 
                textNombre.setText(rs.getString("titulo"));    
                textContenido.setText(rs.getString("contenido"));
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    
    public void obtenerNota2(String usuario, JTextField textID1, 
            JTextField textNombre1, JTextPane textContenido2, JPanel Nota2, 
            JButton jButtonAgregar1, JButton jButtonModificar1){

        
        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 2' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID1.setText(rs.getString("id_nota")); 
                textNombre1.setText(rs.getString("titulo"));    
                textContenido2.setText(rs.getString("contenido"));
            } 
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    public void obtenerNota3(String usuario, JTextField textID2, 
            JTextField textNombre2, JTextPane textContenido3, JPanel Nota3, 
            JButton jButtonAgregar2, JButton jButtonModificar2){

        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 3' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID2.setText(rs.getString("id_nota")); 
                textNombre2.setText(rs.getString("titulo"));    
                textContenido3.setText(rs.getString("contenido"));
            } 
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    
    public void obtenerNota4(String usuario, JTextField textID3, 
            JTextField textNombre3, JTextPane textContenido4, JPanel Nota4, 
            JButton jButtonAgregar3, JButton jButtonModificar3){
        
        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 4' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID3.setText(rs.getString("id_nota")); 
                textNombre3.setText(rs.getString("titulo"));    
                textContenido4.setText(rs.getString("contenido"));
            } 
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    public void obtenerNota5(String usuario, JTextField textID4, 
            JTextField textNombre4, JTextPane textContenido5, JPanel Nota5, 
            JButton jButtonAgregar4, JButton jButtonModificar4){
        
        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 5' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID4.setText(rs.getString("id_nota")); 
                textNombre4.setText(rs.getString("titulo"));    
                textContenido5.setText(rs.getString("contenido"));
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    public void obtenerNota6(String usuario, JTextField textID5, 
            JTextField textNombre5, JTextPane textContenido6, JPanel Nota6, 
            JButton jButtonAgregar5, JButton jButtonModificar5){

        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 6' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID5.setText(rs.getString("id_nota")); 
                textNombre5.setText(rs.getString("titulo"));    
                textContenido6.setText(rs.getString("contenido"));
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    
    public void obtenerNota7(String usuario, JTextField textID6, 
            JTextField textNombre6, JTextPane textContenido7, JPanel Nota7, 
            JButton jButtonAgregar6, JButton jButtonModificar6){

        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 7' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID6.setText(rs.getString("id_nota")); 
                textNombre6.setText(rs.getString("titulo"));    
                textContenido7.setText(rs.getString("contenido"));
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    public void obtenerNota8(String usuario, JTextField textID7, 
            JTextField textNombre7, JTextPane textContenido8, JPanel Nota8, 
            JButton jButtonAgregar7, JButton jButtonModificar7){

        String sql = "select id_nota, contenido, titulo from notas where "
                + "ubicacion = 'Nota 8' and usuario = '" + usuario + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID7.setText(rs.getString("id_nota")); 
                textNombre7.setText(rs.getString("titulo"));    
                textContenido8.setText(rs.getString("contenido"));
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No es posible recuperar la nota " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar la nota");
        }
    }
    
    
    public void obtenerNotaPedida(String usuario, JTextField textID, 
            JTextField textNombre, JTextPane textContenido){
        
        String buscar = textBusqueda.getText().trim();
        
        String sql = "select id_nota, contenido, titulo from notas where "
                + "titulo = '" + buscar + "' and usuario = '" + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){

                textID.setText(rs.getString("id_nota")); 
                textNombre.setText(rs.getString("titulo"));    
                textContenido.setText(rs.getString("contenido"));

            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener la nota solicitada" + e);
            JOptionPane.showMessageDialog(null, "No se puede obtener la nota");
        }
        
    }
     
    public String obtencionColorNota(String usuario, String ubicacion){
        
        String colorRecuperado = null;
        
        String sql = "select color from notas where usuario = '" + usuario + "' and "
                + "ubicacion = '" + ubicacion + "' and status = 'Activo'";
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                colorRecuperado = rs.getString("color");
            }else{
                colorRecuperado = "Amarillo";
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se puede recuperar el color " + e);
        }
        
        return colorRecuperado;
    }
    
    public String obtencionFuenteNota(String usuario, String ubicacion){
        
        String letraRecuperada = null;
        
        String sql = "select letra from notas where usuario = '" + usuario + "' and "
                + "ubicacion = '" + ubicacion + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                letraRecuperada = rs.getString("letra");
            }else{
                letraRecuperada = "Segoe";
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se puede recuperar el color " + e);
        }
        
        return letraRecuperada;
    }
   
       
    public void cambiarColorNota (String usuario, String ubicacion, String color){
        
        String sql = "update notas set color=? where usuario = '" + usuario + 
                "' and ubicacion = '" + ubicacion + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            int alternativaMensaje;

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, color);
         
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa de color de nota");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificó el color de nota");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para"
                    + "modificar datos" + e);
        }

    }
    
    
    
    public void cambiarFuenteNota (String usuario, String ubicacion, String letra){
        
        String sql = "update notas set letra=? where usuario = '" + usuario + 
                "' and ubicacion = '" + ubicacion + "' and status = 'Activo'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            int alternativaMensaje;

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, letra);
         
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa de fuente");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificó la fuente");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para"
                    + "modificar datos" + e);
        }

    }
    

    public boolean eliminarNota(int ID, String usuario, String titulo, String ubicacion){
       
        String sql = "delete from notas where usuario = '" + usuario + "' and titulo = '"
                + titulo + "' and id_nota = '" + ID + "' and ubicacion =  '" + ubicacion + "' and status = 'Activo'";
       
       int alternativaMensaje;
       Boolean aprobado;
       
       try{
           conec = cn.Conexion();
           pst = conec.prepareStatement(sql);
           
           
           alternativaMensaje = JOptionPane.showConfirmDialog(null, "Estás por eliminar un registro, "
                    + "¿está seguro de que quieres hacerlo?");
           
           if(alternativaMensaje == 0){
               pst.executeUpdate();
               aprobado = true;
               JOptionPane.showMessageDialog(null, "Eliminación de registro "
                    + "éxitosa");
               conec.close();
               return aprobado;
           } else {
               conec.close();
               aprobado = false;
               JOptionPane.showMessageDialog(null, "No se ha eliminado el registro");
               return aprobado;
           }
       }catch(SQLException e){
           System.err.println("No se pudo eliminar el registro solicitado " + e);
           JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro "
                   + "solicitado");
       }
       return eliminacionAprobada;
    }

     
}
