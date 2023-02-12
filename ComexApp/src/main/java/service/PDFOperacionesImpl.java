package service;

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

public class PDFOperacionesImpl implements PDFOperacionesService {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
   
    ImageIcon logo = new ImageIcon("imagenes/logo12.png");
    Icon iconoLogo = new ImageIcon(logo.getImage());

    
    
        
     /*------------------------------------------------------------------------
                                 PDF TODAS LAS OPERACIONES
      -------------------------------------------------------------------------
     */
    
    // método de creación PDF 
    public void pdfTodasLasOperaciones(String usuario, String nombreCompleto, 
            String dia, String mes, String año){
        Document documento = new Document();

        try {
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaDeOperaciones" + dia + mes + año +".pdf"));
 
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

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Operaciones internacionales:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            // crear la tabla del PDF.
            PdfPTable tablaOpIntBasica = new PdfPTable(6);
            tablaOpIntBasica.addCell("ID");
            tablaOpIntBasica.addCell("Producto");
            tablaOpIntBasica.addCell("Tipo de operación");
            tablaOpIntBasica.addCell("Comprador");
            tablaOpIntBasica.addCell("Vendedor");
            tablaOpIntBasica.addCell("Precio total");

            tablaOpIntBasica.setSpacingAfter(40);
            
            PdfPTable tablaDescripcionProducto = new PdfPTable(5);
            tablaDescripcionProducto.addCell("ID");
            tablaDescripcionProducto.addCell("Cantidad");
            tablaDescripcionProducto.addCell("Detalles producto");
            tablaDescripcionProducto.addCell("País orígen");
            tablaDescripcionProducto.addCell("Status");
            
            tablaDescripcionProducto.setSpacingAfter(40);
            
            PdfPTable tablaEmbarque = new PdfPTable(7);
            tablaEmbarque.addCell("Fecha arribo");
            tablaEmbarque.addCell("Fecha registro");
            tablaEmbarque.addCell("Código contenedores");
            tablaEmbarque.addCell("Cantidad contenedores");
            tablaEmbarque.addCell("N° de embarque");
            tablaEmbarque.addCell("Nombre buque");
            tablaEmbarque.addCell("ID");
            
           
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_operaciones, producto, "
                        + "tipo_operacion, comprador, vendedor, precio_total "
                        + "from operaciones order by fecha_arribo asc");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaOpIntBasica.addCell(rs.getString(1));
                        tablaOpIntBasica.addCell(rs.getString(2));
                        tablaOpIntBasica.addCell(rs.getString(3));
                        tablaOpIntBasica.addCell(rs.getString(4));
                        tablaOpIntBasica.addCell(rs.getString(5));
                        tablaOpIntBasica.addCell(rs.getString(6));
                    }while(rs.next());
                    documento.add(tablaOpIntBasica );  
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla básica de operaciones " + e);
            }

            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_operaciones, cantidad_producto, "
                        + "detalles, pais_origen, status from operaciones "
                        + "order by fecha_arribo asc"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaDescripcionProducto.addCell(rs.getString(1));
                        tablaDescripcionProducto.addCell(rs.getString(2));
                        tablaDescripcionProducto.addCell(rs.getString(3));
                        tablaDescripcionProducto.addCell(rs.getString(4));
                        tablaDescripcionProducto.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tablaDescripcionProducto);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de descripción de producto " + e);
            }
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select fecha_arribo, fecha_registro, "
                        + "codigo_contenedores, cantidad_contenedores, numero_embarque, "
                        + "nombre_buque, id_operaciones from operaciones order "
                        + "by fecha_arribo asc"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaEmbarque.addCell(rs.getString(1));
                        tablaEmbarque.addCell(rs.getString(2));
                        tablaEmbarque.addCell(rs.getString(3));
                        tablaEmbarque.addCell(rs.getString(4));
                        tablaEmbarque.addCell(rs.getString(5));
                        tablaEmbarque.addCell(rs.getString(6));
                        tablaEmbarque.addCell(rs.getString(7));

                    } while (rs.next());
                    documento.add(tablaEmbarque);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de detalles de embarque " + e);
            }
                                     
            // PARRAFO 2 
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("\n\n");
            parrafo2.add("Operaciones nacionales: \n \n");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaOpNac = new PdfPTable(6);
            tablaOpNac.addCell("ID");
            tablaOpNac.addCell("Producto");
            tablaOpNac.addCell("Cantidad");
            tablaOpNac.addCell("Comprador");
            tablaOpNac.addCell("Vendedor");
            tablaOpNac.addCell("Precio total");

            tablaOpNac.setSpacingAfter(40);
            
            PdfPTable tablaDetallesOpNac = new PdfPTable(6);
            tablaDetallesOpNac.addCell("ID");
            tablaDetallesOpNac.addCell("Tipo de operación");
            tablaDetallesOpNac.addCell("Fecha de operación");
            tablaDetallesOpNac.addCell("Fecha de llegada");
            tablaDetallesOpNac.addCell("Número de contacto");
            tablaDetallesOpNac.addCell("Status");

            tablaDetallesOpNac.setSpacingAfter(40);
            
            documento.add(parrafo2);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_ventalocal, productos_pedidos, "
                        + "cantidad_producto, comprador, vendedor, precio_total "
                        + "from ventalocal order by fecha_arribo asc");
                rs = pst.executeQuery();

                // completar información de la tabla
                if(rs.next()){
                    do{
                        
                        tablaOpNac.addCell(rs.getString(1));
                        tablaOpNac.addCell(rs.getString(2));
                        tablaOpNac.addCell(rs.getString(3));
                        tablaOpNac.addCell(rs.getString(4));
                        tablaOpNac.addCell(rs.getString(5));
                        tablaOpNac.addCell(rs.getString(6));
                        
                    }while(rs.next());
                    documento.add(tablaOpNac);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de operaciones locales " + e);
            }

        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_ventalocal, tipo_operacion, "
                        + "fecha_registro, fecha_arribo, numero_contacto, status "
                        + "from ventalocal order by fecha_arribo asc");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaDetallesOpNac.addCell(rs.getString(1));
                        tablaDetallesOpNac.addCell(rs.getString(2));
                        tablaDetallesOpNac.addCell(rs.getString(3));
                        tablaDetallesOpNac.addCell(rs.getString(4));
                        tablaDetallesOpNac.addCell(rs.getString(5));
                        tablaDetallesOpNac.addCell(rs.getString(6));
                        
                    }while(rs.next());  
                    documento.add(tablaDetallesOpNac);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla extra de operaciones "
                         + "nacionales" + e);
            }
            
            tablaDetallesOpNac.setSpacingAfter(35);

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de lista completa de "
                    + "operaciones. \n\n " + nombreCompleto + ", encontrarás "
                    + "el PDF en la carpeta de descargas con tu nombre de usuario y "
                    + "nombre que hace referencia al tipo de PDF.", "Lista de operaciones", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
    
    
    
        
     /*------------------------------------------------------------------------
                                 PDF OPERACIONES INTERNACIONALES
      -------------------------------------------------------------------------
     */
    
    public void pdfOperacionesInternacionales(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaOperacionesInternacionales" + dia + mes + año +".pdf"));
 
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
      
     
           Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Operaciones internacionales:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            // crear la tabla del PDF.
            PdfPTable tablaOpIntBasica = new PdfPTable(6);
            tablaOpIntBasica.addCell("ID");
            tablaOpIntBasica.addCell("Producto");
            tablaOpIntBasica.addCell("Tipo de operación");
            tablaOpIntBasica.addCell("Comprador");
            tablaOpIntBasica.addCell("Vendedor");
            tablaOpIntBasica.addCell("Precio total");

            tablaOpIntBasica.setSpacingAfter(40);
            
            PdfPTable tablaDescripcionProducto = new PdfPTable(5);
            tablaDescripcionProducto.addCell("ID");
            tablaDescripcionProducto.addCell("Cantidad");
            tablaDescripcionProducto.addCell("Detalles producto");
            tablaDescripcionProducto.addCell("País orígen");
            tablaDescripcionProducto.addCell("Status");
            
            tablaDescripcionProducto.setSpacingAfter(40);
            
            PdfPTable tablaEmbarque = new PdfPTable(7);
            tablaEmbarque.addCell("Fecha arribo");
            tablaEmbarque.addCell("Fecha registro");
            tablaEmbarque.addCell("Código contenedores");
            tablaEmbarque.addCell("Cantidad contenedores");
            tablaEmbarque.addCell("N° de embarque");
            tablaEmbarque.addCell("Nombre buque");
            tablaEmbarque.addCell("ID");
            
           
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_operaciones, producto, "
                        + "tipo_operacion, comprador, vendedor, precio_total "
                        + "from operaciones order by fecha_arribo asc");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaOpIntBasica.addCell(rs.getString(1));
                        tablaOpIntBasica.addCell(rs.getString(2));
                        tablaOpIntBasica.addCell(rs.getString(3));
                        tablaOpIntBasica.addCell(rs.getString(4));
                        tablaOpIntBasica.addCell(rs.getString(5));
                        tablaOpIntBasica.addCell(rs.getString(6));
                    }while(rs.next());
                    documento.add(tablaOpIntBasica );  
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla básica de operaciones " + e);
            }

            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_operaciones, cantidad_producto, "
                        + "detalles, pais_origen, status from operaciones "
                        + "order by fecha_arribo asc"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaDescripcionProducto.addCell(rs.getString(1));
                        tablaDescripcionProducto.addCell(rs.getString(2));
                        tablaDescripcionProducto.addCell(rs.getString(3));
                        tablaDescripcionProducto.addCell(rs.getString(4));
                        tablaDescripcionProducto.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tablaDescripcionProducto);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de descripción de producto " + e);
            }
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select fecha_arribo, fecha_registro, "
                        + "codigo_contenedores, cantidad_contenedores, numero_embarque, "
                        + "nombre_buque, id_operaciones from operaciones order "
                        + "by fecha_arribo asc"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaEmbarque.addCell(rs.getString(1));
                        tablaEmbarque.addCell(rs.getString(2));
                        tablaEmbarque.addCell(rs.getString(3));
                        tablaEmbarque.addCell(rs.getString(4));
                        tablaEmbarque.addCell(rs.getString(5));
                        tablaEmbarque.addCell(rs.getString(6));
                        tablaEmbarque.addCell(rs.getString(7));

                    } while (rs.next());
                    documento.add(tablaEmbarque);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de detalles de embarque " + e);
            }
                                     
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte de lista de operaciones internacionales. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de operaciones internacionales", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
     
     /*------------------------------------------------------------------------
                                 PDF OPERACIONES NACIONALES
      -------------------------------------------------------------------------
     */
     
    public void pdfOperacionesNacionales(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaOperacionesNacionales" + dia + mes + año +".pdf"));
 
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
            parrafo2.add("Operaciones nacionales: \n \n");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaOpNac = new PdfPTable(6);
            tablaOpNac.addCell("ID");
            tablaOpNac.addCell("Producto");
            tablaOpNac.addCell("Cantidad");
            tablaOpNac.addCell("Comprador");
            tablaOpNac.addCell("Vendedor");
            tablaOpNac.addCell("Precio total");

            tablaOpNac.setSpacingAfter(40);
            
            PdfPTable tablaDetallesOpNac = new PdfPTable(6);
            tablaDetallesOpNac.addCell("ID");
            tablaDetallesOpNac.addCell("Tipo de operación");
            tablaDetallesOpNac.addCell("Fecha de operación");
            tablaDetallesOpNac.addCell("Fecha de llegada");
            tablaDetallesOpNac.addCell("Número de contacto");
            tablaDetallesOpNac.addCell("Status");

            tablaDetallesOpNac.setSpacingAfter(40);
            
            documento.add(parrafo2);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_ventalocal, productos_pedidos, "
                        + "cantidad_producto, comprador, vendedor, precio_total "
                        + "from ventalocal order by fecha_arribo asc");
                rs = pst.executeQuery();

                // completar información de la tabla
                if(rs.next()){
                    do{
                        
                        tablaOpNac.addCell(rs.getString(1));
                        tablaOpNac.addCell(rs.getString(2));
                        tablaOpNac.addCell(rs.getString(3));
                        tablaOpNac.addCell(rs.getString(4));
                        tablaOpNac.addCell(rs.getString(5));
                        tablaOpNac.addCell(rs.getString(6));
                        
                    }while(rs.next());
                    documento.add(tablaOpNac);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de operaciones locales " + e);
            }

        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_ventalocal, tipo_operacion, "
                        + "fecha_registro, fecha_arribo, numero_contacto, status "
                        + "from ventalocal order by fecha_arribo asc");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaDetallesOpNac.addCell(rs.getString(1));
                        tablaDetallesOpNac.addCell(rs.getString(2));
                        tablaDetallesOpNac.addCell(rs.getString(3));
                        tablaDetallesOpNac.addCell(rs.getString(4));
                        tablaDetallesOpNac.addCell(rs.getString(5));
                        tablaDetallesOpNac.addCell(rs.getString(6));
                        
                    }while(rs.next());  
                    documento.add(tablaDetallesOpNac);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla extra de operaciones "
                         + "nacionales" + e);
            }
            tablaDetallesOpNac.setSpacingAfter(35);

            
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte de lista de operaciones nacionales. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de operaciones nacionales", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }   
    }
   
     
}
