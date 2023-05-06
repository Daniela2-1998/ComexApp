package service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import config.Conexion;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class InformesPersonalizadosImpl implements InformesPersonalizadosService{
    
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
    
    
    public void busquedaPorNombre(String nombre, String usuario, JTextField textNumero, 
            JTextField textNombre, JTextField textTitulo, JTextArea textParrafo){
        
        String sql = "select id_informe_pers, nombre, parrafo1, titulo1 from "
                + "informes_personalizados where usuario_creador = '" + usuario + "' and "
                + "nombre = '" + nombre + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt("id_informe_pers");
                String numero = String.valueOf(id);
                textNumero.setText(numero);
                textTitulo.setText(rs.getString("titulo1"));
                textNombre.setText(rs.getString("nombre"));
                textParrafo.setText(rs.getString("parrafo1"));
            }else{
                JOptionPane.showMessageDialog(null, "No es posible recuperar el "
                        + "nombre del informe solicitado");
            }
            
        }catch(SQLException e){
            System.err.println("Error al buscar por nombre de informe " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar el informe "
                    + nombre);
        }
    }
     
     
    public void busquedaPorID(int ID, String usuario, JTextField textNumero, 
            JTextField textNombre, JTextField textTitulo, JTextArea textParrafo){
        
        String sql = "select id_informe_pers, nombre, parrafo1, titulo1 from "
                + "informes_personalizados where usuario_creador = '" + usuario + "' and "
                + "id_informe_pers = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String numero = String.valueOf(ID);
                textNumero.setText(numero);
                textTitulo.setText(rs.getString("titulo1"));
                textNombre.setText(rs.getString("nombre"));
                textParrafo.setText(rs.getString("parrafo1"));
            }else{
                JOptionPane.showMessageDialog(null, "No es posible recuperar el ID");
            }
            
        }catch(SQLException e){
            System.err.println("Error al buscar por ID " + e);
            JOptionPane.showMessageDialog(null, "No es posible recuperar el informe "
                    + "N°" + ID);
        }
    }
    
    public Boolean recuperarID(String usuario, String titulo, JTextField textNumero){

        Boolean idRecuperado = null;
        
        String sql = "select id_informe_pers from informes_personalizados where "
                + "usuario = '" + usuario + "' and titulo = " + titulo + "'";
        
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
                + "where id_informe_pers = '" + id + "'";

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
    
     public void agregarTitulo3 (int id, String titulo3){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set titulo3=? "
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar titulo3?");

            if (alternativaMensaje == 0) {

                pst.setString(1, titulo3);
  
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
    
    public void agregarTitulo4 (int id, String titulo4){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set titulo4=? "
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar titulo4?");

            if (alternativaMensaje == 0) {

                pst.setString(1, titulo4);
  
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
     
   public void agregarTitulo5(int id, String titulo5){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set titulo5=? "
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar titulo5?");

            if (alternativaMensaje == 0) {

                pst.setString(1, titulo5);
  
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
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar parrafo2?");

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
    
    public void agregarParrafo3 (int id, String parrafo3){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set parrafo3=? "
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar parrafo3?");

            if (alternativaMensaje == 0) {

                pst.setString(1, parrafo3);
  
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
    
    
    public void agregarParrafo4 (int id, String parrafo4){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set parrafo4=? "
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar parrafo4?");

            if (alternativaMensaje == 0) {

                pst.setString(1, parrafo4);
  
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
    
    public void agregarParrafo5 (int id, String parrafo5){
        
        int alternativaMensaje;

        String sql = "update informes_personalizados set parrafo5=? "
                + "where id_informe_pers = '" + id + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres agregar parrafo5?");

            if (alternativaMensaje == 0) {

                pst.setString(1, parrafo5);
  
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
    
    
    public void existeTituloYParrafo1(int ID, JTextField textTitulo1, JTextField textTitulo6){
        
        Boolean existe;
        
        String sql = "select titulo1, parrafo1 from informes_personalizados "
                + "where id_informe_pers = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textTitulo1.setText("Titulo 1");
                textTitulo6.setText("Párrafo 1");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    public void existeTituloYParrafo2(int ID, JTextField textTitulo2, JTextField textTitulo7){
        
        Boolean existe;
        
        String sql = "select titulo2, parrafo2 from informes_personalizados "
                + "where id_informe_pers = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textTitulo2.setText("Titulo 2");
                textTitulo7.setText("Párrafo 2");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    public void existeTituloYParrafo3(int ID, JTextField textTitulo3, JTextField textTitulo8){
        
        Boolean existe;
        
        String sql = "select titulo3, parrafo3 from informes_personalizados "
                + "where id_informe_pers = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textTitulo3.setText("Titulo 3");
                textTitulo8.setText("Párrafo 3");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    public void existeTituloYParrafo4(int ID, JTextField textTitulo4, JTextField textTitulo9){
        
        Boolean existe;
        
        String sql = "select titulo4, parrafo4 from informes_personalizados "
                + "where id_informe_pers = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textTitulo4.setText("Titulo 4");
                textTitulo9.setText("Párrafo 4");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    public void existeTituloYParrafo5(int ID, JTextField textTitulo5, JTextField textTitulo10){
        
        Boolean existe;
        
        String sql = "select titulo5, parrafo5 from informes_personalizados "
                + "where id_informe_pers = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textTitulo5.setText("Titulo 5");
                textTitulo10.setText("Párrafo 5");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    
     /*------------------------------------------------------------------------
                                 PDF PERSONALIZADO
      -------------------------------------------------------------------------
     */
    
    public void pdfInformePersonalizado(String usuario, int id, String nombreInforme,
             String dia, String mes, String año){
         
        

            String sql = "select id_informe_pers, nombre, parrafo1, parrafo2, "
                    + "parrafo3, parrafo4, parrafo5, titulo1, titulo2, titulo3, "
                    + "titulo4, titulo5 from informes_personalizados where "
                    + "usuario_creador = '" + usuario + "' and id_informe_pers = '" 
                    + id + "'";   
            
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                rs = pst.executeQuery();
                
                if(rs.next()){
      
                    Document documento = new Document();

                    try {
                        //ruta donde se guardará PDF
                        String ruta = System.getProperty("user.home");
                        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/"
                                + usuario + nombreInforme + dia + mes + año + ".pdf"));

                        documento.open();

                        // contenido del PDF. /  imagén de arriba
                        com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
                        header.scaleToFit(100, 100);
                        header.setAlignment(Chunk.ALIGN_CENTER);
                    
                        String nombre = rs.getString("nombre");
                        String titulo1 = rs.getString("titulo1");
                        String titulo2 = rs.getString("titulo2");
                        String titulo3 = rs.getString("titulo3");
                        String titulo4 = rs.getString("titulo4");
                        String titulo5 = rs.getString("titulo5");
                        String parrafo1 = rs.getString("parrafo1");
                        String parrafo2 = rs.getString("parrafo2");
                        String parrafo3 = rs.getString("parrafo3");
                        String parrafo4 = rs.getString("parrafo4");
                        String parrafo5 = rs.getString("parrafo5");

                        // titulo
                        Paragraph titulo = new Paragraph();
                        titulo.setAlignment(Paragraph.ALIGN_CENTER);
                        titulo.add("ComexApp. \n \n " + nombreInforme + " N° " + id);
                        titulo.setFont(FontFactory.getFont("Tahoma", 50, 4, BaseColor.BLUE));

                        Paragraph subtitulo1 = new Paragraph();
                        subtitulo1.setAlignment(Paragraph.ALIGN_CENTER);
                        subtitulo1.add(titulo1 + "\n \n");
                        subtitulo1.setFont(FontFactory.getFont("Segoe UI", 16, Font.BOLD, BaseColor.BLUE));

                        Paragraph parraf1 = new Paragraph();
                        parraf1.setAlignment(Paragraph.ALIGN_BASELINE);
                        parraf1.add(parrafo1 + "\n \n");
                        parraf1.setFont(FontFactory.getFont("Segoe UI", 14, BaseColor.BLUE));

                        Paragraph subtitulo2 = new Paragraph();
                        subtitulo2.setAlignment(Paragraph.ALIGN_CENTER);
                        subtitulo2.add(titulo2 + "\n \n");
                        subtitulo2.setFont(FontFactory.getFont("Segoe UI", 16, Font.BOLD, BaseColor.BLUE));

                        Paragraph parraf2 = new Paragraph();
                        parraf2.setAlignment(Paragraph.ALIGN_BASELINE);
                        parraf2.add(parrafo2 + "\n \n");
                        parraf2.setFont(FontFactory.getFont("Segoe UI", 14, BaseColor.BLUE));

                        Paragraph subtitulo3 = new Paragraph();
                        subtitulo3.setAlignment(Paragraph.ALIGN_CENTER);
                        subtitulo3.add(titulo3 + "\n \n");
                        subtitulo3.setFont(FontFactory.getFont("Segoe UI", 16, Font.BOLD, BaseColor.BLUE));

                        Paragraph parraf3 = new Paragraph();
                        parraf3.setAlignment(Paragraph.ALIGN_BASELINE);
                        parraf3.add(parrafo3 + "\n \n");
                        parraf3.setFont(FontFactory.getFont("Segoe UI", 14, BaseColor.BLUE));

                        Paragraph subtitulo4 = new Paragraph();
                        subtitulo4.setAlignment(Paragraph.ALIGN_CENTER);
                        subtitulo4.add(titulo4 + "\n \n");
                        subtitulo4.setFont(FontFactory.getFont("Segoe UI", 16, Font.BOLD, BaseColor.BLUE));

                        Paragraph parraf4 = new Paragraph();
                        parraf4.setAlignment(Paragraph.ALIGN_BASELINE);
                        parraf4.add(parrafo4 + "\n \n");
                        parraf4.setFont(FontFactory.getFont("Segoe UI", 14, BaseColor.BLUE));

                        Paragraph subtitulo5 = new Paragraph();
                        subtitulo5.setAlignment(Paragraph.ALIGN_CENTER);
                        subtitulo5.add(titulo5 + "\n \n");
                        subtitulo5.setFont(FontFactory.getFont("Segoe UI", 16, Font.BOLD, BaseColor.BLUE));

                        Paragraph parraf5 = new Paragraph();
                        parraf5.setAlignment(Paragraph.ALIGN_BASELINE);
                        parraf5.add(parrafo5 + "\n \n");
                        parraf5.setFont(FontFactory.getFont("Segoe UI", 14, BaseColor.BLUE));

                        // agregar contenido al PDF.
                        documento.open();
                        documento.add(header);
                        documento.add(titulo);
                        documento.add(subtitulo1);
                        documento.add(parraf1);
                        documento.add(subtitulo2);
                        documento.add(parraf2);
                        documento.add(subtitulo3);
                        documento.add(parraf3);
                        documento.add(subtitulo4);
                        documento.add(parraf4);
                        documento.add(subtitulo5);
                        documento.add(parraf5);
                    

                        documento.close();

                        JOptionPane.showMessageDialog(null, "Informe personalizado "
                                + "creado correctamente, encontrarás el PDF en la carpeta de "
                                + "descargas con tu nombre de usuario y nombre del PDF.",
                                "Informe personalizado", 0);
                    
                    } catch (DocumentException | IOException e) {
                        System.err.print("Error en PDF o ruta de imagen " + e);
                        JOptionPane.showMessageDialog(null, "Error al generar PDF");
                    }
                }

            }catch(SQLException e){
                System.err.println("No se puede recuperar los detalles del informe "
                        + "personalizado " + nombreInforme);
            }                
    }
    
     
    
}
