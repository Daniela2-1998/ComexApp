package service;

import com.toedter.calendar.JDateChooser;
import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class OperacionesInternacionalesImpl implements OperacionesInternacionalesService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    // fields
    JTextField textID = new JTextField();
    JTextField textCodigo = new JTextField();
    JTextField textNumeroEmbarque = new JTextField();
    JTextField textContenedores = new JTextField();
    JTextField textCantidad = new JTextField();
    JTextField textComprador = new JTextField();
    JTextField textVendedor = new JTextField();
    JTextArea textProductos = new JTextArea();
    JComboBox cmbTipoOperacion = new JComboBox();
    JTextArea textDetalle = new JTextArea();
    JTextField textPaisOrigen = new JTextField();
    JTextField textPrecioTotal = new JTextField();
    
    JTextField textBuscar = new JTextField();
    
    JDateChooser jDateChooserRegistro = new JDateChooser();
    JDateChooser jDateChooserRecibo = new JDateChooser();
    
    JComboBox cmbStatus = new JComboBox();
    
    int cantidadBase;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    
    public boolean ingresoOperacionInternacional(int ID, int cantidadContenedor,
            String codigo, String numeroEmbarque, String producto,
            String tipoOperacion, String cantidadProducto, String status,
            String comprador, String precioTotal, String vendedor, String detalles,
            String paisOrigen, String nombreBuque, Date fechaRegistro, Date fechaArribo){
        
        Boolean recepcion;
        int avanzar = 0;

       if(producto.equals("")){
           textProductos.setBackground(Color.red);
           avanzar++;
       }
      
       if(detalles.equals("")){
           textDetalle.setBackground(Color.red);
           avanzar++;
       }
       
       if(comprador.equals("")){
           textComprador.setBackground(Color.red);
           avanzar++;
       }
       
        if(vendedor.equals("")){
           textVendedor.setBackground(Color.red);
           avanzar++;
       }
        
        if(paisOrigen.equals("")){
           textPaisOrigen.setBackground(Color.red);
           avanzar++;
       }
       
        
        String sql = "insert into operaciones values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setInt(2, cantidadContenedor);
                pst.setString(3, codigo);
                pst.setString(4, numeroEmbarque);
                pst.setString(5, producto);
                pst.setString(6, tipoOperacion);
                pst.setString(7, cantidadProducto);
                pst.setString(8, status);
                pst.setString(9, comprador);
                pst.setString(10, precioTotal);
                pst.setString(11, vendedor);
                pst.setString(12, detalles);
                pst.setString(13, paisOrigen);
                pst.setString(14, nombreBuque);
                pst.setDate(15, fechaRegistro);
                pst.setDate(16, fechaArribo);
                
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió una nueva operación "
                        + " correspondiente al producto '" + producto + "' de la empresa " +
                        vendedor + " \n\n que llegaría el día " + fechaArribo + " en el contenedor " 
                        + codigo + " según el embarque del buque " + nombreBuque + 
                        "\n\n  con el número de embarque " + numeroEmbarque + "");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede añadir una nueva "
                        + "operación al sistema");
                System.err.println("No se puede añadir una nueva operación al sistema" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
    public void detallesTablasExtraDeOperacionesInternacionales(int IDOperacion, 
            int IDAereo, String compañiaAerea){
        
        String sql = "insert into operaciones_aereo values (?, ?, ?)";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, IDOperacion);
            pst.setInt(2, IDAereo);
            pst.setString(3, compañiaAerea);
            
            pst.executeUpdate();
            System.out.println("Nuevo registro en la tabla de operaciones aereo");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar en base de datos "
                    + "complementarios de la operación");
            System.err.println("Error al cargar en base de datos los datos complementarios"
                    + "de la operación " + e);
        }
        
    }
    
    
    public void detallesTablasExtraContenedor(int IDOperacion, int IDContenedor, 
            String compañiaContenedor){
        
     String sql = "insert into operaciones_contenedores values (?, ?, ?)";
    
     try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, IDOperacion);
            pst.setInt(2, IDContenedor);
            pst.setString(3, compañiaContenedor);
            
            pst.executeUpdate();
            conec.close();
            
            System.out.println("Nuevo registro en la tabla de operaciones compra internacional");
            
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar en base de datos "
                    + "de contenedores de la operación");
            System.err.println("Error al cargar en base de datos los datos de contenedores"
                    + "de la operación " + e);
         }
     }
    
    public void detallesTablasExtraDespachante(int IDOperacion, int IDDespachante,
            String nombreDespachante){
        
     String sql = "insert into operaciones_despachante values (?, ?, ?)";
    
     try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, IDOperacion);
            pst.setString(2, nombreDespachante);
            pst.setInt(3, IDDespachante);
            
            pst.executeUpdate();
            conec.close();
            
            System.out.println("Nuevo registro en la tabla de operaciones compra internacional");
            
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar en base de datos "
                    + "de despachantes de la operación");
            System.err.println("Error al cargar en base de datos los datos de despachantes"
                    + "de la operación " + e);
         }
     }
    
     public void detallesTablasExtraExportador(int IDOperacion, int IDExportador,
            String nombreExportador){

         String sql = "insert into operaciones_expo values (?, ?, ?)";

         try{
             conec = cn.Conexion();
             pst = conec.prepareStatement(sql);
            
             pst.setInt(1, IDOperacion);
             pst.setInt(2, IDExportador);
             pst.setString(3, nombreExportador);
            
             pst.executeUpdate();
             conec.close();
            
             System.out.println("Nuevo registro en la tabla de operaciones compra internacional");
            
        
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar en base de datos "
                    + "de exportadores de la operación");
            System.err.println("Error al cargar en base de datos los datos de exportadores"
                    + "de la operación " + e);
         }
     }
    
     public void detallesTablasExtraMaritimas(int IDOperacion, int IDMaritima,
             String maritima){

         String sql = "insert into operaciones_maritimas values (?, ?, ?)";

         try{
             conec = cn.Conexion();
             pst = conec.prepareStatement(sql);
            
             pst.setInt(1, IDOperacion);
             pst.setInt(2, IDMaritima);
             pst.setString(3, maritima);
            
             pst.executeUpdate();
             conec.close();
            
             System.out.println("Nuevo registro en la tabla de operaciones compra internacional");
            
        
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar en base de datos "
                    + "de maritimas de la operación");
            System.err.println("Error al cargar en base de datos los datos de maritimas"
                    + "de la operación " + e);
         }
     }
     
       public void detallesTablasExtraProducto(int IDOperacion, int IDProducto,
             String producto){

         String sql = "insert into operaciones_productos values (?, ?, ?)";

         try{
             conec = cn.Conexion();
             pst = conec.prepareStatement(sql);
            
             pst.setInt(1, IDOperacion);
             pst.setInt(2, IDProducto);
             pst.setString(3, producto);
            
             pst.executeUpdate();
             conec.close();
            
             System.out.println("Nuevo registro en la tabla de operaciones compra internacional");
            
        
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar en base de datos "
                    + "de productos de la operación");
            System.err.println("Error al cargar en base de datos los datos de productos"
                    + "de la operación " + e);
         }
     }
     
     
     
     
    public void modificarOperacionInternacional(int IDMod, int cantidadContenedorMod,
            String codigoMod, String numeroEmbarqueMod, 
            String productoMod, String tipoOperacionMod, String cantidadProductoMod, 
            String statusMod, String compradorMod, String precioTotalMod, 
            String vendedorMod, String detallesMod, String paisOrigenMod, 
            String nombreBuqueMod, String producto){
        
        int alternativaMensaje;

        String sql = "update operaciones set id_operaciones=?, cantidad_contenedores=?, "
                + "codigo_contenedores=?, numero_embarque=?, producto=?, tipo_operacion=?, "
                + "cantidad_producto=?, status=?, comprador=?, "
                + "precio_total=?, vendedor=?, detalles=?, pais_origen=?, "
                + "nombre_buque=? where producto = '" + producto + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setInt(1, IDMod);
                pst.setInt(2, cantidadContenedorMod);
                pst.setString(3, codigoMod);
                pst.setString(4, numeroEmbarqueMod);
                pst.setString(5, productoMod);
                pst.setString(6, tipoOperacionMod);
                pst.setString(7, cantidadProductoMod);
                pst.setString(8, statusMod);
                pst.setString(9, compradorMod);
                pst.setString(10, precioTotalMod);
                pst.setString(11, vendedorMod);
                pst.setString(12, detallesMod);
                pst.setString(13, paisOrigenMod);
                pst.setString(14, nombreBuqueMod);

                
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para "
                    + "modificar datos" + e);
        }
    }
    
    
    
    public void modificarFechaIngreso(int ID, String producto, Date fechaArriboMod){
        
        int alternativaMensaje;

        String sql = "update operaciones set fecha_arribo=? where producto = '" 
                + producto + "' and id_operaciones = '" + ID +"'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setDate(1, fechaArriboMod);
                pst.executeUpdate();
                conec.close();
                JOptionPane.showMessageDialog(null, "Modificación éxitosa");

            } else {
                conec.close();
                JOptionPane.showMessageDialog(null, "No se modificaron los datos");
            }

        } catch (SQLException e) {
            System.err.println("No se pudo conectar con la base de datos para "
                    + "modificar datos" + e);
        }
    }
     
    
    public void cambiarStatusCuandoIngresaProducto(){
        
        Date fechaActual = Date.valueOf(LocalDate.now());
        
        String sql = "update operaciones set status=? where fecha_arribo <= '" 
                + fechaActual + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            pst.setString(1, "Completada");
            pst.executeUpdate();
            conec.close();
            
         }catch(SQLException e){
            System.err.println("No se puede realizar el cambio de status. " + e);
        }
        
    }
    
    
    
    public boolean eliminarOperacion (String producto, int id){
       
        String sql = "delete from operaciones where producto = '" + producto + "' "
               + "and id_operaciones = '" + id + "'";
       
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
