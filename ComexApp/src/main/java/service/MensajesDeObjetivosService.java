package service;

import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Daniela
 */
public interface MensajesDeObjetivosService {
    
    
    public boolean crearMensaje(int ID, String contenido, String objetivoAsociado, 
            String titulo, String usuario, String visibilidad, Date fechaPublicacion);
     
    public void obtenerMensajeBuscado(String busquedaMensaje, JLabel jLabelFechaMensaje, 
            JLabel jLabelObjetivoAsociado, JLabel jLabelTituloMensaje, 
            JTextArea textMensaje, JLabel jLabelUsuario);
    
    public Boolean verificarMensajesSinVer(String usuario, String rol);
    
    public void marcarMensajesComoVisto(String titulo);
    
    public boolean eliminarMensajeDeObjetivo(String usuario, int id);
    

}
