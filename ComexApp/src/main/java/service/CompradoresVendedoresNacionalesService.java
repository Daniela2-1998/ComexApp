package service;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface CompradoresVendedoresNacionalesService {
    
    public boolean registroCompradorVendedor(String nombre, String empresa, 
            String pais, String mail, String telefono, String productos, 
            String status, String operacion);
    
    public void modificarDatos(String buscado, String nombre, String empresa, 
            String pais, String mail, String telefono, String productos, 
            String status, String operacion);
    
    public void obtenerDatosCompradorVendedor(String buscado, JTextField textNombre2, 
            JTextField textEmpresa1, JTextField textMail1, JTextField textTel1, 
            JTextField textPais1, JTextArea textProductos1, JComboBox cmbStatus1, 
            JComboBox cmbOperacion1);

    public boolean existeComprador(String nombre);
    
    public boolean existeVendedor(String nombre);
    
    public boolean eliminar(String nombre, int id);
    
}
