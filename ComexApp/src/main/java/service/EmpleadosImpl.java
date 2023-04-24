package service;

import config.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public class EmpleadosImpl implements EmpleadosService{
   
    
    // fields
    JTextField textEmpresa = new JTextField();
    JTextField textEmpleado = new JTextField();
    JTextField textUsuario = new JTextField();
    JTextField textArea = new JTextField();
    JTextField textCargo = new JTextField();
    JTextField textHorario = new JTextField();
    JTextField textSueldo = new JTextField();
    
    JComboBox cmbStatus = new JComboBox();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada;
    String mail;
    
    public boolean registroEmpleado(String area, String cargo, String empleado, 
            String empresa, Time horario, String status, Double sueldo, String usuario){
        
        Boolean recepcion;
        int avanzar = 0;

       if(empleado.equals("")){
           textEmpleado.setBackground(Color.red);
           avanzar++;
       }
       if(empresa.equals("")){
           textEmpresa.setBackground(Color.red);
           avanzar++;
       }
       if(area.equals("")){
           textArea.setBackground(Color.red);
           avanzar++;
       }
       if(cargo.equals("")){
           textCargo.setBackground(Color.red);
           avanzar++;
       }
       if(usuario.equals("")){
           textUsuario.setBackground(Color.red);
           avanzar++;
       }
        
        String sql = "insert into empleados (area, cargo, empleado, empresa, horario, "
                + "status, sueldo, usuario) values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        if(avanzar == 0){
            try{
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                
                pst.setString(1, area);
                pst.setString(2, cargo);
                pst.setString(3, empleado);
                pst.setString(4, empresa);
                pst.setTime(5, horario);
                pst.setString(6, status);
                pst.setDouble(7, sueldo);
                pst.setString(8, usuario);

                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el empleado  " 
                        + empleado + " de la empresa" + empresa);
                return recepcion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un "
                        + "empleado de " + empresa);
                System.err.println("No es posible crear un empleado" + e);
                return recepcion = false;
            }
            
        }
        return recepcionFuncion;
    }
    
    public void modificarEmpleado(String area, String cargo, String empleado, 
            String empresa, Time horario, String status, Double sueldo, String usuario){
        
        int alternativaMensaje;

        String sql = "update empleados set area=?, cargo=?, empleado=?, empresa=?, "
                + "horario=?, status=?, sueldo=?, usuario=? where empleado = '" 
                + empleado + "'";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);

            alternativaMensaje = JOptionPane.showConfirmDialog(null, "¿Quieres modificar los datos?");

            if (alternativaMensaje == 0) {

                pst.setString(1, area);
                pst.setString(2, cargo);
                pst.setString(3, empleado);
                pst.setString(4, empresa);
                pst.setTime(5, horario);
                pst.setString(6, status);
                pst.setDouble(7, sueldo);
                pst.setString(8, usuario);
                
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
    
    
    public void obtenerDatosDelEmpleado(String buscar, 
            JTextField textID, JTextField textEmpleado, JTextField textEmpresa, 
            JTextField textUsuario, JTextField textCargo, JTextField textArea,
            JTextField textHorario, JTextField textSueldo, JComboBox cmbStatus){

        String sql = "select * from empleados where empleado = '" + buscar + "' or "
                + "empresa = '" + buscar + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textID.setText(rs.getString("id_empleado"));
                textEmpresa.setText(rs.getString("empresa"));
                textArea.setText(rs.getString("area"));
                textEmpleado.setText(rs.getString("empleado"));
                textCargo.setText(rs.getString("cargo"));
                textHorario.setText(rs.getTime("horario").toString());
                Double sueldo = rs.getDouble("sueldo");
                String sueldoS = String.valueOf(sueldo);
                textSueldo.setText(sueldoS);
                textUsuario.setText(rs.getString("usuario"));
    
            } else {
                JOptionPane.showMessageDialog(null, "No es posible conseguir "
                        + "los datos del empleado solicitado");
                System.err.println("No es posible conseguir los datos del empleado solicitado");
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("Error al obtener los datos del empleado solicitado" + e);
            JOptionPane.showMessageDialog(null, "No se pueden obtener los datos del "
                    + "empleado solicitado");
        }
        
    }
     
    
    public boolean eliminarEmpleado(String empleado, int id){
       
        String sql = "delete from empleados where empleado = '" + empleado + "' "
               + "and id_empleado= '" + id + "'";
       
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
