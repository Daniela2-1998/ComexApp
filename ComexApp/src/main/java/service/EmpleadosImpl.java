package service;

import Daniela.ComexApp.Frames.Empleados;
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
   
    

    JComboBox cmbStatus = new JComboBox();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean recepcionFuncion, modificacionEstado, eliminacionAprobada, usuarioAsociado;
    String mail;
    
    
    public boolean registroEmpleado(String area, String cargo, String empleado, 
            String empresa, Time horario, Time horarioSalida, String status, 
            Double sueldo, String usuario){
        
        Boolean recepcion;
        int avanzar = 0;

        String sql = "insert into empleados (area, cargo, empleado, empresa, horario, "
                + "status, sueldo, usuario, horario_salida) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
                pst.setTime(9, horarioSalida);

                pst.executeUpdate();
                conec.close();
                
                JOptionPane.showMessageDialog(null, "Se añadió el empleado  " 
                        + empleado + " de la empresa" + empresa);
                recepcionFuncion = true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se puede crear un "
                        + "empleado de " + empresa);
                System.err.println("No es posible crear un empleado" + e);
                recepcionFuncion = false;
            }
            
        return recepcionFuncion;
    }
    
    public void modificarEmpleado(String area, String cargo, String empleado, 
            String empresa, Time horario, Time horarioSalida, String status, 
            Double sueldo, String usuario){
        
        int alternativaMensaje;

        String sql = "update empleados set area=?, cargo=?, empleado=?, empresa=?, "
                + "horario=?, status=?, sueldo=?, usuario=?, horario_salida=? "
                + "where empleado = '" + empleado + "'";

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
                pst.setTime(9, horarioSalida);
                
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
            JTextField textHorario, JTextField textHorarioSalida, 
            JTextField textSueldo, JComboBox cmbStatus){

        String sql = "select id_empleado, area, cargo, empleado, empresa, horario, "
                + "sueldo, usuario, horario_salida, status from empleados where "
                + "empleado = '" + buscar + "'";
        
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
                textHorarioSalida.setText(rs.getTime("horario_salida").toString());
                Double sueldo = rs.getDouble("sueldo");
                String sueldoS = String.valueOf(sueldo);
                textSueldo.setText(sueldoS);
                textUsuario.setText(rs.getString("usuario"));
                
                String status = rs.getString("status");
                Empleados empleadosF = new Empleados();
                int statusNivel = empleadosF.recuperarValorNumDelStatus(status);
                cmbStatus.setSelectedItem(statusNivel);
    
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

    public boolean empleadoAsociadoANombre(String usuario){
        
        String sql = "select nombre from empleados where usuario = '" + usuario + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                usuarioAsociado = true;
                JOptionPane.showMessageDialog(null, "Ya existe un empleado relacionado "
                        + "con este usuario");
            } else {
                usuarioAsociado = false;
            }
            
        }catch(SQLException e){
            System.err.println("No se puede realizar la busqueda de asociación "
                    + "de usuario con empleado");
        }
        return usuarioAsociado;
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
