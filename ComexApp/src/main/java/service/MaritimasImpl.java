package service;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface MaritimasImpl {
    
    
    public boolean registroDeMaritima(int ID, String mail, String empleado, 
            String empresa, String numeroContacto, String requisitosAviso, 
            String tipoTransporte);
     
    public void modificarMaritima(String mailMod, String empleado,
            String empleadoMod, String empresaMod, String numeroContactoMod,
            String requisitosAvisoMod, String tipoTransporteMod);
     
    public void obtenerDatosDeLaMaritima(JTextField textMaritimaBuscada, 
            JTextField textID, JTextField textmail, JTextField textEmpleado, 
            JTextField textEmpresa, JTextField textNumero, JTextArea textRequisitosAviso, 
            JTextArea textTipoTransporte);
     
    public boolean eliminarMaritima(String empleado, int id);
}
