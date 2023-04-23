package service;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface AereoService {
    
    
    public boolean registroAereo(int ID, String mail, String empleado, 
            String empresa, String numeroContacto, String requisitos);
    
    public void modificarAereo(String empleado,int IDMod, String mailMod, String empleadoMod, 
            String empresaMod, String numeroContactoMod, String requisitosMod);
    
    public void obtenerDatosDeAereo(JTextField textAereoBuscado, 
            JTextField textID, JTextField textMail, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textNumero, JTextArea textRequisitos);
    
    public String obtenerMailDeAereo(String nombre);
    
    public boolean eliminarAereo(String empleado, int id);
}
