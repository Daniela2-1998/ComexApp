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
import com.itextpdf.text.PageSize;
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

public class PDFContenedoresImpl implements PDFContenedoresService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
   
    ImageIcon logo = new ImageIcon("imagenes/logo12.png");
    Icon iconoLogo = new ImageIcon(logo.getImage());

   
    
        
     /*------------------------------------------------------------------------
                                 PDF TODOS CONTENEDORES
      -------------------------------------------------------------------------
     */
  
 
    public void pdfContenedores(String usuario, String nombreCompleto, 
             String dia, String mes, String año){
        
        Document documento = new Document(PageSize.A4);

        try{
            //ruta donde se guardará PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/" +
                    usuario + "ListaContenedores" + dia + mes + año +".pdf"));
 
            documento.open();
            
            // contenido del PDF. /  imagén de arriba
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("D:comexappim/logo12.png");
            header.scaleToFit(100, 100);
            header.setAlignment(Chunk.ALIGN_CENTER);

            // titulo
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_CENTER); 
            titulo.add("ComexApp. \n \n");
            titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLUE));
            
     
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Contenedores:  \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLUE));

            // agregar contenido al PDF.
            documento.open(); 
            documento.add(header);
            documento.add(titulo);
            documento.add(parrafo);
            
            // crear la tabla del PDF.
            PdfPTable tablaContenedores = new PdfPTable(7);
            tablaContenedores.addCell("ID");
            tablaContenedores.addCell("Código");
            tablaContenedores.addCell("Productos");
            tablaContenedores.addCell("Cantidad");
            tablaContenedores.addCell("Capacidad");
            tablaContenedores.addCell("Tipo");
            tablaContenedores.addCell("Status");
            
            tablaContenedores.setSpacingAfter(40);
             
            PdfPTable tablaContenedores1 = new PdfPTable(6);
            tablaContenedores1.addCell("ID");
            tablaContenedores1.addCell("Empresa");
            tablaContenedores1.addCell("Compañia de transporte");
            tablaContenedores1.addCell("Reserva");
            tablaContenedores1.addCell("Fecha último control");
            tablaContenedores1.addCell("Fecha próximo control");

            tablaContenedores1.setSpacingAfter(40);
            
            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_contenedor, codigo, "
                        + "productos, cantidad, capacidad, tipo, status "
                        + "from contenedores order by id_contenedor asc");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaContenedores.addCell(rs.getString(1));
                        tablaContenedores.addCell(rs.getString(2));
                        tablaContenedores.addCell(rs.getString(3));
                        tablaContenedores.addCell(rs.getString(4));
                        tablaContenedores.addCell(rs.getString(5));
                        tablaContenedores.addCell(rs.getString(6));
                        tablaContenedores.addCell(rs.getString(7));
                        
                    }while(rs.next());
                    documento.add(tablaContenedores);  
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de contenedores " + e);
            }

            try {
                conec = cn.Conexion();
                pst = conec.prepareStatement("select id_contenedor, empresa, "
                        + "compañia_transporte, reserva, ultimo_control, proximo_control "
                        + "from contenedores order by id_contenedor asc");
                rs = pst.executeQuery();
                
                            
                // completar información de la tabla
                if(rs.next()){
                    do{
                        tablaContenedores1.addCell(rs.getString(1));
                        tablaContenedores1.addCell(rs.getString(2));
                        tablaContenedores1.addCell(rs.getString(3));
                        tablaContenedores1.addCell(rs.getString(4));
                        tablaContenedores1.addCell(rs.getString(5));
                        tablaContenedores1.addCell(rs.getString(6));

                    }while(rs.next());
                    documento.add(tablaContenedores1);  
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener tabla de contenedores1 " + e);
            }
           
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte de lista de contenedores. \n\n " 
                    + nombreCompleto + ", encontrarás el PDF en la carpeta de "
                    + "descargas con tu nombre de usuario y nombre que hace "
                    + "referencia al tipo de PDF.", "Listado de contenedores", 0);

        } catch (DocumentException | IOException e) {
            System.err.print("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");   
        }  
      
    }
    
}