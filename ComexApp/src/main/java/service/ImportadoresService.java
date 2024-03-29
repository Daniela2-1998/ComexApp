package service;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface ImportadoresService {
    
    public boolean registroDeImportador(int ID, String cuit, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosPedidos, String status);
    
    public void modificarDatosImportador(String cuitMod, String empleado,
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosPedidosMod, String statusMod);
    
    public void obtenerDatosDelImportador(JTextField textImportadorBuscado, 
            JTextField textID, JTextField textCUIT, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextArea textProductos, JComboBox cmbStatus);
    
    public int obtenerIDImportador(String empresa, String empleado);
    
    public String obtenerMailDelImportador(String nombre);
    
    public boolean eliminarImportador(String empleado, int id);
}
