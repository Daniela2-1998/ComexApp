package service;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface DespachantesService {
    
    
    public boolean registroDeDespachante(int ID, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosAsociados, String status);
    
    public void modificarDatosDespachante(String empleado,String empleadoMod, 
            String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosAsociadosMod, String statusMod);
    
    public void obtenerDatosDelDespachante(JTextField textDespachanteBuscado, 
            JTextField textID, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextArea textProductos, JComboBox cmbStatus);
    
    public void obtenerNombreOIDDelDespachante(int ID, String nombreDespachante);
    
    public void obtenerDatosDeProductosDelDespachante(JTextField textDespachanteBuscado, 
            JTextField textDespachante, JTextArea textProductos1);
    
    public int obtenerIDDespachante(String empresa, String empleado);
    
    public boolean eliminarDespachante(String empleado, int id);
}
