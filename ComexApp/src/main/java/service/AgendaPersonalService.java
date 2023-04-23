package service;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface AgendaPersonalService {
    
    public boolean registroContactoAgendaPersonal(int ID, String nombre, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosAsociados, String status, String usuario, String cargo);
    
    public void modificarDatosContactoAgendaPersonal(int IDMod, String nombreMod, 
            String empresaMod, String mailMod, String numeroContactoMod, String paisMod,
            String productosAsociadosMod, String statusMod, String cargoMod, 
            String nombre, String usuario);
    
    public void obtenerDatosDelContactoPersonal(JTextField textBuscar, 
            JTextField textID, JTextField textEmpleado, JTextField textEmpresa, 
            JTextField textMail, JTextField textNumero, JTextField textPais, 
            JTextArea textProductos, JComboBox cmbStatus, JComboBox cmbCargo);
    
    public String obtenerMailDelContactoPersonal(String nombre);
    
    public boolean eliminarContactoPersonal(String nombre, int id);
    
    
}
