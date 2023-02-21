package service;

import Daniela.ComexApp.Frames.AdministrarUsuarios;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class MensajesImpl implements MensajesService {

    @Override
    public void mensajeErrorAlIniciarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void mensajeIngresandoAlSistema() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void avisoEsperarConfirmacionDeAcceso(String usuario){
        
        String mensaje = "Se creó correctamente el usuario de " + usuario;
        String mensajeDos = "Aún debes esperar a que se te habilite la cuenta.";
        
        JOptionPane.showMessageDialog(null, mensaje + " \n\n" + mensajeDos, "Espera de confirmación", 0);
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
    
    public void notificacionOperacionesInternacionalesDelDia(int cantidadOperacionesInternacionales){
        
        String botones[] = {"Aceptar"};
        String mensaje = "Tienes " + cantidadOperacionesInternacionales + " "
                + "operaciones internacionales en el día de hoy.";
        
        JOptionPane.showOptionDialog(null, mensaje, "Carga internacional arribando"
                , 0, 0, null, botones, this);
    }
    
    public void notificacionOperacionesNacionalesDelDia(int cantidadOperacionesNacionales){
        
        String botones[] = {"Aceptar"};
        String mensaje = "Tienes " + cantidadOperacionesNacionales + " "
                + "operaciones nacionales en el día de hoy.";
        
        JOptionPane.showOptionDialog(null, mensaje, "Carga nacional arribando"
                , 0, 0, null, botones, this);
    }
    
    public void notificacionUsuariosSolicitandoAccesoAlSistema(String usuario, 
            String usuarioSolicitando){
        
        String botones[] = {"Permitir acceso", "Ver lista completa", "Denegar acceso"};
        String mensaje = usuario + " hay nuevos usuarios solicitando ingreso al sistema (" + 
                usuarioSolicitando + " y otros).";
        
        int eleccion = JOptionPane.showOptionDialog(null, mensaje, "Usuarios solicitando "
                + "acceso al sistema", 0, 0, null, botones, this);
        
        if(eleccion == JOptionPane.YES_OPTION){
            
            UsuariosImpl usuariosImpl = new UsuariosImpl();
            usuariosImpl.darUsuarioAcceso();
            
        } else if (eleccion == JOptionPane.NO_OPTION){
            
            AdministrarUsuarios administrarUsuarios = new AdministrarUsuarios();
            administrarUsuarios.setVisible(true);
            
        } else if(eleccion == JOptionPane.CANCEL_OPTION){
            
            JOptionPane.showMessageDialog(null, "En la sección de administrar "
                    + "usuarios podrás eliminar al usuario correspondiente");
            
        }
    }
    
    public void notificacionTiempoCuentaRegresivaCumplida(String detalle, Date 
            diaObjetivo, Time horaObjetiva){
        
        String botones[] = {"Aceptar", "Cerrar"};
        
        JOptionPane.showOptionDialog(null, "El tiempo de tu cuenta "
                + "regresiva llegó a 0.", "Cuenta regresiva en 0", 0, 0, null, botones, this);
    }
    
}
