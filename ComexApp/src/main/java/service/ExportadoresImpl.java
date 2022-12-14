package service;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface ExportadoresImpl {
    
     public boolean registroDeExportador(int ID, String cuit, String empleado, 
            String empresa, String mail, String numeroContacto, String pais,
            String productosPedidos, String status);
     
     public void modificarDatosExportador(String cuitMod, String empleado,
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod,
            String paisMod, String productosPedidosMod, String statusMod);
     
     public void obtenerDatosDelExportador(JTextField textExportadorBuscado, 
            JTextField textID, JTextField textCUIT, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textMail, JTextField textNumero, 
            JTextField textPais, JTextArea textProductos, JComboBox cmbStatus);
      
     public boolean eliminarExportador(String empleado, int id);
     
}
