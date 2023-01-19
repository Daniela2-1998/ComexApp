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
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.Conexion;
import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Daniela
 */

public class PDFProduccionImpl implements PDFProduccionService {
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
   
    ImageIcon logo = new ImageIcon("imagenes/logo12.png");
    Icon iconoLogo = new ImageIcon(logo.getImage());

    
    
        
     /*------------------------------------------------------------------------
                                 PDF TODO DE PRODUCCIÓN
      -------------------------------------------------------------------------
     */
    
    // método de creación PDF 
    public void pdfTodoDeProduccion(String usuario, String nombreCompleto, 
            String dia, String mes, String año){
        Document documento = new Document();

        try {
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaDeProduccionCompleta" + dia + mes + año +".pdf"));
 
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
            parrafo.add("Stock:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            // crear la tabla del PDF.
            PdfPTable tablaStock = new PdfPTable(5);
            tablaStock.addCell("ID");
            tablaStock.addCell("Producto");
            tablaStock.addCell("Tipo de producto");
            tablaStock.addCell("Detalles");
            tablaStock.addCell("Cuidados requeridos");

            tablaStock.setSpacingAfter(20);
            
            PdfPTable tablaProductos = new PdfPTable(6);
            tablaProductos.addCell("ID");
            tablaProductos.addCell("Código producto");
            tablaProductos.addCell("País de orígen");
            tablaProductos.addCell("Precio unitario");
            tablaProductos.addCell("Cantidad");
            tablaProductos.addCell("Status");
            
            tablaProductos.setSpacingAfter(20);
            
            PdfPTable tablaCompraVenta = new PdfPTable(5);
            tablaCompraVenta.addCell("ID");
            tablaCompraVenta.addCell("Comprador");
            tablaCompraVenta.addCell("Vendedor");
            tablaCompraVenta.addCell("Reserva");
            tablaCompraVenta.addCell("Status");
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_producto, nombre_producto, "
                        + "tipo_producto, detalle, cuidados_requeridos from stock");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaStock.addCell(rs.getString(1));
                        tablaStock.addCell(rs.getString(2));
                        tablaStock.addCell(rs.getString(3));
                        tablaStock.addCell(rs.getString(4));
                        tablaStock.addCell(rs.getString(5));
                    }while(rs.next());
                    documento.add(tablaStock);  
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de stock " + e);
            }
           
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_producto, codigo_producto, "
                        + "pais_origen, precio_unitario, cantidad, status from stock"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaProductos.addCell(rs.getString(1));
                        tablaProductos.addCell(rs.getString(2));
                        tablaProductos.addCell(rs.getString(3));
                        tablaProductos.addCell(rs.getString(4));
                        tablaProductos.addCell(rs.getString(5));
                        tablaProductos.addCell(rs.getString(6));

                    } while (rs.next());
                    documento.add(tablaProductos);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de productos " + e);
            }
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_producto, comprador, "
                        + "vendedor, reserva, status from stock"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaCompraVenta.addCell(rs.getString(1));
                        tablaCompraVenta.addCell(rs.getString(2));
                        tablaCompraVenta.addCell(rs.getString(3));
                        tablaCompraVenta.addCell(rs.getString(4));
                        tablaCompraVenta.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tablaCompraVenta);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de compra-venta " + e);
            }
            
            // PARRAFO 2 
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("\n\n");
            parrafo2.add("Suministros y reabastecimiento: \n \n");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
            
            // crear la tabla del PDF.
            PdfPTable tablaReabastecimiento = new PdfPTable(5);
            tablaReabastecimiento.addCell("ID");
            tablaReabastecimiento.addCell("Producto");
            tablaReabastecimiento.addCell("Cantidad");
            tablaReabastecimiento.addCell("Detalle del producto");
            tablaReabastecimiento.addCell("Cuidados requeridos");

            tablaReabastecimiento.setSpacingAfter(20);
            
            PdfPTable tablaSuministros = new PdfPTable(4);
            tablaSuministros.addCell("ID");
            tablaSuministros.addCell("Destino/uso");
            tablaSuministros.addCell("Tipo de producto");
            tablaSuministros.addCell("País orígen");

            tablaSuministros.setSpacingAfter(20);
            
            PdfPTable tablaPrecioFechas = new PdfPTable(6);
            tablaPrecioFechas.addCell("ID");
            tablaPrecioFechas.addCell("Precio unitario");
            tablaPrecioFechas.addCell("Precio total");
            tablaPrecioFechas.addCell("Descuento");
            tablaPrecioFechas.addCell("Fecha de pedido");
            tablaPrecioFechas.addCell("Fecha de llegada");
            
            
            documento.add(parrafo2);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_pedido, producto, cantidad, "
                        + "detalle, cuidados_requeridos from reabastecimiento");
                rs = pst.executeQuery();

                // completar información de la tabla
                if(rs.next()){
                    do{
                        
                        tablaReabastecimiento.addCell(rs.getString(1));
                        tablaReabastecimiento.addCell(rs.getString(2));
                        tablaReabastecimiento.addCell(rs.getString(3));
                        tablaReabastecimiento.addCell(rs.getString(4));
                        tablaReabastecimiento.addCell(rs.getString(5));
                         
                    }while(rs.next());
                    documento.add(tablaReabastecimiento);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de reabastecimiento " + e);
            }
            
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_pedido, destino, "
                        + "tipo_producto, pais_origen from reabastecimiento");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaSuministros.addCell(rs.getString(1));
                        tablaSuministros.addCell(rs.getString(2));
                        tablaSuministros.addCell(rs.getString(3));
                        tablaSuministros.addCell(rs.getString(4));
                        
                    }while(rs.next());  
                    documento.add(tablaSuministros);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla de suministros " + e);
            }
            
            tablaSuministros.setSpacingAfter(35);
            
             try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_pedido, precio_unitario, "
                        + "precio_total, descuento, fecha_operacion, fecha_llegada "
                        + "from reabastecimiento");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaPrecioFechas.addCell(rs.getString(1));
                        tablaPrecioFechas.addCell(rs.getString(2));
                        tablaPrecioFechas.addCell(rs.getString(3));
                        tablaPrecioFechas.addCell(rs.getString(4));
                        tablaPrecioFechas.addCell(rs.getString(5));
                        tablaPrecioFechas.addCell(rs.getString(6));
                         
                    }while(rs.next());  
                    documento.add(tablaPrecioFechas);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla de precios y fechas " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de lista completa de "
                    + "producción. \n\n " + nombreCompleto + ", encontrarás "
                    + "el PDF en la carpeta de descargas con tu nombre de usuario y "
                    + "nombre que hace referencia al tipo de PDF.", "Lista de producción", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
    
    
    
        
     /*------------------------------------------------------------------------
                                 PDF STOCK
      -------------------------------------------------------------------------
     */
    
     public void pdfStock(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaStock" + dia + mes + año +".pdf"));
 
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
            parrafo.add("Stock:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
             // crear la tabla del PDF.
            PdfPTable tablaStock = new PdfPTable(5);
            tablaStock.addCell("ID");
            tablaStock.addCell("Producto");
            tablaStock.addCell("Tipo de producto");
            tablaStock.addCell("Detalles");
            tablaStock.addCell("Cuidados requeridos");

            tablaStock.setSpacingAfter(20);
            
            PdfPTable tablaProductos = new PdfPTable(6);
            tablaProductos.addCell("ID");
            tablaProductos.addCell("Código producto");
            tablaProductos.addCell("País de orígen");
            tablaProductos.addCell("Precio unitario");
            tablaProductos.addCell("Cantidad");
            tablaProductos.addCell("Status");
            
            tablaProductos.setSpacingAfter(20);
            
            PdfPTable tablaCompraVenta = new PdfPTable(5);
            tablaCompraVenta.addCell("ID");
            tablaCompraVenta.addCell("Comprador");
            tablaCompraVenta.addCell("Vendedor");
            tablaCompraVenta.addCell("Reserva");
            tablaCompraVenta.addCell("Status");
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_producto, nombre_producto, "
                        + "tipo_producto, detalle, cuidados_requeridos from stock");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaStock.addCell(rs.getString(1));
                        tablaStock.addCell(rs.getString(2));
                        tablaStock.addCell(rs.getString(3));
                        tablaStock.addCell(rs.getString(4));
                        tablaStock.addCell(rs.getString(5));
                    }while(rs.next());
                    documento.add(tablaStock);  
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de stock " + e);
            }
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_producto, codigo_producto, "
                        + "pais_origen, precio_unitario, cantidad, status from stock"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaProductos.addCell(rs.getString(1));
                        tablaProductos.addCell(rs.getString(2));
                        tablaProductos.addCell(rs.getString(3));
                        tablaProductos.addCell(rs.getString(4));
                        tablaProductos.addCell(rs.getString(5));
                        tablaProductos.addCell(rs.getString(6));

                    } while (rs.next());
                    documento.add(tablaProductos);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de productos " + e);
            }
            
            try{
                
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_producto, comprador, "
                        + "vendedor, reserva, status from stock"); 
                rs = pst.executeQuery(); 
        
                if(rs.next()){
                    do {
                        tablaCompraVenta.addCell(rs.getString(1));
                        tablaCompraVenta.addCell(rs.getString(2));
                        tablaCompraVenta.addCell(rs.getString(3));
                        tablaCompraVenta.addCell(rs.getString(4));
                        tablaCompraVenta.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tablaCompraVenta);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de compra-venta " + e);
            }
            
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte de lista de stock creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de stock", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
     
     /*------------------------------------------------------------------------
                                 PDF SUMINISTROS
      -------------------------------------------------------------------------
     */
     
     public void pdfSuministros(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        Document documento = new Document();

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaSuministros" + dia + mes + año +".pdf"));
 
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
            parrafo2.add("Suministros y reabastecimiento: \n \n");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
           
            // crear la tabla del PDF.
            PdfPTable tablaReabastecimiento = new PdfPTable(5);
            tablaReabastecimiento.addCell("ID");
            tablaReabastecimiento.addCell("Producto");
            tablaReabastecimiento.addCell("Cantidad");
            tablaReabastecimiento.addCell("Detalle del producto");
            tablaReabastecimiento.addCell("Cuidados requeridos");

            tablaReabastecimiento.setSpacingAfter(20);
            
            PdfPTable tablaSuministros = new PdfPTable(4);
            tablaSuministros.addCell("ID");
            tablaSuministros.addCell("Destino/uso");
            tablaSuministros.addCell("Tipo de producto");
            tablaSuministros.addCell("País orígen");

            tablaSuministros.setSpacingAfter(20);
            
            PdfPTable tablaPrecioFechas = new PdfPTable(6);
            tablaPrecioFechas.addCell("ID");
            tablaPrecioFechas.addCell("Precio unitario");
            tablaPrecioFechas.addCell("Precio total");
            tablaPrecioFechas.addCell("Descuento");
            tablaPrecioFechas.addCell("Fecha de pedido");
            tablaPrecioFechas.addCell("Fecha de llegada");
            
             // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo2);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_pedido, producto, cantidad, "
                        + "detalle, cuidados_requeridos from reabastecimiento");
                rs = pst.executeQuery();

                // completar información de la tabla
                if(rs.next()){
                    do{
                        
                        tablaReabastecimiento.addCell(rs.getString(1));
                        tablaReabastecimiento.addCell(rs.getString(2));
                        tablaReabastecimiento.addCell(rs.getString(3));
                        tablaReabastecimiento.addCell(rs.getString(4));
                        tablaReabastecimiento.addCell(rs.getString(5));
                         
                    }while(rs.next());
                    documento.add(tablaReabastecimiento);  
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener la tabla de reabastecimiento " + e);
            }
            
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_pedido, destino, "
                        + "tipo_producto, pais_origen from reabastecimiento");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaSuministros.addCell(rs.getString(1));
                        tablaSuministros.addCell(rs.getString(2));
                        tablaSuministros.addCell(rs.getString(3));
                        tablaSuministros.addCell(rs.getString(4));
                        
                    }while(rs.next());  
                    documento.add(tablaSuministros);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla de suministros " + e);
            }
            
            tablaSuministros.setSpacingAfter(35);
            
             try{
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_pedido, precio_unitario, "
                        + "precio_total, descuento, fecha_operacion, fecha_llegada "
                        + "from reabastecimiento");

                rs = pst.executeQuery();
                
                 if(rs.next()){
                    do{
                        tablaPrecioFechas.addCell(rs.getString(1));
                        tablaPrecioFechas.addCell(rs.getString(2));
                        tablaPrecioFechas.addCell(rs.getString(3));
                        tablaPrecioFechas.addCell(rs.getString(4));
                        tablaPrecioFechas.addCell(rs.getString(5));
                        tablaPrecioFechas.addCell(rs.getString(6));
                         
                    }while(rs.next());  
                    documento.add(tablaPrecioFechas);
                    }

            }catch(SQLException e){
                 System.err.println("Error al obtener la tabla de precios y fechas " + e);
            }
             
            documento.close();
            
            
            
            JOptionPane.showMessageDialog(null, "Reporte de lista de suministros "
                    + "y reabastecimiento creado. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de suministros", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }   
    }
   
     
}
