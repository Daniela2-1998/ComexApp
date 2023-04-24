package service;

import java.sql.Time;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface EmpleadosService {
    
    public boolean registroEmpleado(String area, String cargo, String empleado, 
            String empresa, Time horario, String status, Double sueldo, String usuario);
    
    public void modificarEmpleado(String area, String cargo, String empleado, 
            String empresa, Time horario, String status, Double sueldo, String usuario);
    
    public void obtenerDatosDelEmpleado(String buscar, 
            JTextField textID, JTextField textEmpleado, JTextField textEmpresa, 
            JTextField textUsuario, JTextField textCargo, JTextField textArea,
            JTextField textHorario, JTextField textSueldo, JComboBox cmbStatus);
    
    public boolean eliminarEmpleado(String empleado, int id);
    
}
