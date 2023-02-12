package service;

import Daniela.ComexApp.Frames.PaginaPrincipal;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


// pdf
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.Conexion;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Daniela
 */

public class PDFContactosImpl implements PDFContactosService {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
   
    ImageIcon logo = new ImageIcon("imagenes/logo12.png");
    Icon iconoLogo = new ImageIcon(logo.getImage());

    
    
        
     /*------------------------------------------------------------------------
                                 PDF TODOS LOS CONTACTOS
      -------------------------------------------------------------------------
     */
    
    // método de creación PDF de todos los contactos
    public void pdfTodosLosContactos(String usuario, String nombreCompleto, 
            String dia, String mes, String año){
        Document documento = new Document();

        try {
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaContactosCompleta" + dia + mes + año +".pdf"));
 
            documento.open();

            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_CENTER); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Tahoma", 50, 4, BaseColor.BLUE));
      
            
            // PARRAFO 1 EXPORTADORES
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Exportadores:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            // crear la tabla del PDF.
            PdfPTable tablaExportadores = new PdfPTable(5);
            tablaExportadores.addCell("ID");
            tablaExportadores.addCell("Nombre");
            tablaExportadores.addCell("Empresa");
            tablaExportadores.addCell("Pais");
            tablaExportadores.addCell("Status");

            tablaExportadores.setSpacingAfter(40);
            
            PdfPTable tablaExportadores1 = new PdfPTable(3);
            tablaExportadores1.addCell("ID");
            tablaExportadores1.addCell("Mail");
            tablaExportadores1.addCell("Número");
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_exportador, empleado, "
                        + "empresa, pais, status from exportadores order by id_exportador asc");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaExportadores.addCell(rs.getString(1));
                        tablaExportadores.addCell(rs.getString(2));
                        tablaExportadores.addCell(rs.getString(3));
                        tablaExportadores.addCell(rs.getString(4));
                        tablaExportadores.addCell(rs.getString(5));
                    }while(rs.next());
                    documento.add(tablaExportadores);  
                }
                                

            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de exportadores " + e);
            }
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_exportador, "
                        + "mail, numero_contacto from exportadores order "
                        + "by id_exportador asc"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaExportadores1.addCell(rs.getString(1));
                        tablaExportadores1.addCell(rs.getString(2));
                        tablaExportadores1.addCell(rs.getString(3));

                    } while (rs.next());
                    documento.add(tablaExportadores1);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla1 de exportadores " + e);
            }
            
            // PARRAFO 2 IMPORTADORES
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("\n\n");
            parrafo2.add("Importadores: \n \n");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaImportadores = new PdfPTable(5);
            tablaImportadores.addCell("ID");
            tablaImportadores.addCell("Nombre");
            tablaImportadores.addCell("Empresa");
            tablaImportadores.addCell("Pais");
            tablaImportadores.addCell("Status");

            tablaImportadores.setSpacingAfter(40);
            
            PdfPTable tablaImportadores1 = new PdfPTable(3);
            tablaImportadores1.addCell("ID");
            tablaImportadores1.addCell("Mail");
            tablaImportadores1.addCell("Número");
            
            documento.add(parrafo2);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_importador, empleado, empresa, "
                        + "pais, status from importadores order by id_importador asc");
                rs = pst.executeQuery();

                // completar información de la tabla
                if(rs.next()){
                    do{
                        
                        tablaImportadores.addCell(rs.getString(1));
                        tablaImportadores.addCell(rs.getString(2));
                        tablaImportadores.addCell(rs.getString(3));
                        tablaImportadores.addCell(rs.getString(4));
                        tablaImportadores.addCell(rs.getString(5));
                         
                    }while(rs.next());
                    documento.add(tablaImportadores);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de importadores " + e);
            }
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_importador, "
                        + "mail, numero_contacto from importadores order by "
                        + "id_importador asc");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaImportadores1.addCell(rs.getString(1));
                        tablaImportadores1.addCell(rs.getString(2));
                        tablaImportadores1.addCell(rs.getString(3));
                         
                    }while(rs.next());  
                    documento.add(tablaImportadores1);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla1 de importadores " + e);
            }
            
            tablaImportadores1.setSpacingAfter(35);
            
              // PARRAFO 3 DESPACHANTES
            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo3.add("\n\n");
            parrafo3.add("Despachantes: \n \n");
            parrafo3.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaDespachantes = new PdfPTable(5);
            tablaDespachantes.addCell("ID");
            tablaDespachantes.addCell("Nombre");
            tablaDespachantes.addCell("Empresa");
            tablaDespachantes.addCell("Pais");
            tablaDespachantes.addCell("Status");

            tablaDespachantes.setSpacingAfter(40);
            
            PdfPTable tablaDespachantes1 = new PdfPTable(3);
            tablaDespachantes1.addCell("ID");
            tablaDespachantes1.addCell("Mail");
            tablaDespachantes1.addCell("Número");
            
            documento.add(parrafo3);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_despachantes, empleado, empresa, "
                        + "pais, status from despachantes order by id_despachantes asc");
                
                rs = pst.executeQuery();
             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaDespachantes.addCell(rs.getString(1));
                        tablaDespachantes.addCell(rs.getString(2));
                        tablaDespachantes.addCell(rs.getString(3));
                        tablaDespachantes.addCell(rs.getString(4));
                        tablaDespachantes.addCell(rs.getString(5));        

                         
                    }while(rs.next());
                    documento.add(tablaDespachantes);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de despachantes " + e);
            }
            
             try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_despachantes, "
                        + "mail, numero_contacto from despachantes order by id_despachantes asc");
                rs = pst.executeQuery();
              
                // completar información de la tabla
                if(rs.next()){
                    do{                        
                        tablaDespachantes1.addCell(rs.getString(1));
                        tablaDespachantes1.addCell(rs.getString(2));
                        tablaDespachantes1.addCell(rs.getString(3));         
                    }while(rs.next());
                    documento.add(tablaDespachantes1);  

                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla1 de despachantes " + e);
            }
            
            tablaDespachantes.setSpacingAfter(35);
             
            // PARRAFO 4 MARITIMO
            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo4.add("\n\n");
            parrafo4.add("Marítimas: \n \n");
            parrafo4.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaMaritima = new PdfPTable(5);
            tablaMaritima.addCell("ID");
            tablaMaritima.addCell("Nombre");
            tablaMaritima.addCell("Empresa");
            tablaMaritima.addCell("Mail");
            tablaMaritima.addCell("Número");
            
            documento.add(parrafo4);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_maritima, empleado,"
                        + " empresa, mail, numero_contacto from maritimas "
                        + "order by id_maritima asc");
               rs = pst.executeQuery();

             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaMaritima.addCell(rs.getString(1));
                        tablaMaritima.addCell(rs.getString(2));
                        tablaMaritima.addCell(rs.getString(3));
                        tablaMaritima.addCell(rs.getString(4));
                        tablaMaritima.addCell(rs.getString(5));       
                    }while(rs.next());
                    documento.add(tablaMaritima);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener las tablas de marítimas " + e);
            }
  
               
              // PARRAFO 5 AEREO
            Paragraph parrafo5 = new Paragraph();
            parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo5.add("\n\n");
            parrafo5.add("Compañias aereas: \n \n");
            parrafo5.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaAereo = new PdfPTable(5);
            tablaAereo.addCell("ID");
            tablaAereo.addCell("Nombre");
            tablaAereo.addCell("Aerolinea");
            tablaAereo.addCell("Mail");
            tablaAereo.addCell("Número");
            
            documento.add(parrafo5);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_aereo, empleado, aerolinea, mail, "
            + "numero_contacto from aereo order by id_aereo asc");
               rs = pst.executeQuery();

             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaAereo.addCell(rs.getString(1));
                        tablaAereo.addCell(rs.getString(2));
                        tablaAereo.addCell(rs.getString(3));
                        tablaAereo.addCell(rs.getString(4));
                        tablaAereo.addCell(rs.getString(5));       
                    }while(rs.next());
                    documento.add(tablaAereo);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener las tablas de aerolíneas " + e);
            }
  
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de lista completa de "
                    + "contactos creado. \n\n " + nombreCompleto + ", encontrarás "
                    + "el PDF en la carpeta de descargas con tu nombre de usuario y "
                    + "nombre que hace referencia al tipo de PDF.");

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
    
    
    
        
     /*------------------------------------------------------------------------
                                 PDF EXPORTADORES
      -------------------------------------------------------------------------
     */
    
     public void pdfExportadores(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaExportadores" + dia + mes + año +".pdf"));
 
            documento.open();

            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_CENTER); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Tahoma", 50, 4, BaseColor.BLUE));
      
            
            // PARRAFO 1 EXPORTADORES
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Exportadores:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            // crear la tabla del PDF.
            PdfPTable tablaExportadores = new PdfPTable(5);
            tablaExportadores.addCell("ID");
            tablaExportadores.addCell("Nombre");
            tablaExportadores.addCell("Empresa");
            tablaExportadores.addCell("Pais");
            tablaExportadores.addCell("Status");

            tablaExportadores.setSpacingAfter(40);
            
            PdfPTable tablaExportadores1 = new PdfPTable(3);
            tablaExportadores1.addCell("ID");
            tablaExportadores1.addCell("Mail");
            tablaExportadores1.addCell("Número");
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_exportador, empleado, "
                        + "empresa, pais, status from exportadores order by id_exportador asc");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaExportadores.addCell(rs.getString(1));
                        tablaExportadores.addCell(rs.getString(2));
                        tablaExportadores.addCell(rs.getString(3));
                        tablaExportadores.addCell(rs.getString(4));
                        tablaExportadores.addCell(rs.getString(5));
                    }while(rs.next());
                    documento.add(tablaExportadores);  
                }
                                

            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de exportadores " + e);
            }
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_exportador, "
                        + "mail, numero_contacto from exportadores order by id_exportador asc"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaExportadores1.addCell(rs.getString(1));
                        tablaExportadores1.addCell(rs.getString(2));
                        tablaExportadores1.addCell(rs.getString(3));

                    } while (rs.next());
                    documento.add(tablaExportadores1);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla1 de exportadores " + e);
            }
            documento.close();
            
            
            
            JOptionPane.showMessageDialog(null, "Reporte de lista de exportadores creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de exportadores", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
     
     /*------------------------------------------------------------------------
                                 PDF IMPORTADORES
      -------------------------------------------------------------------------
     */
     
     public void pdfImportadores(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaImportadores" + dia + mes + año +".pdf"));
 
            documento.open();

            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.TITLE); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Perpetua", 50, BaseColor.BLUE));

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("\n\n");
            parrafo2.add("Importadores: \n \n");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
           
             // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            
            // crear la tabla del PDF.
            PdfPTable tablaImportadores = new PdfPTable(5);
            tablaImportadores.addCell("ID");
            tablaImportadores.addCell("Nombre");
            tablaImportadores.addCell("Empresa");
            tablaImportadores.addCell("Pais");
            tablaImportadores.addCell("Status");

            tablaImportadores.setSpacingAfter(40);
            
            PdfPTable tablaImportadores1 = new PdfPTable(3);
            tablaImportadores1.addCell("ID");
            tablaImportadores1.addCell("Mail");
            tablaImportadores1.addCell("Número");
            
            documento.add(parrafo2);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_importador, empleado, empresa, "
                        + "pais, status from importadores order by id_importador asc");
                rs = pst.executeQuery();

                // completar información de la tabla
                if(rs.next()){
                    do{
                        
                        tablaImportadores.addCell(rs.getString(1));
                        tablaImportadores.addCell(rs.getString(2));
                        tablaImportadores.addCell(rs.getString(3));
                        tablaImportadores.addCell(rs.getString(4));
                        tablaImportadores.addCell(rs.getString(5));
                         
                    }while(rs.next());
                    documento.add(tablaImportadores);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de importadores " + e);
            }
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_importador, "
                        + "mail, numero_contacto from importadores order by id_importador asc");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaImportadores1.addCell(rs.getString(1));
                        tablaImportadores1.addCell(rs.getString(2));
                        tablaImportadores1.addCell(rs.getString(3));
                         
                    }while(rs.next());  
                    documento.add(tablaImportadores1);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla1 de importadores " + e);
            }
            
            documento.close();
            
            
            
            JOptionPane.showMessageDialog(null, "Reporte de lista de importadores creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de importadores", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
     
     
     /*------------------------------------------------------------------------
                                 PDF DESPACHANTES
      -------------------------------------------------------------------------
     */
     
     public void pdfDespachantes(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaDespachantes" + dia + mes + año +".pdf"));
 
            documento.open();

            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.TITLE); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Perpetua", 50, BaseColor.BLUE));

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo3.add("\n\n");
            parrafo3.add("Despachantes: \n \n");
            parrafo3.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaDespachantes = new PdfPTable(5);
            tablaDespachantes.addCell("ID");
            tablaDespachantes.addCell("Nombre");
            tablaDespachantes.addCell("Empresa");
            tablaDespachantes.addCell("Pais");
            tablaDespachantes.addCell("Status");

            tablaDespachantes.setSpacingAfter(40);
            
            PdfPTable tablaDespachantes1 = new PdfPTable(3);
            tablaDespachantes1.addCell("ID");
            tablaDespachantes1.addCell("Mail");
            tablaDespachantes1.addCell("Número");
            
            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo3);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_despachantes, empleado, empresa, "
                        + "pais, status from despachantes order by id_despachantes asc");
                
                rs = pst.executeQuery();
             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaDespachantes.addCell(rs.getString(1));
                        tablaDespachantes.addCell(rs.getString(2));
                        tablaDespachantes.addCell(rs.getString(3));
                        tablaDespachantes.addCell(rs.getString(4));
                        tablaDespachantes.addCell(rs.getString(5));        

                         
                    }while(rs.next());
                    documento.add(tablaDespachantes);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de despachantes " + e);
            }
            
             try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_despachantes, "
                        + "mail, numero_contacto from despachantes order by id_despachantes asc");
                rs = pst.executeQuery();
              
                // completar información de la tabla
                if(rs.next()){
                    do{                        
                        tablaDespachantes1.addCell(rs.getString(1));
                        tablaDespachantes1.addCell(rs.getString(2));
                        tablaDespachantes1.addCell(rs.getString(3));         
                    }while(rs.next());
                    documento.add(tablaDespachantes1);  

                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla1 de despachantes " + e);
            }
            documento.close();
 
            JOptionPane.showMessageDialog(null, "Reporte de lista de despachantes creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de despachantes", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
    }
     
      /*------------------------------------------------------------------------
                                 PDF MARITIMAS Y AEROLINEAS
      -------------------------------------------------------------------------
     */
     
     public void pdfMaritimasAereo(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaMaritimasAereo" + dia + mes + año +".pdf"));
 
            documento.open();

            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.TITLE); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Perpetua", 50, BaseColor.BLUE));

            // PARRAFO 4 MARITIMO
            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo4.add("\n\n");
            parrafo4.add("Marítimas: \n \n");
            parrafo4.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaMaritima = new PdfPTable(5);
            tablaMaritima.addCell("ID");
            tablaMaritima.addCell("Nombre");
            tablaMaritima.addCell("Empresa");
            tablaMaritima.addCell("Mail");
            tablaMaritima.addCell("Número");
            
             // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo4);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_maritima, empleado,"
                        + " empresa, mail, numero_contacto from maritimas order "
                        + "by id_maritima asc");
               rs = pst.executeQuery();

             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaMaritima.addCell(rs.getString(1));
                        tablaMaritima.addCell(rs.getString(2));
                        tablaMaritima.addCell(rs.getString(3));
                        tablaMaritima.addCell(rs.getString(4));
                        tablaMaritima.addCell(rs.getString(5));       
                    }while(rs.next());
                    documento.add(tablaMaritima);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener las tablas de marítimas " + e);
            }
  
               
              // PARRAFO 5 AEREO
            Paragraph parrafo5 = new Paragraph();
            parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo5.add("\n\n");
            parrafo5.add("Compañias aereas: \n \n");
            parrafo5.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaAereo = new PdfPTable(5);
            tablaAereo.addCell("ID");
            tablaAereo.addCell("Nombre");
            tablaAereo.addCell("Aerolinea");
            tablaAereo.addCell("Mail");
            tablaAereo.addCell("Número");
            
            documento.add(parrafo5);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_aereo, empleado, aerolinea, mail, "
            + "numero_contacto from aereo order by id_aereo asc");
               rs = pst.executeQuery();

             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaAereo.addCell(rs.getString(1));
                        tablaAereo.addCell(rs.getString(2));
                        tablaAereo.addCell(rs.getString(3));
                        tablaAereo.addCell(rs.getString(4));
                        tablaAereo.addCell(rs.getString(5));       
                    }while(rs.next());
                    documento.add(tablaAereo);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener las tablas de aerolíneas " + e);
            }
            documento.close();
 
            JOptionPane.showMessageDialog(null, "Reporte de lista de marítimas y aereo creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de marítimas y aerolíneas", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
     
     
      /*------------------------------------------------------------------------
                                 PDF AGENDA PERSONAL
      -------------------------------------------------------------------------
     */
     
     public void pdfAgendaPersonal(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaAgendaPersonal" + dia + mes + año +".pdf"));
 
            documento.open();

            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.TITLE); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Perpetua", 50, BaseColor.BLUE));

           
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n\n");
            parrafo.add("Contactos de agenda personal: \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaAgenda = new PdfPTable(6);
            tablaAgenda.addCell("ID");
            tablaAgenda.addCell("Nombre");
            tablaAgenda.addCell("Empresa");
            tablaAgenda.addCell("Cargo");
            tablaAgenda.addCell("Mail");
            tablaAgenda.addCell("Número");
            
             // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_agenda, nombre, empresa, "
                        + "cargo, mail, numero_contacto from agenda_personal where "
                        + "usuario_registrador = '" + usuario + "' order by id_agenda asc");
               rs = pst.executeQuery();

             
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaAgenda.addCell(rs.getString(1));
                        tablaAgenda.addCell(rs.getString(2));
                        tablaAgenda.addCell(rs.getString(3));
                        tablaAgenda.addCell(rs.getString(4));
                        tablaAgenda.addCell(rs.getString(5));       
                        tablaAgenda.addCell(rs.getString(6)); 
                    }while(rs.next());
                    documento.add(tablaAgenda);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de agenda " + e);
            }
            documento.close();
 
            JOptionPane.showMessageDialog(null, "Reporte de lista de agenda personal creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de agenda", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
      
     
}
