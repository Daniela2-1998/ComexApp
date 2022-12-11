package service;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface ImportadoresImpl {
    
    public boolean registroDeImportador(int ID, String cuit, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosPedidos, String status);
    
    public void modificarDatosImportador(String cuitMod, String empleado,
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosPedidosMod, String statusMod);
    
    public void obtenerDatosDelImportador(JTextField textImportadorBuscado, 
            JTextField textID, JTextField textCUIT, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextField textProductos, JComboBox cmbStatus);
    
    public boolean eliminarImportador(String empleado, int id);
}
