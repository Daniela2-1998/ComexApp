package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class ContenedoresImpl implements ContenedoresService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    // fields
    JTextField textID = new JTextField();
    JTextField textCantidad = new JTextField();
    JTextField textCodigo = new JTextField();
    JTextField textCapacidad = new JTextField();
    JTextField textEmpresa = new JTextField();
    JTextField textPrecioUnitario = new JTextField();
    JTextField textReserva = new JTextField();
    JTextField textTipo = new JTextField();
    JTextField textCompañiaTransporte = new JTextField();
    JTextField textProducto = new JTextField();
    
  
    JTextField textFechaUltimo = new JTextField();
    JTextField textFechaProximo = new JTextField();
    
    JComboBox cmbStatus = new JComboBox();
    
    int cantidadBase;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    
    
    
    
    public boolean registrarContenedor(int ID, int cantidadProductos, double capacidad, 
            String codigo, String empresa, String producto, String tipo, 
            String compañiaTransporte, Date proximoControl, String reserva, 
            String status, Date ultimoControl){
        
        Boolean recepcion = null;
        int aprobado = 0;
        
        if(cantidadProductos < 0){
            aprobado++;
        }
        if(capacidad < 0){
            aprobado++;
        }
        if(codigo.equals("")){
            aprobado++;
        }
        if(codigo.equals("")){
            aprobado++;
        }
        
        if(aprobado == 0){
             
        String sql = "insert into contenedores values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setInt(1, ID);
                pst.setInt(2, cantidadProductos);
                pst.setDouble(3, capacidad);
                pst.setString(4, codigo);
                pst.setString(5, empresa);
                pst.setString(6, producto);
                pst.setString(7, tipo);
                pst.setString(8, compañiaTransporte);
                pst.setDate(9, proximoControl);
                pst.setString(10, reserva);
                pst.setString(11, status);
                pst.setDate(12, ultimoControl);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió un nuevo contenedor "
                        + "al stock del sistema ComexApp");
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede añadir un nuevo "
                        + "contenedor al sistema");
                System.err.println("No se puede añadir un nuevo contenedor al sistema" + e);
              return recepcion = false;
            }
        }
        return recepcion;
            
    }
    
    
    
    public void modificarContenedor(int IDMod, int cantidadProductosMod, double capacidadMod, 
            String codigoMod, String empresaMod, String productoMod, String tipoMod, 
            String compañiaTransporteMod, String reservaMod, String statusMod, String codigo){
        
        int alternativaMensaje;

        String sql = "update contenedores set id_contenedor=?, cantidad=?, capacidad=?, "
                + "codigo=?, empresa=?, productos=?, tipo=?, compañia_transporte=?, "
                + "reserva=?, status=? where nombre_producto = '" + codigo + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setInt(1, IDMod);
                pst.setInt(2, cantidadProductosMod);
                pst.setDouble(3, capacidadMod);
                pst.setString(4, codigoMod);
                pst.setString(5, empresaMod);
                pst.setString(6, productoMod);
                pst.setString(7, tipoMod);
                pst.setString(8, compañiaTransporteMod);
                pst.setString(9, reservaMod);
                pst.setString(10, statusMod);
                
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
    
    
    public void modificarFechasProximo(Date proximoControlMod, String codigo){
        
        int alternativaMensaje;

        String sql = "update contenedores set proximo_control=? where codigo = '" + codigo + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setDate(1, proximoControlMod);
                
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
    
    public void modificarFechaUltimo(Date ultimoControlMod, String codigo){
        
        int alternativaMensaje;

        String sql = "update contenedores set ultimo_control=? where codigo = '" + codigo + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setDate(1, ultimoControlMod);
                
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
    
    public int obtenerIDConCodigoDelContenedor(String codigo){
        
        int IDContenedor = 0;
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select id_contenedor from contenedores where "
                    + "codigo = '" + codigo + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                IDContenedor = rs.getInt("id_contenedor");
            }
            
        }catch(SQLException e){
            System.err.println("No se puede obtener el ID del contenedor " + e);
        }
        return IDContenedor;
    }
    
    
    public boolean eliminarRegistroContenedor(String codigo, int id){
       
        String sql = "delete from contenedores where codigo = '" + codigo + "' "
               + "and id_contenedor = '" + id + "'";
       
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
