package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class GastosImpl implements GastosService{

     // fields
    JTextField textValorCuotas = new JTextField();
    JTextField textTotal = new JTextField();
    JTextField textConcepto = new JTextField();
    JTextField textPagado = new JTextField();
    JTextArea textDetalles = new JTextArea();
    JComboBox cmbStatus = new JComboBox();
    JComboBox cmbCuotas = new JComboBox();
    JTextField textSinPagar = new JTextField();
    
    JTextField textBuscar= new JTextField();
    JTextField textID = new JTextField();
    

    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    
    
    
    public boolean registrarGasto(String conceptos, String empresa, double gastosTotales, 
            int cuotas, String detalles, double gastosPagados, double gastosSinPagar, 
            double montoCuotas, double intereses, String status){

        int avanzar = 0;

        String sql = "insert into gastos_operaciones (conceptos, empresa, "
                + "gastos_totales, cuotas, detalles, gastos_pagados, "
                + "gastos_sin_pagar, monto_cuotas, status, intereses) values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setString(1, conceptos);
                pst.setString(2, empresa);
                pst.setDouble(3, gastosTotales);
                pst.setInt(4, cuotas);
                pst.setString(5, detalles);
                pst.setDouble(6, gastosPagados);
                pst.setDouble(7, gastosSinPagar);
                pst.setDouble(8, montoCuotas);
                pst.setString(9, status);
                pst.setDouble(10, intereses);
                
                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el gasto correspondiente "
                        + "a " + conceptos + " de la empresa " + empresa + 
                        " pagandose en " + cuotas + " un monto total de " + gastosTotales);
                return recepcionFuncion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede registrar el gasto");
                System.err.println("No es posible registrar el gasto" + e);
                return recepcionFuncion = false;
            }

    }
     
    public void modificarGasto(String conceptos, String empresa, double gastosTotales, 
            int cuotas, String detalles, double gastosPagados, double gastosSinPagar, 
            double montoCuotas, String status, double intereses, String conceptoBuscado){
        
        int alternativaMensaje;

        String sql = "update gastos_operaciones set conceptos=?, empresa=?, "
                + "gastos_totales=?, cuotas=?, detalles=?, gastos_pagados=?, "
                + "gastos_sin_pagar=?, monto_cuotas=?, status=?, intereses=? "
                + "where conceptos = '" + conceptoBuscado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, conceptos);
                pst.setString(2, empresa);
                pst.setDouble(3, gastosTotales);
                pst.setInt(4, cuotas);
                pst.setString(5, detalles);
                pst.setDouble(6, gastosPagados);
                pst.setDouble(7, gastosSinPagar);
                pst.setDouble(8, montoCuotas);
                pst.setString(9, status);
                pst.setDouble(10, intereses);
                
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
    
    
    
    public void obtenerGasto(String buscar, JTextField textValorCuotas, 
            JTextField textTotal, JTextField textConcepto, JTextField textPagado,
            JTextArea textDetalles, JComboBox cmbStatus, JComboBox cmbCuotas,
            JTextField textSinPagar, JTextField textID){

        String sql = "select * from gastos_operaciones where conceptos = '" + buscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                textValorCuotas.setText(String.valueOf(rs.getDouble("monto_cuotas")));
                textTotal.setText(String.valueOf(rs.getDouble("gastos_totales")));
                textConcepto.setText(rs.getString("conceptos"));
                textPagado.setText(String.valueOf(rs.getDouble("gastos_pagados")));
                textDetalles.setText(rs.getString("detalles"));
                textSinPagar.setText(String.valueOf(rs.getDouble("gastos_sin_pagar")));
                textID.setText(String.valueOf(rs.getInt("id_gasto")));
                
                cmbCuotas.setSelectedItem(rs.getInt("cuotas"));
                
                String devolucionStatus = rs.getString("status");
                int status = 0;
                if(devolucionStatus.equals("Pago completo")){
                    status = 1;
                } else if(devolucionStatus.equals("Pago en partes")){
                    status = 2;
                } else if(devolucionStatus.equals("Pago en cuotas")){
                    status = 3;
                } else if(devolucionStatus.equals("Sin pagar")){
                    status = 4;
                }
                    
                cmbStatus.setSelectedItem(status);
                
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del gasto solicitado");
                System.err.println("No es posible conseguir los datos del gasto "
                        + "solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del gasto solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "gasto solicitado");
        }
        
    }
     
 
    
    public boolean eliminarGasto(String concepto, int id){
       
        String sql = "delete from gastos_operaciones where conceptos = '" + concepto + "' "
               + "and id_gasto = '" + id + "'";
       
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
