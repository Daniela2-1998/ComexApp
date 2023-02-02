package service;

import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class Mensajes implements MensajesImpl {

    @Override
    public void mensajeErrorAlIniciarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mensajeIngresandoAlSistema() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mensajeConfirmarSalir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mensajeConfirmarModificacionDatos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void notificacionMensajesDeObjetivosSinVer(String titulo, Date 
            fechaPublicacion, Time horaPublicacion){
        
        String botones[] = {"Marcar como visto", "Cancelar"};
        
        int eleccion = JOptionPane.showOptionDialog(null, "Tienes mensajes sin leer "
                + "relacionados con objetivos en los que estás incluido.", 
                "Mensajes disponibles", 0, 0, null, botones, this);
       
        if(eleccion == JOptionPane.YES_OPTION){
            
            MensajesDeObjetivosImpl mensajesObjetivosImpl = new MensajesDeObjetivosImpl();
            mensajesObjetivosImpl.marcarMensajesComoVisto(titulo);
            
        } else if(eleccion == JOptionPane.NO_OPTION){
            System.out.println("El mensaje no fue marcado como visto.");
            JOptionPane.showMessageDialog(null, "El mensaje continuará sin ser visto.");
        }
    }
    
}
